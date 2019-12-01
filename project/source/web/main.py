from google.oauth2 import service_account
from google.auth.transport.requests import AuthorizedSession
from starlette.applications import Starlette
from starlette.templating import Jinja2Templates
from starlette.responses import JSONResponse, PlainTextResponse
from prediction import predict
import uvicorn
import json
import requests
import os

scopes = [
  "https://www.googleapis.com/auth/userinfo.email",
  "https://www.googleapis.com/auth/firebase.database"
]
templates = Jinja2Templates(directory='templates')

app = Starlette(debug=True)
credentials = service_account.Credentials.from_service_account_file("./serviceKey.json", scopes=scopes)
authed_session = AuthorizedSession(credentials)

@app.route('/auth')
async def show_index(request):
    return templates.TemplateResponse('index.html', {'request': request})

@app.route('/auth',methods=["POST"])
async def firebase_login(request):
    body = await request.form()
    email = body['email']
    password = body['password']

    request_ref = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyBrnRxGfzyWvLZu9XMUnbZTPpu8NxHBRE0"
    headers = {"content-type": "application/json; charset=UTF-8"}
    data = json.dumps({"email": email, "password": password, "returnSecureToken": True})
    response = requests.post(request_ref, headers=headers, data=data)
 
    if response.status_code!=200:
        try:
            message = json.loads(response._content)['error']['message']
        except:
            message = "Some error Occured."
        return templates.TemplateResponse('login.html', {'request': request, 'err_msg':message})
    else:
        return templates.TemplateResponse('index.html', {'request': request})


@app.route('/registration',methods=["POST"])
async def firebase_register(request):
    body = await request.form()
    email = body['email']
    password = body['pass1']
    confirm = body['pass2']

    if password!=confirm:
        message = 'Password do not match.'
        return templates.TemplateResponse('register.html', {'request': request, 'err_msg':message})

    request_ref = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/signupNewUser?key=AIzaSyBrnRxGfzyWvLZu9XMUnbZTPpu8NxHBRE0"
    headers = {"content-type": "application/json; charset=UTF-8" }
    data = json.dumps({"email": email, "password": password, "returnSecureToken": True})
    response = requests.post(request_ref, headers=headers, data=data)

    if response.status_code!=200:
        try:
            message = json.loads(response._content)['error']['message']
        except:
            message = '<div class="alert alert-danger" role="alert">'+"Some error Occured."+"</div>"
        return templates.TemplateResponse('register.html', {'request': request, 'err_msg':message})
    else:
        message = "Successfully registered."
        return templates.TemplateResponse('login.html', {'request': request, 'err_msg':message})

@app.route('/')
async def login(request):
    message = ''
    return templates.TemplateResponse('login.html', {'request': request,'err_msg':message})

@app.route('/register')
async def login(request):
    message = ''
    return templates.TemplateResponse('register.html', {'request': request,'err_msg':message})

@app.route('/contribute')
async def contrbPage(request):
    return templates.TemplateResponse('contribute.html', {'request': request})

@app.route('/{prompt}')
async def getEssay(request):
    prompt = request.path_params['prompt']
    response = authed_session.get("https://softlab-ba722.firebaseio.com/"+prompt+".json")
    if response.json() is None:
        data = [{"essay":"No essays found","score":""}]
    else:
        data = response.json().values()
    return templates.TemplateResponse('topic.html', {'request': request,'essayResponse':data,'topic':prompt})

@app.route('/evaluateFile',methods=["POST"])
async def evaluateFile(request):
    body = await request.form()
    contents = await body["essayFile"].read()
    contents = contents.decode('utf-8')
    score = predict(contents)
    score = round(float(score)/60*100,2)
    return templates.TemplateResponse('score.html', {'request': request, 'score':score})

@app.route('/evaluate',methods=["POST"])
async def evaluate(request):
    body = await request.form()
    score = predict(body['essay'])
    score = round(float(score)/60*100,2)
    return templates.TemplateResponse('score.html', {'request': request, 'score':score})

@app.route('/contribute',methods=["POST"])
async def evaluate(request):
    body = await request.form()
    score, essay, prompt = body['score'], body['essay'], body['prompt']
    # score = float(score)/100
    json = { 
        "essay": essay,
        "score": score
    }
    message = "Success, Thanks for your invaluable contribution!"
    response = authed_session.post("https://softlab-ba722.firebaseio.com/"+prompt+"/.json",None,json)
    
    if response.status_code!=200:
        message = "Oops some error occured please try after some time."
    return templates.TemplateResponse('thanks.html', {'request': request, 'score':score, 'message':message, 'essay':essay})

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    uvicorn.run(app, host='0.0.0.0', port=port)
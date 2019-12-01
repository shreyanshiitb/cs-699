import re
import sys

premi = []
contacts = {}
matchNum = re.compile('[^a-zA-Z0-9][1-9][0-9]{9}[^0-9a-zA-Z]')
# here we are not counting cases like student9891800065 where a valid 10 digit number is preceded immediately by some text. 
matchMail = re.compile('[a-zA-Z0-9]+[a-zA-Z0-9._]*@[a-zA-Z0-9]+[a-zA-Z0-9.]*[a-zA-Z]+')
with open(sys.argv[1]) as f:
    for line in f:
        a = matchNum.findall(line)
        b = matchMail.findall(line)
        [premi.append(i[1:-1]) for i in a]
        [premi.append(j) for j in b]
    contacts = {doosra:premi.count(doosra) for doosra in premi}

loverfreq = contacts[sys.argv[2]] if sys.argv[2] in contacts.keys() else 0

fraud = [i for i,j in contacts.items() if j>loverfreq ]
if len(fraud)==0:
    print('It’s all good yo!')
else:
    [print('Cheater alert!',i,contacts[i]) for i in fraud]

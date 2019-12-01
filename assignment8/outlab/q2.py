from bs4 import BeautifulSoup 
import getpass 
import requests
import warnings
import sqlite3
warnings.filterwarnings("ignore")

class CS699:
    def __init__(self):
        self.conn = sqlite3.connect('CS699_DB.db')
        self.cursorObj = self.conn.cursor()
        self.cursorObj.execute('CREATE TABLE IF NOT EXISTS ANNOUNCEMENT_INFO (Topic text,Comment text, Topic_Date date);')
        self.conn.commit()

    def login(self,username,password):
        self.session_requests = requests.session()
        login_url = 'https://moodle.iitb.ac.in/login/index.php'
        values = {'username': username,'password': password}
        result = self.session_requests.post(login_url,data=values)
        error = BeautifulSoup(result.content).find('a',attrs={'id':'loginerrormessage'})
        return False if error else result
        
    def populate(self,homepage):
        courseLink = BeautifulSoup(homepage.content).find('h3',attrs={'class':'coursename'},text='CS 699-2019-1 Software Lab.').a['href']
        coursePage = self.session_requests.get(courseLink)
        announcementLink = BeautifulSoup(coursePage.content).find('span',attrs={'class':'instancename'}).parent['href']
        announcements = self.session_requests.get(announcementLink)
        table = BeautifulSoup(announcements.content).find('table',attrs={'class':'forumheaderlist'})
        kanojiaThreads = table.findAll('td',attrs={'class':'author'})
        for thread in kanojiaThreads:
            if thread.text == 'Diptesh Kanojia':
                insertList = []
                threadParent = thread.parent
                linkInfo = threadParent.find('td',attrs={'class':'topic starter'}).find('a')['href']
                threadDicussion = BeautifulSoup(self.session_requests.get(linkInfo).content)
                subject = threadDicussion.find('div',attrs={'class':'subject'})
                author = threadDicussion.find('div',attrs={'class':'author'})
                date = author.text.split('-')[1]
                message = threadDicussion.find('div',attrs={'class':'posting fullpost'})
                insertList.append(subject.text)
                insertList.append(message.text)
                insertList.append(date)
                self.cursorObj.execute('INSERT INTO ANNOUNCEMENT_INFO (Topic,Comment,Topic_Date) VALUES (?,?,?);', insertList)
                self.conn.commit()

    def print_all(self):
        for row in self.cursorObj.execute('SELECT * FROM ANNOUNCEMENT_INFO'):
            print(row[0],row[1],row[2],sep='\t')

obj = CS699()
print('Enter ldap Username:-')
username = input()
print('Enter ldap Password:-')
password = getpass.getpass()
status = obj.login(username,password)
if status:
    obj.populate(status)
    obj.print_all()
else:
    print('Invalid login, please try again')

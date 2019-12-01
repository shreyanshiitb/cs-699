import sqlite3
import sys
import csv


class Employee:

    def __init__(self):
        self.conn = sqlite3.connect('employeeDB.db')
        self.cursorObj = self.conn.cursor()
        self.cursorObj.execute('CREATE TABLE IF NOT EXISTS employeeInfo (Name text,ID integer NOT NULL PRIMARY KEY, Salary integer, City text);')
        self.conn.commit()

    def populate_table(self,tablePath):
        insertList = []
        with open(tablePath) as rows:
            rowList = csv.reader(rows)
            for row in rowList:
                insertList.append((row[0],row[1],row[2],row[3]))

        self.cursorObj.executemany('INSERT INTO employeeInfo (Name,ID,Salary,City) VALUES (?,?,?,?);', insertList)
        self.conn.commit()

    def print_all(self):
        for row in self.cursorObj.execute('SELECT * FROM employeeInfo'):
            print(row[0],row[1],row[2],row[3],sep='\t')

    def highest_salary(self):
        self.cursorObj.execute('SELECT * FROM employeeInfo where Salary=(SELECT Max(Salary) from employeeInfo);')
        maxSalary = list(self.cursorObj.fetchone())
        print(maxSalary[0],maxSalary[1],maxSalary[2],maxSalary[3],sep='\t')

emp = Employee()
emp.populate_table(sys.argv[1])
emp.highest_salary()
emp.print_all()


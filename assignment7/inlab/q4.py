import sys

class Student:
    num_students = 0
    def __init__(self):
        self.grades = []
        self.credits = []
    def CPI(self,grades,credits):
        self.grades = grades
        self.credits = credits
        c = [a*b for a,b in zip(grades,credits)]
        print('%.4f'%(sum(c)/sum(self.credits)))


student_grade_list = []
student_credits_list = []

count = 0
with open(sys.argv[1]) as f:
    for line in f:
        if count ==0:
            student_grade_list.append(list(map(float,line.split())))
            count+=1
        elif count==1:
            student_credits_list.append(list(map(float,line.split())))
            count+=1
        else:
            count=0

Student.num_students = len(student_credits_list)
print(Student.num_students)

for i in range(len(student_credits_list)):
    obj = Student()
    obj.CPI(student_grade_list[i],student_credits_list[i])

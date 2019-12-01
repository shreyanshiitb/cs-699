from argparse import ArgumentParser
import csv
from os import path


class fml(ArgumentParser):
    def error(self, message):
        self.exit(2, ('%s\n') % message)


parser = fml()
parser.add_argument("--first_name",required=True)
parser.add_argument("--last_name",required=True)
parser.add_argument("--roll_no",required=True)
parser.add_argument("--gender",required=True)
parser.add_argument("--mobile",required=True)
parser.add_argument("--dept",required=True)
parser.add_argument("--CGPA",required=True)
args = parser.parse_args()


if path.exists('student_database.csv'):
    printheader = 0
else:
    printheader = 1
with open('student_database.csv', 'a', newline='') as csvfile:
    studetails = ["First Name", "Last Name", "Roll Number", "Gender", "Mobile", "Dept", "CGPA"]
    writer = csv.DictWriter(csvfile, fieldnames=studetails)
    if printheader:
        writer.writeheader()
    writer.writerow({"First Name":args.first_name, "Last Name":args.last_name, "Roll Number":args.roll_no, "Gender":args.gender, "Mobile":args.mobile, "Dept":args.dept, "CGPA":args.CGPA })
print('Successfully Added!!')

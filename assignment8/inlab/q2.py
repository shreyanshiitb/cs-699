from urllib.request import urlopen
import re

html = urlopen("https://www.cse.iitb.ac.in/page222?batch=MTech1").read().decode('utf-8')
x = re.findall('shreyansh',html)
print(x)
print(html)

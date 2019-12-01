import numpy as np
import glob
import sys
import io
import os

#print("helloworld")
#print(os.getcwd())
#sys.exit(0)
#print("This should not print")

heroFiles = []

with io.open("data/heroes.txt") as file:
	heroes=file.read().strip().split('\n')

#print(heroes)
#for word in heroes:
#	print(word)
#sys,exit(0)

os.mkdir("data/survivors_of_snap")

files = glob.glob("data/avengers_Universe/*.txt")
for fileN in files:
	with open(fileN) as f:
		#print(f.read())
		#if any(hero in f.read() for hero in heroes):
			#print(file)
		for hero in heroes:
			f.seek(0)
			#print(hero)
			if hero in f.read():
				#heroFiles.append(fileN)
				temp="mv \""+fileN+"\" data/survivors_of_snap"
				os.system(temp)
		#sys.exit(0)
	#f = open(file,'r')
	#for line in f
	#	print(line)
	#sys.exit(0)
	
#print(heroFiles)	
		
		#/users/pg19/kartavya/Downloads/Softlab/assignment7/inlab/data

**************************************************
CS699 : Software Lab, Project, 2019
**************************************************

**************************************************
Git Link : https://git.cse.iitb.ac.in/adityajainiitb/Codigos_AEG
**************************************************

Hosted on: https://codigos.herokuapp.com
Android apk: https://drive.google.com/open?id=1vXoPzw1-LYwyYC4l-dgT7k2RWeaIpMh3

**************************************************
Project : Automated Essay Grader
**************************************************

**************************************************
Team Name: Codigos
Team Members:
193050021 : Kartavya Kothari
1930500028 : Aditya Jain
193050040 : Shreyansh Jain
**************************************************


**************************************************
Motivation : 
There are several Issues with manual essay grading such as wastage of man hours, non stan-dardization of checking criterion and inconsistency in grading
We also focus on Improving the speed of evaluation and fairness
Automated  essay  grading  and  open-ended  assignments  has  received  increasing attention due to the unprecedented scale of Massive Online Courses(MOOCs)
More and more students are relying on computers to complete and submittheir school work
**************************************************


**************************************************
Project environment setup
+++++++++++++++++++++++++

To start the project you first need to install all dependencies:

    >>> pip install requirements.txt

After we have all the requirements set up, we will now create an environment

    >>> conda env create -f Softlab.yml

After the environment is set up you can initialize the environment somehow

    >>> conda activate Softlab

Yes that was it!! Now simply start the system by typing 

    >>> python3 main.py


Deployment steps using Docker
+++++++++++++++++++++++++++++

1) You can simply build the the image file by running following in the directory where Dockerfile is present

    >>> docker build --tag essay-grader .

    >>> docker run --name essay-grader -p 8000:8000 essay-grader
**************************************************
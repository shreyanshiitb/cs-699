/**
This Code is taken from http://www.worldbestlearningcenter.com for learning/teaching purpose
**/

/**
 * @file stud_rec.cpp
 * @author Shreyansh Jain
 * @brief Student marks database
 * @version 0.1
 * @date 2019-10-28
 * 
 * @copyright Copyright (c) 2019
 * 
 */
#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <string.h>
using namespace std;

/**
 * @brief 
 * 
 */
struct student
{
	string stnumber;
	string stname;
	char sex;
	float quizz1;
	float quizz2;
	float assigment;
	float midterm;
	float final;
	float total;
	int numberOfitem;
};

int search(struct student st[],string id, int itemcount);
void clean(struct student st[],int deleteitem);

/**
 * @brief prints all operations that a user can do
 * 
 */
void displaymenu(){
	cout<<"=========================================="<<"\n";
	cout<<" MENU "<<"\n";
	cout<<"=========================================="<<"\n";
	cout<<" 1.Add student records"<<"\n";
	cout<<" 2.Delete student records"<<"\n";
	cout<<" 3.Update student records"<<"\n";
	cout<<" 4.View all student records"<<"\n";
	cout<<" 5.Calculate average score of a student"<<"\n";
	cout<<" 6.Show student who gets the max total score"<<"\n";
	cout<<" 7.Show student who gets the max total score"<<"\n"; 
	cout<<" 8.Find a student by ID"<<"\n"; 
	cout<<" 9.Sort records by TOTAL"<<"\n"; 
}

/**
 * @brief Add student record to Database and increase itemcount
 * 
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void add_rec(struct student st[],int& itemcount){
	again:
	cout<<"\nEnter student's ID:";
	cin>>st[itemcount].stnumber;
	if(search(st,st[itemcount].stnumber,itemcount)!=-1){
		cout<<"This ID already exists\n";goto again;
	}
	cout<<"Enter student's Name:"; 
	cin>>st[itemcount].stname;
	cout<<"Enter student's Sex(F or M):";cin>>st[itemcount].sex;
	cout<<"Enter student's quizz1 score:";cin>>st[itemcount].quizz1;
	cout<<"Enter student's quizz2 score:";cin>>st[itemcount].quizz2;
	cout<<"Enter student's assigment score:";cin>>st[itemcount].assigment;
	cout<<"Enter student's mid term score:";cin>>st[itemcount].midterm;
	cout<<"Enter student's final score:";cin>>st[itemcount].final;
	st[itemcount].total=st[itemcount].quizz1+st[itemcount].quizz2+st[itemcount].assigment+st[itemcount].midterm+st[itemcount].final;

	++itemcount;
}

/**
 * @brief Search for student entry in database using ID
 * 
 * @param st : array of structure of student 
 * @param id : ID field of student to be searched
 * @param itemcount : number of students in DB 
 * @return -1 for unsuccessful/ 0 forsuccessful 
 */
int search(struct student st[], string id,int itemcount){
	int found =-1;
	for (int i = 0; i < itemcount && found==-1; i++)
	{
		if (st[i].stnumber == id) found=i;
		else found=-1 ;
	}

	return found;
}


/**
 * @brief Prints complete database
 * @details
 * e.g.\n
 * ID   NAME                SEX  Q1   Q2   As   Mi   Fi   TOTAL\n
 * 1    Shreyansh           M    1    1    1    1    1    5
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void viewall(struct student st[], int itemcount){
	int i=0;
	cout<<left<<setw(5)<<"ID"<<setw(20)<<"NAME"<<setw(5)<<"SEX"

	<<setw(5)<<"Q1"
	<<setw(5)<<"Q2"<<setw(5)<<"As"<<setw(5)<<"Mi"<<setw(5)<<"Fi"
	<<setw(5)<<"TOTAL"<<"\n";
	cout<<"==============================================\n";
	while(i<=itemcount){
		if(st[i].stnumber!=""){
			cout<<left<<setw(5)<<st[i].stnumber<<setw(20)<<st[i].stname<<setw(5)

			<<st[i].sex;
			cout<<setw(5)<<st[i].quizz1<<setw(5)<<st[i].quizz2<<setw(5)<<st[i].assigment
			<<setw(5)<<st[i].midterm<<setw(5)<<st[i]. final<<setw(5)
			<<st[i].total;

			cout<<"\n";
		}
		i=i+1;
	}
}

/**
 * @brief Delete student record entry and decrease itemcount
 * @details if no entry found gives an error message
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void delete_rec(struct student st[], int& itemcount){
	string id;
	int index;
	if (itemcount > 0)
	{
		cout<<"Enter student's ID:";
		cin>>id;
		index = search(st, id,itemcount); 

		if ((index!=-1) && (itemcount != 0)){
			if (index == (itemcount-1)){ 

				clean(st, index);
				--itemcount;

				cout<<"The record was deleted.\n";
			}
			else{ 
				for (int i = index; i < itemcount-1; i++){
					st[i] = st[i + 1];
					clean(st, itemcount);
					--itemcount ;
				}
			}
		}
		else cout<<"The record doesn't exist.Check the ID and try again.\n";
	}
	else cout<<"No record to delete\n";
}

/**
 * @brief Set all the fields of structure to defaults
 * 
 * @param st : array of structure of student 
 * @param index : index of student in structure array
 */
void clean(struct student st[],int index){
	st[index].stnumber = "";
	st[index].stname = "";
	st[index].sex = 'X';
	st[index].quizz1 = 0;
	st[index].quizz2 = 0;
	st[index].assigment = 0;
	st[index].midterm = 0;
	st[index].final = 0;
	st[index].total = 0;
}

/**
 * @brief Update fields of any student's record
 * @details prints error if field doesn't exist
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void update_rec(struct student st[],int itemcount){
	string id;
	int column_index;
	cout<<"Enter student's ID:";
	cin>>id;
	cout<<"Which field you want to update(1-7)?:";
	cin>>column_index;

	int index = search(st, id,itemcount);

	if (index != -1)
	{
		if (column_index == 1){
			cout<<"Enter student's Name:";
			cin>>st[index].stname;
		}

		else if (column_index == 2){
			cout<<"Enter student's Sex(F or M):";
			cin>>st[index].sex;
		}
		else if (column_index == 3){
			cout<<"Enter student's quizz1 score:";
			cin>>st[index].quizz1;
		}
		else if (column_index == 4){
			cout<<"Enter student's quizz2 score:";
			cin>>st[index].quizz2;
		}
		else if (column_index == 5){
			cout<<"Enter student's assigment score:";
			cin>>st[index].assigment;
		}
		else if (column_index == 6){
			cout<<"Enter student's mid term score:";
			cin>>st[index].midterm;
		}
		else if (column_index == 7)	{
			cout<<"Enter student's final score:";
			cin>>st[index].final;
		}
		else cout<<"Invalid column index";

		st[index].total = st[index].quizz1 + st[index].quizz2 + st[index].assigment

		+ st[index].midterm + st[index].final;
	}
	else cout<<"The record deosn't exits.Check the ID and try again.";
}

/**
 * @brief Prints the student ID who got highest total
 * 
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void showmax(struct student st[], int itemcount){
	float max = st[0].total;
	int index=0;

	if (itemcount >= 2){
		for (int j = 0; j < itemcount-1; ++j)
			if (max < st[j+1].total) {
				max = st[j+1].total;
				index = j+1;
			}
	}
	else if (itemcount == 1){
		index = 0;
		max = st[0].total;
	}
	else 
		cout<<"Not record found!\n";

	if (index != -1) 
		cout<<"The student with ID "<<st[index].stnumber<<" gets the highest score "<<max<<endl;
}

/**
 * @brief Prints the student ID who got lowest total
 * 
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void showmin(struct student st[], int itemcount){

	float min = st[0].total;
	int index = 0;

	if (itemcount >= 2){
		for (int j = 0; j < itemcount-1; ++j)
			if (min > st[j+1].total){
				min = st[j+1].total;
				index = j+1;
			}
	}
	else if (itemcount == 1){
		index = 0;
		min = st[0].total;
	}
	else 
		cout<<"No record found!\n";

	if (index != -1) cout<<"The student with ID "<<st[index].stnumber<<" gets the highest score "<<min<<endl;

}

/**
 * @brief 
 * 
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void find(struct student st[], int itemcount){
	string id;
	cout<<"Enter student's ID:";
	cin>>id;

	int index=search(st,id,itemcount);
	if (index != -1) { 								
		cout<<left<<setw(5)<<st[index].stnumber<<setw(20)<<st[index].stname<<setw(5)<<st[index].sex;
		cout<<setw(5)<<st[index].quizz1<<setw(5)<<st[index].quizz2<<setw(5)

		<<st[index].assigment
		<<setw(5)<<st[index].midterm<<setw(5)<<st[index].final<<setw(5)
		<<st[index].total;
		cout<<"\n"; 

	}
	else cout<<"The record doesn't exits.";

}

/**
 * @brief Sort the students structure based on their total 
 * 
 * @param dataset : array of structure of student
 * @param n : total number of elements in array
 */
void bubblesort(struct student dataset[], int n){
	int i, j;
	for (i = 0; i < n; i++)
		for (j = n - 1; j > i; j--)
			if (dataset[j].total < dataset[j - 1].total ){
				student temp = dataset[j];
				dataset[j] = dataset[j - 1];
				dataset[j - 1] = temp;
			}

}

/**
 * @brief 
 * 
 * @param st : array of structure of student 
 * @param itemcount : number of students in DB 
 */
void average(struct student st[], int itemcount){
	string id;
	float avg=0;
	cout<<"Enter students'ID:";
	cin>>id;
	int index = search(st, id,itemcount);
	if (index != -1 && itemcount>0)
	{
		st[index].total = st[index].quizz1 + st[index].quizz2 + st[index].assigment
			+ st[index].midterm + st[index].final;
		
		avg = st[index].total /5;
	}

	cout<<"The average score is "<<avg;
}

/**
 * @brief Driver program to test above functions
 * 
 * @param argc count of command line arguments
 * @param argv char array of arguments
 * @return 0
 */
int main(int argc, char *argv[]){

	student st[80];
	int itemcount=0;

	int yourchoice;
	char confirm;
	do{
	
		displaymenu();
		cout<<"Enter your choice(1-9):";
		cin>>yourchoice;

		switch(yourchoice){
			case 1:add_rec(st, itemcount);break;
			case 2:delete_rec(st, itemcount);break;
			case 3:update_rec(st, itemcount);break;
			case 4:viewall(st, itemcount);break;
			case 5:average(st, itemcount);break;
			case 6:showmax(st, itemcount);break;
			case 7:showmin(st, itemcount);break;
			case 8:find(st, itemcount);break;

			case 9:bubblesort(st,itemcount);break;
			default:cout<<"invalid";
		}

		cout<<"Press y or Y to continue:";
		cin>>confirm;
	}while(confirm=='y'||confirm=='Y');

	system("PAUSE");
	
	return EXIT_SUCCESS;
}
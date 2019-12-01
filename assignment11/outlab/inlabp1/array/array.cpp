/**
 * @file array.cpp
 * @author Shreyansh Jain
 * @brief array manipulations
 * @version 0.1
 * @date 2019-10-28
 * @copyright Copyright (c) 2019
 * 
 */
#include <iostream>
#include <stdlib.h>

using namespace std;


/**
 * @brief FILLING 2-D ARRAY WITH RANDOM NUMBERS in range [20,419]
 * 
 * @param myArr[][] : A 2-D array of dimensions 7*7
 * @return 0
 */
int fillArray(int myArr[7][7])                 
{
	for(int i=0;i<7;i++)
	{
		for(int j=0;j<7;j++)                    
		{
			myArr[i][j]=20+rand()%400;              
		}
	}
	return 0;
}


/**
 * @brief Prints the array in spiral manner
 * @details 
 * e.g.\n
 * Input array\n
 * {{ 1, 2, 3, 4, 5, 6 },\n
 *  { 7, 8, 9, 10, 11, 12 },\n
 *  { 13, 14, 15, 16, 17, 18 }}\n
 *  Output array\n
 *  1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 * @param myArr[][] : A 2-D array of dimensions 7*7
 */
void printSpiral(int myArr[7][7])
{
	cout << "Array Spiral Function." << endl;
	for(int j=0;j<1;j++)                           
    {                                              
        for(int i=0;i<7;i++)
        {
            cout<< myArr[i][j]<< "  ";
        }

    }
    cout << endl;

    for(int i=6;i<7;i++)                          
    {                                            
        for(int j=1;j<7;j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for(int j=6;j<7;j++)                          
    {                                             
        for(int i=5;i>=0;i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=0;i<1;i++)                          
    {                                              
        for (int j=5;j>=1;j--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int j=1; j<2;j++)
    {                                             
        for (int i=1; i<6;i++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=5; i<6;i++)                        
    {
        for (int j=2; j<6; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int j=5; j<6; j++)                        
    {
        for (int i=4; i>0; i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=1; i<2; i++)                        
    {
       for (int j=4; j>1; j--)
       {
           cout << myArr[i][j] << "  ";
       }
    }
    cout << endl;

    for (int j=2; j<3; j++)                        
    {
        for (int i=2; i<5; i++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=4; i<5; i++)                        
    {
        for (int j=3; j<5; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int j=4; j<5; j++)                        
    {
        for (int i=3; i>1; i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=2; i<3; i++)                        
    {
        for (int j=3; j<4; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=3; i<4; i++)                         
    {
        for (int j=3; j<4; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
  cout << endl << endl;
}

/**
 * @brief Prints columns from index 's' to index 'e' 
 * 
 * @param myArr[][] : A 2-D array of dimensions 7*7
 * @param s : start index
 * @param e : end index
 */
void printCol(int myArr[7][7], int s, int e)                     
{  
	cout << "Column Output" << endl;                
	for (int j=s-1; j<e-1; j++)
	{                                               
		for (int i=0; i<7; i++)
		{
			cout << myArr[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl << endl;
}
/**
 * @brief Prints the minimum of 2-D array
 * @details 
 * e.g.\n
 * Input\n
 * {{ 1, 2, 3, 4, 5, 6 },\n
 *  { 7, 8, 9, 10, 11, 12 },\n
 *  { 13, 14, 15, 16, 17, 18 }}\n
 *  Output\n
 *  1
 * @param myArr[][] : A 2-D array of dimensions 7*7
 * @return integer : min of all elements
 */
int findMin (int myArr[7][7])
{
	int i,j;
	int min = myArr[0][0];

	for (i=0; i<7; i++)                             
	{
		for (j=0; j<7; j++)
		{
			if(myArr[i][j] < min)                   
			{                                       
				min = myArr[i][j];
			}                                       
		}                                           

	}
    return min;
}

/**
 * @brief Prints the int average of 2-D array
 * @details 
 * e.g.\n
 * Input Array\n
 * {{ 1, 2, 3, 4, 5, 6 },\n
 *  { 7, 8, 9, 10, 11, 12 },\n
 *  { 13, 14, 15, 16, 17, 18 }}\n
 * Actual average\n
 * 9.5\n
 * Output\n
 * 9
 * @param myArr[][] : A 2-D array of dimensions 7*7
 * @return integer : average of all elements
 */
int findAverage (int myArr[7][7])                  
{                                                   
	int i,j;
	int sum = 0;

	for (i=0; i<7; i++)                             
	{
	    for (j=0; j<7; j++)
	    {
	        sum = sum + myArr[i][j];
	    }

	}
    return sum/49;       
}

/**
 * 
 * @brief Prints the 2-D array row-wise
 * @details 
 * e.g.\n
 * Input Array\n
 * {{ 1, 2, 3, 4, 5, 6 },\n
 *  { 7, 8, 9, 10, 11, 12 },\n
 *  { 13, 14, 15, 16, 17, 18 }}\n
 * Output\n
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 * @param myArr[][] : A 2-D array of dimensions 7*7
 */
void printArray (int myArr[7][7])                     
{
    cout << "Normal Array Output" << endl;

    for (int i =0; i<7; i++)
    {
        for (int j=0; j<7; j++)
        {
            cout << myArr[i][j] << "  ";
        }
        cout << endl;
    }
    cout << endl;                                   
    cout << endl;
}

/**
 * 
 * @brief Driver program to test above functions
 * @return 0
 */
int main(){
	
	int myArr [7][7];
	fillArray(myArr);                               
	printArray(myArr);
	printSpiral(myArr);
	printCol(myArr, 2, 5);
	cout<<"Min:"<<findMin(myArr);
	cout<<" Average:"<<findAverage(myArr);
    cout<<endl;

	return 0;
}
 

#include <bits/stdc++.h> 
#include <map> 
#include <string> // for string class 
#include <iostream> 

using namespace std;
typedef vector<faretable> faretabletype;


class faretable{
    public:
    string source,destination,fare;

    void addfare(int faretable,string origin,string dest,double fare){
        
    }

    bool getfare(int faretable,string origin,string dest,double fare){
        
    }
    string connections(int faretable,string origin){

    }
};

int main(){
  faretabletype faretable; // create faretabletype using typedef

  while(true){
    char command; cin >> command;
    if(command == 'x') break;
    if(command == 'a'){
      string origin, destination; 
      cin >> origin >> destination;
      double fare; 
      cin >> fare;
      addfare(faretable, origin, destination, fare);
    }
    else if(command == 'g'){
      string origin, destination; 
      cin >> origin >> destination;
      double fare;
      bool found = getfare(faretable,origin, destination,fare); 
      if(found) cout << fare <<endl;
      else cout << "Not found."<<endl;
    }
    else if(command == 'c'){
      string origin; 
      cin >> origin;
      cout << connections(faretable,origin) << endl;
    }
    else cout <<"Illegal command."<<endl;
  }
  return 0;
}

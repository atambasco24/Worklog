#include <iostream>
#include <string>
#include <algorithm>



using namespace std;

int main(){

char ch1;
char ch2;
char ch3;
char ch4;
char ch5;
char ch6;
char ch7;
char ch8;

cout << "Enter date"<<endl;

cin.get(ch1);

cin.get(ch2);

cin.ignore(100,'/');

cin.get(ch3);

cin.get(ch4);

cin.ignore(100, '/');

cin.get(ch5);

cin.get(ch6);

cin.get(ch7);

cin.get(ch8);


cout << "Month entered: " << ch1 << ch2 << endl;

cout << "Day entered: " << ch3 << ch4 << endl;

cout << "Year entered: " << ch5 << ch6 << ch7<< ch8 << endl;


return 0;
}

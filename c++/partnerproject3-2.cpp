#include <iostream>
#include <string>
#include <fstream>



using namespace std;

int main(){

ifstream inFile;
 inFile.open("racedat.txt");
 
 char l1, l2, l3, l4;
 int a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3;
 
 double at, bt, ct, dt, aa, ba, ca, da;
 
 
 
 inFile >> l1 >> a1 >> a2 >> a3; 
  inFile >> l2 >> b1 >> b2 >> b3;
 inFile >> l3 >> c1 >> c2 >> c3;
 inFile >> l4 >> d1 >> d2 >> d3;

at = a1 + a2 + a3;
bt = b1 + b2 + b3;
ct = c1 + c2 + c3;
dt = d1 + d2 + d3;

aa = at / 3;
ba = bt / 3;
ca = ct / 3;
da = dt / 3;



          cout << "     Person   |    Running    Swimming    Biking"<< endl;
cout << "       " << l1 << "              " << a1 << "         " << a2 << "         " << a3 << endl;
cout << "       " << l2 << "              " << b1 << "         " << b2 << "         " << b3 << endl;
cout << "       " << l3 << "              " << c1 << "         " << c2 << "         " << c3 << endl;
cout << "       " << l4 << "              " << d1 << "         " << d2 << "         " << d3 << endl;






cout << " Person " << l1 << "'s" <<endl;
cout << "total time: " << at << endl;
cout << " average time: " << aa <<endl;
cout << " " << endl;

cout << " Person " << l2 << "'s" <<endl;
cout << "total time: " << bt << endl;
cout << " average time: " << ba <<endl;
cout << " " <<endl;

cout << " Person " << l3 << "'s" <<endl;
cout << "total time: " << ct << endl;
cout << " average time: " << ca <<endl;
cout << " "<< endl;
cout << " Person " << l4 << "'s" <<endl;
cout << "total time: " << dt << endl;
cout << " average time: " << da <<endl;
cout << " " << endl;







inFile.close();



return 0;
}
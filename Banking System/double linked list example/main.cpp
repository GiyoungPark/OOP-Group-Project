#include <iostream>
#include "LinkedList.h"
using namespace std;

int main(){
    bool check;
    char asw;
    LinkedList *dll = new LinkedList();

    do {
        check = dll->call_f(dll->options());
        if(check){
            cout << endl << "End?(y/n): "; 
            cin >> asw;
            (asw == 'y' || asw == 'Y') ? check = false : check = true;
        }
    } while(check);

    delete dll;
    dll->print();
    
    return 0;
}


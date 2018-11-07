#include <iostream>
#include "LinkedList.h"
using namespace std;

int main() {
    Node *n = new Node(3);
    Node *n1 = new Node(4);


    cout << n->get() << endl;
    n->set_next(n1);
    cout << n->get_next()->get() << endl;
    n->set(2);
    cout << n->get() << endl;

    LinkedList *ll = new LinkedList();

    //insert() testing
    ll->print();
    ll->insert(-1,1);
    ll->insert(3,1);
    ll->print();
    ll->insert(0, 1);
    ll->print();
    ll->insert(1, 3);
    ll->print();
    ll->insert(1,2);
    ll->print();
    ll->insert(0,0);
    ll->print();
    ll->insert(3,3);
    ll->print();

    // remove() testing
    ll->remove(0);
    ll->print();
    ll->remove(2);
    ll->print();

    // get() testing
    cout << ll->get(1) << endl;

    // set() testing
    ll->set(0,2);
    ll->print();

    // empty() testing
    ll->empty() ? cout << "Linked List is empty" << endl : cout << "Linked List "
        "is not empty" << endl;
    LinkedList *ll2 = new LinkedList();
    ll2->empty() ? cout << "Linked List is empty" << endl : cout << "Linked List "
        "is not empty" << endl;

    // search() testing
    ll->search(3) == -1 ? cout << "Item not found" << endl : cout 
        << ll->search(3) << endl;
    ll->search(5) == -1 ? cout << "Item not found" << endl : cout 
        << ll->search(5) << endl;

    delete n;
    delete n1;
    delete ll; // automatically uses destructor

    return 0;
}


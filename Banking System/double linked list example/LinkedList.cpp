#include <iostream>
#include "LinkedList.h"
using namespace std;

// Node funcs begin
// Node default constructor
Node::Node(int datum){
    this->datum = datum;
    this->next = NULL;
    this->prev = NULL;
}

// used to return datum since it is private
int Node::get(){
    return this->datum;
}

// used to set datum since it is private
void Node::set(int datum){
    this->datum = datum;
}

// set node pointer
void Node::set_next(Node* next){
    this->next = next;
}

// used to access Node->next since it is private
Node* Node::get_next(){
    return this->next;
}

void Node::set_prev(Node *prev){
    this->prev = prev;
}

Node* Node::get_prev(){
    return this->prev;
}
// end Node funcs






// LinkedList default constructor
LinkedList::LinkedList() {
    this->size = 0;
    this->head = NULL;
    this->tail = NULL;
}

// LinkedList functions
LinkedList::~LinkedList() {
    this->destructor_help(this->head);
}

// goes to end of list then deletes the next* pointer
// working its way back
void LinkedList::destructor_help(Node* n) {
    if (n == NULL) 
        return;
    else {
        this->destructor_help(n->get_next());
    }
}

bool LinkedList::check(int index){ 
    if (index > this->size || index < 0)
        return false;
    else 
        return true;
}

bool LinkedList::empty(){
    return head == NULL;
}

 // inserts an item into the list int index, int data 
void LinkedList::insert(int index, int datum){
    // input validation
    if(!check(index)) 
        return;

    Node* newNode = new Node(datum);

    // insert at head of the list
    if (index == 0) {
        newNode->set_next(this->head);
        if (this->size != 0)
            this->head->set_prev(newNode);
        this->head = newNode;
        if (this->size == 0)
            this->tail = newNode;
    } else {
        Node *tmp = head;
        for(int i=0; i < index - 1; i++, tmp = tmp->get_next());
        newNode->set_next(tmp->get_next());
        tmp->set_next(newNode);
        newNode->set_prev(tmp);
        if(newNode->get_next() == NULL)
            this->tail = newNode;
        else {
            tmp = newNode->get_next();
            tmp->set_prev(newNode);
        } 
    }
    
    this->size++;
}

// print the list
void LinkedList::print(){ 
    Node* tmp = head;
    cout << "{ ";
    if(tmp != NULL){
        cout << " " << tmp->get();
        for (tmp = tmp->get_next(); tmp != NULL; tmp = tmp->get_next())
            cout << ", " << tmp->get();
    }
    cout << " }" << endl;
    tmp = tail;
    cout << "{ ";
    if(tmp != NULL){
        cout << " " << tmp->get();
        for (tmp = tmp->get_prev(); tmp != NULL; tmp = tmp->get_prev())
            cout << ", " << tmp->get();
    }
    cout << " }" << endl;
}

// removes node in list
void LinkedList::remove(int index) {
    // input validation
    if (index > this->size || index < 0) {
        cout << "Invalid index" << endl;
        return;
        // return false;
    }
    
    Node *tmp = head;

    // remove from head
    if(index == 0) {
        head = tmp->get_next();
        head->set_prev(NULL);
        delete tmp;
    // remove from the body
    } else {
        // iterate to the node before the node to be removed
        for (int i = 0; i < index-1 ; i++, tmp = tmp->get_next());
        // check that temp is not node before the tail pointer
        if (tmp == tail) {
            if(size != 1)
                this->tail = tmp->get_prev();
            delete tmp;
        }
        // remove node
        Node *tmp2 = tmp->get_next();
        tmp->set_next(tmp->get_next()->get_next());
        if(tmp->get_next() == NULL) {
            this->tail = tmp;
        } else {
            tmp = tmp->get_next();
            tmp->set_prev(tmp->get_prev()->get_prev());
        }
        delete tmp2;
    }
    this->size--;

}

// returns datum for an indecated node in the list
int LinkedList::get(int index) {
    if (index > this->size || index < 0) {
        cout << "Invalid index" << endl;
        return -1;
    }

    // start at the head
    Node *tmp = head;
    //iterate to node in list
    for (int i = 0; i< index; i++, tmp = tmp->get_next());
    return tmp->get();
}

// sets datum for a specified node
void LinkedList::set(int index, int datum){
    if (index > this->size || index < 0) {
        cout << "Invalid index" << endl;
        return;
    }

    // start at the head
    Node *tmp = head;
    // iterate to node in list
    for (int i = 0; i < index; i++, tmp = tmp->get_next());
    tmp->set(datum);
}

// returns the location of a datum in the list
int LinkedList::search(int datum){
    // start at the head
    Node *tmp = head;
    // search list on order n
    for (int i = 0; tmp != NULL; tmp = tmp->get_next(), i++)
        if (tmp->get() == datum)
            return i;
    return -1;
}

int LinkedList::options(){
    int selection;
    cout << endl << endl
         << "------------------------------DOUBLLY LINKED LIST-------------------------------" 
         << endl << endl;
    cout << " 1. Print list " << endl
         << " 2. Insert node" << endl
         << " 3. Remove " << endl
         << " 4. Search " << endl
         << " 5. Get index" << endl
         << " 6. Set index" << endl << endl
         << " Enter Value: ";
    cin >> selection;
    return selection;
}

bool LinkedList::call_f(int opt = 0){
    int index, datum;
    switch(opt) {
        case 1:
            print();
            return true;
        case 2:
            cout << endl << "Enter index: "; cin >> index;
            cout << endl << "Enter Datum: "; cin >> datum;
            insert(index, datum);
            return true;
        case 3:
            cout << endl << "Enter index: "; cin >> index;
            remove(index);
            return true;
        case 4:
            cout << endl << "Enter datum: "; cin >> datum;
            cout << search(datum) << endl;
            return true;
        case 5:
            cout << endl << "Enter index: "; cin >> index;
            cout << get(index) << endl;
            return true;
        case 6:
            cout << endl << "Enter index: "; cin >> index;
            cout << endl << "Enter Datum: "; cin >> datum;
            set(index, datum);
            return true;
        default:
            return false;
    }
    return false;
}

#include <iostream>
#include "LinkedList.h"
using namespace std;

// Node funcs begin
// Node default constructor
Node::Node(int datum){
    this->datum = datum;
    this->next = NULL;
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
// end Node funcs





// LinkedList functions
LinkedList::~LinkedList() {
    this->destructor_help(this->head);
}

// LinkedList default constructor
LinkedList::LinkedList() {
    this->size = 0;
    this->head = NULL;
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

bool LinkedList::empty(){
    return head == NULL;
}

 // inserts an item into the list int index, int data 
void LinkedList::insert(int index, int datum){
    // input validation
    if (index > this->size || index < 0) {
        cout << "Invalid index" << endl;
        return;
        // return false;
    }

    Node* newNode = new Node(datum);

    // insert at head of the list
    if (index == 0) {
        newNode->set_next(this->head);
        this->head = newNode;
        // return true;
    } else {
        Node *temp = head;
        for(int i=0; i < index - 1; i++, temp = temp->get_next());
        newNode->set_next(temp->get_next());
        temp->set_next(newNode);
        // return true;
    }
    this->size++;
}

// print the list
void LinkedList::print(){ 
    Node* temp = head;
    cout << "{ ";
    if(temp != NULL){
        cout << " " << temp->get();
        for (temp = temp->get_next(); temp != NULL; temp = temp->get_next()) {
            cout << ", " << temp->get();
        }
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
        delete tmp;
    // remove from the body
    } else {
        // iterate to the node before the node to be removed
        for (int i = 0; i < index-1 ; i++, tmp = tmp->get_next());
        // check that temp is not the tail pointer
        if (tmp->get_next() == NULL) {
            delete tmp;
        }
        // remove node
        Node *tmp2 = tmp->get_next();
        tmp->set_next(tmp->get_next()->get_next());
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


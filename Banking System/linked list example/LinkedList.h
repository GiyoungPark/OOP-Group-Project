class Node {
    int datum; // this is private
    Node *next;
public:
    Node(int);
    int get();
    void set(int);
    void set_next(Node*); // set node pointer
    Node * get_next();
};

class LinkedList {
    int size;
    Node* head;
public:
    LinkedList(); 
    LinkedList(int, int []); 
    ~LinkedList();
    void destructor_help(Node*);
    void insert(int, int); // inserts an item into the list int index, int data 
    void remove(int); // remove an element form the list
    int get(int); // get the value of specified index and return it
    void set(int, int); // set the value at the specified index to the specified number
    int search(int); // searches for num in LList and return the position (failure is indicated by -1
    bool empty(); // check if list is empty
    void print(); // print the list
};



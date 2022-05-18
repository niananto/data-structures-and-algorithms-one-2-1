#include<iostream>

using namespace std;

template <typename T>
class Queue {
private:
    T* elements;
    int head;
    int tail;
    int size;
    int capacity;
public:

    Queue() {
        this->elements = NULL;
        this->capacity = 0;
        this->size = 0;
        this->head = 0;
        this->tail = 0;
    }

    Queue(int capacity) {
        this->elements = new T[capacity];
        this->capacity = capacity;
        this->size = 0;
        this->head = 0;
        this->tail = 0;
    }

    bool isFull() {
        return size == capacity;
    }

    bool isEmpty() {
        return size = 0;
    }

    void enqueue(T element) {
        if (isFull()) {
            cout << "Queue is full" << endl;
            return;
        }
        else {
            elements[tail] = element;
            tail = (tail+1) % capacity;
            size++;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return NULL;
        }
        else {
            T temp = elements[head];
            head = (head+1) % capacity;
            size--;
            return temp;
        }
    }

    T front() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return NULL;
        }
        return elements[head];
    }

    T back() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return NULL;
        }
        return elements[tail-1];
    }

    bool contains(T element) {
        if (isEmpty()) return false;

        int i = head;
        while (i!=tail) {
            if (elements[i] == element)
                return true;
            i = (i+1) % capacity;
        }
        return false;
    }

    void print() {
        cout << "Queue : ";
        for (int i=head; i!=tail; i=(i+1)%capacity) {
            cout << elements[i];
        }
        cout << endl;
    }

    ~Queue() {
        delete this->elements;
    }

};

int main () {

    Queue<char> string_old(100);

    string input;
    cout << "Enter the letters" << endl;
    cin >> input;

    // Queue<int> bleh(5);
    // bleh.enqueue(1);
    // bleh.enqueue(2);
    // bleh.enqueue(3);
    // bleh.enqueue(4);
    // bleh.enqueue(5);
    // bleh.enqueue(6);
    // bleh.print();
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;
    // cout << bleh.dequeue() << endl;

    string_old.enqueue(input[0]);
    cout << input[0];

    for (int i=1; i<input.length(); i++) {
        if(string_old.isEmpty()) {
            cout << "#";
            continue;
        }
        
        if(!string_old.contains(input[i])) {
            string_old.enqueue(input[i]);
            cout << string_old.front();
        }
        else {
            string_old.dequeue();
            if(string_old.isEmpty()) {
                cout << "#";
                continue;
            }
            cout << string_old.front();
        }
    }
    cout << "#" << endl;
    
    return 0;
}
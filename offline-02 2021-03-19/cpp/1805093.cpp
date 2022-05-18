#include<iostream>

using namespace std;

class Element{

    private:

        int value;
        int reflex;
        Element *prev;
        Element *next;
    
    public:

        Element(){
            this->value = 0;
            this->reflex = 0;
            this->prev = this;
            this->next = this;
        }

        Element(int value){
            this->value = value;
            this->reflex = 0;
            this->prev = this;
            this->next = this;
        }

        Element(int value, int reflex){
            this->value = value;
            this->reflex = reflex;
            this->prev = this;
            this->next = this;
        }

        void setValue(int value){
            this->value=value;
        }

        int getValue(){
            return this->value;
        }

        void setReflex(int reflex){
            this->reflex = reflex;
        }

        int getReflex(){
            return this->reflex;
        }

        void setPrev(Element* prev){
            this->prev = prev;
        }

        Element* getPrev(){
            return this->prev;
        }

        void setNext(Element* next){
            this->next = next;
        }

        Element* getNext(){
            return next;
        }

};


class LinkedList{

    private:

        Element *head;
        int size;

    public:

        LinkedList(){
            head=new Element();
            size=0;
        }

        ///add element to last element exists.
        void add(Element element){

            Element *temp=head;

            while(temp->getNext()!=NULL){
                 temp=temp->getNext();
            }

            Element *newElement=new Element(element.getValue());
            temp->setNext(newElement);

            size++;
        }

        ///return the size
        int getSize(){
            return size;
        }

        ///return the element of the specified position
        ///return NULL if position greater than size
        Element find(int position){
            if(position >= size ){
                return NULL;
            }
            else{
                Element *temp = head;
                for(int i=0; i<position; i++){
                    temp=temp->getNext();
                }
                return *temp;
            }
        }

        ///check if the element exists
        ///check by value
        bool find(Element element){
            Element *temp = head;
            while(temp->getNext()!=NULL){
                if(element.getValue() == temp->getValue()){
                    return true;
                }
                temp=temp->getNext();
            }
            return false;
        }

        ///remove element from the specified position
        ///return true if can be successfully returned
        bool remove(int position){
            if(position>=size){
                return false;
            }
            else{
                Element *temp = head;
                for(int i=0; i<position-1; i++){
                    temp=temp->getNext();
                }
                Element *toBeDeleted = temp->getNext();
                temp->setNext(toBeDeleted->getNext());
                delete toBeDeleted;
                size--;
                return true;
            }
        }

        ///remove the first element that matches the value
        bool remove(Element element){
            Element *temp = head;
            while(temp->getNext()!=NULL){
                if(temp->getNext()->getValue() == element.getValue()){
                    Element *toBeDeleted = temp->getNext();
                    temp->setNext(toBeDeleted->getNext());
                    delete toBeDeleted;
                    size--;
                    return true;
                }
                temp=temp->getNext();
            }
            return false;            
        }

        ///printLinkedListValue
        void printList(){

            Element *temp=head;

            for(int i=0;i<size;i++){
                temp=temp->getNext();
                cout<<temp->getValue()<<" -> ";
            }

            cout<<endl;
        }

};


int main(){

    // LinkedList list;

    // Element e1(1);
    // Element e2(2);
    // Element e3(3);

    // list.add(e1);
    // list.add(e2);
    // list.add(e3);

    // list.printList();

    // if(list.find(e1)){
    //     cout<<"e1 found"<<endl;
    // }

    // list.remove(2);
    // list.printList();

    // list.add(e1);
    // list.remove(e2);
    // list.printList();

    

    return 0;
}


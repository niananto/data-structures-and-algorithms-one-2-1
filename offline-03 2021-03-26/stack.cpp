#include<iostream>

using namespace std;

template <typename T>
class Stack {
private:
    T* elements;
    int capacity;
    int top;

public:
    Stack() {
        this->elements = NULL;
        this->capacity = 0;
        this->top = 0;
    }

    Stack(int capacity) {
        this->elements = new T[capacity];
        this->capacity = capacity;
        this->top = 0;
    }

    bool isFull() {
        return this->top == capacity;
    }

    bool isEmpty() {
        return this->top == 0;
    }

    void push(T element) {
        if(isFull()) {
            cout << "Stack is full" << endl;
            return;
        }
        this->elements[top++] = element;
        return;
    }

    T peek() {
        if(isEmpty()) {
            cout << "Stack is empty (peek)" << endl;
            return NULL;
        }
        return this->elements[top-1];
    }

    T pop() {
        if(isEmpty()) {
            cout << "Stack is empty (pop)" << endl;
            return NULL;
        }
        return this->elements[--top];
    }

    void print() {
        cout << endl;
        for (int i = 0; i < top; i++) {
            cout << this->elements[i] << endl;
        }
        cout << endl;
    }

    ~Stack() {
        delete this->elements;
    }
};

bool isOperator(char op) {
    if(op == '(' || op == ')' || op == '+' || op == '-' || op == '*' || op == '/')
        return true;
    return false;
}

bool isOperand(char op) {
    if(op >= '0' && op <='9')
        return true;
    return false;
}

int precedence(char op){
	if(op == '+' || op == '-')
	    return 1;
	else if(op == '*' || op == '/')
	    return 2;
	return 0;
}

int calculate(int x, int y, char op) {
    switch (op) {
        case '+':
            return x+y;
        case '-':
            return x-y;
        case '*':
            return x*y;
        case '/':
            return x/y;
        default:
            return 0;
    }
}

void bracketCheck (string expression) {
    int opening = 0;
    int closing = 0;
    for (int i = 0; i < expression.length(); i++) {
        if (expression[i] == '(') opening++;
        else if (expression[i] == ')') closing++;
        else ;
    }
    if (opening != closing) {
        cout << "Invalid Expression" << endl;
        exit(0);
    }
}

int evaluate (string expression) {

    Stack<int> operandStack(100);
    Stack<char> operatorStack(100);

    for(int i=0; i<expression.length(); i++) {

        char current = expression[i];
        
        if (current == ' ') {
            continue;
        } 

        else if (isOperand(current)) {
            int value = 0;

            while (i < expression.length() && isOperand(expression[i])) {
                value = value*10 + expression[i++] - '0';
            }
            operandStack.push(value);
            i--;
        } 

        else if (isOperator(current)) {
            
            if (current == '(') {
                operatorStack.push(current);
            }

            else if (current == ')') {
                while (!operatorStack.isEmpty()) {
                    if (operatorStack.peek() == '(') {
                        operatorStack.pop();
                        break;
                    }
                    operandStack.push(calculate(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
                }
            }

            else { // + - * /

                if (current == '-' && !isOperand(expression[i-1])) {
                    if (expression[i-1] == '(' && isOperand(expression[i+1])) {
                        int j=i+1;
                        while (isOperand(expression[j])) {
                            if (isOperand(expression[j+1])) {
                                if (expression[j+1] != ')') {
                                    cout << "Invalid Expression" << endl;
                                    exit(0);
                                }
                                break;
                            }
                            j++;
                        }
                        operandStack.push(0);
                    }
                    else {
                        cout << "Invalid Expression" << endl;
                        exit(0);
                    }
                }

                while (!operatorStack.isEmpty() && (precedence(operatorStack.peek()) >= precedence(current))) {
                    operandStack.push(calculate(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
                }

                operatorStack.push(current);
            }

        } else {
            cout << "Invalid Expression" << endl;
            exit(0);
        }
    }

    while (!operatorStack.isEmpty()) {
        operandStack.push(calculate(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
    }

    return operandStack.peek();
}

int main() {
    // Stack<int> stack1(2);
    // stack1.push(1);
    // stack1.push(2);
    // stack1.push(3);
    // cout << stack1.pop() << endl;
    // cout << stack1.pop() << endl;
    // cout << stack1.pop() << endl;

    // Stack<char> stack2(2);
    // stack2.push(')');
    // stack2.push('+');
    // stack2.push('-');
    // cout << stack2.pop() << endl;
    // cout << stack2.pop() << endl;
    // cout << stack2.pop() << endl;

    string input;
    cout << "Enter the expression" << endl;
    cin >> input;
    // input = "(9*3-(7*8+((-4)/2)))";
    // input = "(9*3-(7*8+((-4)/2)))";

    bracketCheck(input);
    cout << evaluate(input) << endl;

    return 0;
}
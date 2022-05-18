#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    ifstream inputFile("isaExample.txt");
    int maxSize = 100;
    char* inputCharacters = new char[maxSize];

    int i = 0;
    while(i<maxSize) {
        // inputFile >> inputCharacters[i];
        inputFile.get(inputCharacters[i]);
        i++;
    }

    for(int i = 0; i < maxSize; i++) {
        if((inputCharacters[i] >= 'a' && inputCharacters[i] <= 'z') || 
                (inputCharacters[i] >= 'A' && inputCharacters[i] <= 'Z') || inputCharacters[i] == ' '){
                    cout << inputCharacters[i];
                }
    }

}
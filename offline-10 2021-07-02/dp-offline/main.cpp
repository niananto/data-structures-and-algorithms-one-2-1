#include <iostream>
#include <fstream>

//#include "numberOfWays.h"
#include "numberOfWays2.h"

using namespace std;

#define FILE_NAME ".\\Sample 1.txt"

int main() {
    ifstream inputFile(FILE_NAME);

    int numberOfDices, sum;
    string firstLineInput;
    getline(inputFile, firstLineInput);

    string delimiter = " ";
    size_t pos = 0;
    string token;
    {
        pos = firstLineInput.find(delimiter);
        token = firstLineInput.substr(0, pos);
        numberOfDices = stoi(token);
        firstLineInput.erase(0, pos + delimiter.length());
        sum = stoi(firstLineInput);
    }

    int* numberOfFaces = new int[numberOfDices];
    string secondLineInput;
    getline(inputFile, secondLineInput);

    pos = 0;
    for (int i = 0; i < numberOfDices; i++) {
        pos = secondLineInput.find(delimiter);
        token = secondLineInput.substr(0, pos);
        numberOfFaces[i] = stoi(token);
        secondLineInput.erase(0, pos + delimiter.length());
    }

    // cout << "Number of Dices " << numberOfDices << "\nSum " << sum << endl;
    // for (int i = 0; i < numberOfDices; i++) cout << i << ". " << numberOfFaces[i] << "\n";

    cout << numberOfWays(sum, numberOfDices, numberOfFaces) << endl;

    return 0;
}

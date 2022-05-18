#include <iostream>
#include <fstream>

//#include "numberOfWays.h"
#include "numberOfWays2.h"

using namespace std;

int main() {
    ifstream cin(".\\Sample 1.txt");

    int numberOfDices, sum;
    cin >> numberOfDices >> sum;
    int* numberOfFaces = new int[numberOfDices];
    for (int i = 0; i < numberOfDices; i++) cin >> numberOfFaces[i];

    // cout << "Number of Dices " << numberOfDices << "\nSum " << sum << endl;
    // for (int i = 0; i < numberOfDices; i++) cout << i << ". " << numberOfFaces[i] << "\n";

    cout << numberOfWays(sum, numberOfDices, numberOfFaces) << endl;

    delete numberOfFaces;
    return 0;
}

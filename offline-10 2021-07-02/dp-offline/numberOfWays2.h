#include <cstring>

// int table[100+1][10000+1]; 

int numberOfWays (int sum, int numberOfDices, int numberOfFaces[]) {

    // int** table = new int*[numberOfDices+1];
    // for (int i = 0; i < numberOfDices; i++) {
    //     table[i] = new int[sum+1];
    // }

    int table[numberOfDices+1][sum+1];
    
    memset(table, 0, sizeof(table));

    // modulo
    int M = 1'000'000'007;

    table[0][0] = 1;
    // iterate over dices
    for (int i = 1; i <= numberOfDices; i++) {
        // iterate over sum
        for (int j = 1; j <= sum; j++) {
            table[i-1][j] = (table[i-1][j] % M + table[i-1][j-1] % M) % M;
            table[i][j] = table[i-1][j-1] % M;
            if ((j - numberOfFaces[i-1] - 1) >= 0) {
                table[i][j] = ((table[i][j] % M - table[i-1][j - numberOfFaces[i-1] - 1] % M) + M) % M;
            }
        }
    }
    return table[numberOfDices][sum] % M;
}

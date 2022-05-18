int count = 0;

int numberOfWays (int sum, int numberOfDices, int* numberOfFaces) {
    static int depth = 1;

    // base case
    if (sum <= 0) {
        return 0;
    } else if (numberOfDices == 1 && numberOfFaces[0] < sum) {
        return 0;
    } else if (numberOfDices == 1 && numberOfFaces[0] > sum) {
        return 1;
    }

    // recursion
    int currentSum = 0;
    for (int i = 1; i <= numberOfFaces[numberOfDices-1]; i++) {
        depth++;
        currentSum = currentSum + i + numberOfWays(sum-i, numberOfDices-1, numberOfFaces);
        depth--;

        if (depth == 1 && currentSum == sum) {
            count++;
        }
    }

    return currentSum;
}


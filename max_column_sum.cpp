#include <iostream>
using namespace std;

int* first_second_max(int **dp, int r, int c){
    int fm = dp[0][c], sm = dp[1][c], *result = new int[2];

    for (int i = 1; i < r; i++) {
        if (dp[i][c] >= fm) {
            sm = fm;
            fm = dp[i][c];
        }
        else if (dp[i][c] > sm)sm = dp[i][c];
    }

    result[0] = fm;
    result[1] = sm;
    return result;
}

int main() {
    int r, c;
    cout << "Enter number of rows and columns: ";
    cin >> r >> c;
    int matrix[r][c], **dp = new int*[r];
    cout << "Enter the matrix:" << endl;
    for(int i = 0; i < r; i++){
        dp[i] = new int[c];
        for(int j = 0; j < c; j++)
        cin >> matrix[i][j];
    }
    for(int j = 0; j < c; j++)for(int i = 0; i < r; i++){
        if(j==0) dp[i][j] = matrix[i][j];
        else{
            int *max = first_second_max(dp, r, j-1);
            dp[i][j] = matrix[i][j]+(dp[i][j-1] == max[0] ? max[1] : max[0]);
        }
    }
    cout << "Maximum sum: " << first_second_max(dp, r, c-1)[0] << endl;
    
    return 0;
}

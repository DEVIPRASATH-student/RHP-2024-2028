#include <iostream>
using namespace std;

int* first_second_max(int row[], int c){
    int fm = row[0], sm = row[1], *result = new int[2];

    for (int i = 1; i < c; i++) {
        if (row[i] >= fm) {
            sm = fm;
            fm = row[i];
        }
        else if (row[i] > sm)sm = row[i];
    }
    result[0] = fm;
    result[1] = sm;
    return result;
}

int main() {
    int r, c;
    cout << "Enter number of rows and columns: ";
    cin >> r >> c;
    int matrix[r][c], dp[r][c];
    cout << "Enter the matrix:" << endl;
    for(int i = 0; i < r; i++)for(int j = 0; j < c; j++){
        cin >> matrix[i][j];
        if(i==0) dp[i][j] = matrix[i][j];
        else{
            int *max = first_second_max(dp[i-1], c);
            dp[i][j] = matrix[i][j]+(dp[i-1][j] == max[0] ? max[1] : max[0]);
        }
    }
    cout << "Maximum sum: " << first_second_max(dp[r-1], c)[0] << endl;
    
    return 0;
}

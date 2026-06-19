import java.util.Scanner;
public class matrix_adjacent_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = matrix[i][j];
                if (i > 0) sum += matrix[i - 1][j];
                if (i < n - 1) sum += matrix[i + 1][j];
                if (j > 0) sum += matrix[i][j - 1];
                if (j < m - 1) sum += matrix[i][j + 1];
                result[i][j] = sum;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

import java.util.Scanner;

public class common_sub_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] flag = new int[2];
        int dp[][] = new int[s1.length()][s2.length()];
        flag[0] = 0;
        
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = (i > 0 && j > 0) ? dp[i - 1][j - 1] + 1 : 1;
                    if(dp[i][j] > flag[0]) {
                        flag[0] = dp[i][j];
                        flag[1] = i;
                    }
                }
                else dp[i][j] = 0;
            }
        }

        String result = "";
        for(int i = flag[1] - flag[0] + 1; i <= flag[1]; i++) {
            result += s1.charAt(i);
        }
        System.out.println(result);
        sc.close();
    }
}

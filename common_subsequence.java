import java.util.Scanner;
public class common_subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++) dp[i][0] = 0;
        for(int j = 0; j <= s2.length(); j++) dp[0][j] = 0;

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        String result = "";
        int i = s1.length(), j = s2.length();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                result = s1.charAt(i-1) + result;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])i--;
            else j--;
        }
        System.out.println(result);
        sc.close();
    }
}

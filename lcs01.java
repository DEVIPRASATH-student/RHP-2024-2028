import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(res);
        sc.close();
    }
}

import java.util.*;

public class P77486 {
    public static HashMap<String, Integer> result = new HashMap<>();
    public static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = solution(enroll, referral, seller, amount);
        for (int n : result) {
            System.out.println(n);
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                map.put(enroll[i], "center");
            } else {
                map.put(enroll[i], referral[i]);
            }
        }

        for ( int i = 0; i < seller.length; i++ ) {
            if ( result.containsKey(seller[i]) ) result.put(seller[i], result.get(seller[i]) + amount[i] * 100);
            else result.put(seller[i], amount[i] * 100);
            dfs(seller[i], amount[i] * 100);
        }

        for ( int j = 0; j < enroll.length; j++ ) {
            if ( result.containsKey(enroll[j]) ) {
                answer[j] += result.get(enroll[j]);
            }
        }

        return answer;
    }

    public static void dfs(String name, int price) {
        if ( name.equals("center") || price == 0 ) {
            return;
        }
        int value = (int) Math.floor(price * 0.1);
        result.put(name, result.get(name) - value);
        if ( result.containsKey(map.get(name)) ) result.put(map.get(name), result.get(map.get(name)) + value);
        else result.put(map.get(name), value);
        dfs(map.get(name), value);
    }

}
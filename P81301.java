import java.util.*;
public class P81301{
    public static final HashMap<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }
    };

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
    
    public static int solution(String s) {

        for ( String key : map.keySet() ) {
            s = s.replace(key, String.valueOf(map.get(key)));
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}
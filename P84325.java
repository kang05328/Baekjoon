import java.util.*;
public class Test {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"JAVA", "JAVASCRIPT"};
        int[] preference = {7, 5};
        System.out.println(solution(table, languages, preference));
    }
    public static String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, Integer> map = new HashMap<>();

        for ( int i = 0; i < table.length; i++ ) {
            String[] s = table[i].split(" ");
            String title = s[0];
            int score = 5;
            int sum = 0;
            for ( int j = 1; j < s.length; j++ ) {
                for ( int k = 0; k < languages.length; k++ ) {
                    if ( s[j].equals(languages[k]) ) {
                        sum += ( score * preference[k] );
                    }
                }
                score--;
            }
            map.put(title, sum);
        }

        int max = 0;
        String answer = "";

        for ( String key : map.keySet() ) {
            if ( max < map.get(key) ) {
                max = map.get(key);
                answer = key;
            } else if ( max == map.get(key) ) {
                if ( answer.compareTo(key) > 0 ) answer = key;
            }
        }

        return answer;
    }
}
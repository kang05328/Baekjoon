import java.util.ArrayList;
import java.util.List;

public class ProgrammersNW02 {

    public static void main(String[] args) {
        String s = "llttaattll";
        solution(s);
    }

    public static String[] solution(String s) {
        List<String> subStrings = new ArrayList<>();

        int l = s.length();
        int start = 0;
        int index = 0;
        int end = 1;
        while ( true ) {
            if ( end == l ) break;
            if ( s.substring(start, end).equals(s.substring(l - end, l))) {
                String subString = s.substring(start, end);
                subStrings.add(subString);
                s = s.substring(end, l-end);
                start = 0;
                end = 0;
                l = s.length();
                index++;
            }
            if ( l == 0 ) break;
            end++;
        }

        index = index * 2;
        boolean flag = false;
        if (!s.isEmpty()) {
            flag = true;
            index++;
        }

        String[] answer = new String[index];

        for ( int i = 0; i < subStrings.size(); i++ ) {
            answer[i] = subStrings.get(i);
        }
        if ( flag ) {
            answer[(index / 2)] = s;
        }
        for ( int i = 0; i < subStrings.size(); i++ ) {
            answer[index - 1 - i] = subStrings.get(i);
        }

        return answer;
    }

}
import java.util.*;

public class P42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] resultArray = solution(record);
        for ( String result : resultArray ) {
            System.out.println(result);
        }
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int count = 0;
        
        for ( int i = 0; i < record.length; i++ ) {
            String[] words = record[i].split(" ");
            if ( words[0].equals("Change") || words[0].equals("Enter") ) {
                map.put(words[1], words[2]);
            }
            if ( words[0].equals("Enter") || words[0].equals("Leave") ) count++;
        }
        
        String[] answer = new String[count];
        int index = 0;
        for ( int i = 0; i < record.length; i++ ) {
            String[] words = record[i].split(" ");
            if ( words[0].equals("Enter") ) {
                answer[index] = map.get(words[1]) + "님이 들어왔습니다.";
                index++;
            }
            if ( words[0].equals("Leave") ) {
                answer[index] = map.get(words[1]) + "님이 나갔습니다.";
                index++;
            }
            
        }
        
        return answer;
    }
}
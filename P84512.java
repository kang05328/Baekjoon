public class P84512 {
    public static final String[] words = {"A", "E", "I", "O", "U"};
    public static int count = 0;
    public static int answer = 0;
    
    public static void main(String[] args) {
        System.out.println(solution("I"));
    }
    public static int solution(String word) {

        back(word, "");

        return answer;
    }

    public static void back(String word, String result) {
        if ( word.equals(result) ) {
            answer = count;
            return;
        }
        if ( result.length() == 5 ) return;

        for ( int i = 0; i < words.length; i++ ) {
            count++;
            back(word, result + words[i]);
        }

    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class PMockExam {

    public static ArrayList<Integer>[] PATTERNS = (ArrayList<Integer>[]) new ArrayList[3];
    public static int[] scores = {0, 0, 0};
    public static int max = 0;

    public static void main(String[] args) {

        int[] answers = {1,3,2,4,2};

        int[] a = solution(answers);
        for ( int n : a ) {
            System.out.println(n);
        }
    }

    public static int[] solution(int[] answers) {

        PATTERNS[0] = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        PATTERNS[1] = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        PATTERNS[2] = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        for ( int i = 0; i < PATTERNS.length; i++ ) {
            check(answers, PATTERNS[i], 0, 0, 0, i);
        }

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < 3; i++ ) {
            if ( scores[i] == max ) sb.append(i + 1).append(",");
        }

        int[] answer = Arrays.asList(sb.toString().split(",")).stream()
                .mapToInt(Integer::parseInt).toArray();

        return answer;
    }

    public static void check(int[] answers, ArrayList<Integer> pattern, int index, int j, int score, int scoreIndex) {
        if (answers.length == index) {
            scores[scoreIndex] = Math.max(scores[scoreIndex], score);
            max = Math.max(max, score);
            return;
        }

        if ( j == pattern.size() ) j = 0;

        if ( answers[index] == pattern.get(j) ) {
            check(answers, pattern, index + 1, j + 1, score + 1, scoreIndex);
        } else {
            check(answers, pattern, index + 1, j + 1, score, scoreIndex);
        }

    }

}
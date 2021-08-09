
public class P83201 {
    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(solution(scores));
    }
    public static String solution(int[][] scores) {
        double[] average = new double[scores.length];

        for ( int i = 0; i < scores.length; i++ ) {
            int[] s = new int[scores.length];
            for ( int j = 0; j < scores.length; j++ ) {
                s[j] = scores[j][i];
            }
            average[i] = average(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < average.length; i++ ) {
            sb.append(grade(average[i]));
        }

        return sb.toString();
    }

    public static double average ( int[] scores, int index ) {

        int count = scores.length;
        int min = 2147483647;
        int max = 0;
        int sum = 0;

        for ( int i = 0; i < scores.length; i++ ) {
            sum += scores[i];
            max = Math.max(max, scores[i]);
            min = Math.min(min, scores[i]);
        }

        if ( max == scores[index] ) {
            int maxCount = 0;
            for ( int i = 0; i < scores.length; i++ ) {
                if ( scores[i] == max ) maxCount++;
            }
            if ( maxCount == 1 ) {
                sum -= scores[index];
                count--;
            }
        }
        if ( min == scores[index] ) {
            int minCount = 0;
            for ( int i = 0; i < scores.length; i++ ) {
                if ( scores[i] == min ) minCount++;
            }
            if ( minCount == 1 ) {
                sum -= scores[index];
                count--;
            }
        }

        return (double) sum / count;

    }

    public static String grade(double average) {
        String grade = "";

        if ( average >= 90 ) grade = "A";
        if ( average < 90 && average >= 80) grade = "B";
        if ( average < 80 && average >= 70) grade = "C";
        if ( average < 70 && average >= 50) grade = "D";
        if ( average < 50 ) grade = "F";

        return grade;
    }
}
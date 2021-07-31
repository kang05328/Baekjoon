import java.util.Arrays;
import java.util.HashMap;

public class PSearchPrimeNumber {

    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static boolean[] flag;
    public static String[] result;

    public static void main(String[] args) {

        System.out.println(solution("011"));

    }

    public static int solution(String numbers) {
        int[] numberArray = Arrays.asList(numbers.split("")).stream()
                .mapToInt(Integer::parseInt).toArray();

        for ( int i = 1; i <= numberArray.length; i++ ) {
            result = new String[i];
            flag = new boolean[numberArray.length];
            searchPrimeNumber(numberArray, numberArray.length + 1, 0, i);
        }

        int answer = map.size();

        return answer;
    }

    public static void searchPrimeNumber(int[] numbers, int n, int index, int m) {
        if ( index == m ) {
            int number = Integer.parseInt(String.join("", result));
            System.out.println("**" + number);
            if ( number > 1 && check(number) ) map.put(number, 1);
            return;
        }

        for ( int i = 1; i < n; i++ ) {
            if ( flag[i - 1] ) continue;
            flag[i-1] = true;
            result[index] = String.valueOf(numbers[i - 1]);
            searchPrimeNumber(numbers, n, index + 1, m);
            flag[i - 1] = false;
        }
    }

    public static boolean check(int number) {

        boolean flag = true;
        for ( int i = 2; i <= (int)Math.sqrt(number); i++ ) {
            if ( number % i == 0 ) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}
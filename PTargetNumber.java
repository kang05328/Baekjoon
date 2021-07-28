
public class PTargetNumber {

    public static int count = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
        System.out.println(count);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        calculator(0, numbers.length, 0, target, numbers);

        return answer;
    }

    public static void calculator(int index, int n, int sum, int target, int[] numbers) {
        if ( index == n ) {
            if ( sum == target ) count++;
            return;
        }

        calculator(index + 1, n, sum + numbers[index], target, numbers);
        calculator(index + 1, n, sum + (numbers[index] * -1), target, numbers);
    }

}
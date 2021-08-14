public class P42842 {
    public static void main(String[] args) {
        int[] x = solution(24, 24);
        for ( int n : x ) System.out.println(n);
    }
    public static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int w = 0;
        int h = 0;
        int[] answer = new int[2];

        int index = 3;
        while ( true ) {
            if ( index >= sum ) break;

            if ( sum % index == 0 ) {
                w = index;
                h = sum / index;
                if ( w >= h && w >= 3 && h >= 3 ) {
                    int round = (2 * (w - 2)) + (2 * h);
                    if ( round <= brown ) {
                        answer[0] = w;
                        answer[1] = h;
                    }
                }
            }

            index++;
        }


        return answer;
    }
}
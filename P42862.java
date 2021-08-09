public class P42862 {
    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(5, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] check = new int[n];
        
        for ( int i = 0; i < n; i++ ) {
            check[i]++;
            for ( int j = 0; j < lost.length; j++ ) {
                if ( i == lost[j] - 1 ) check[i]--;
            }
            for ( int j = 0; j < reserve.length; j++ ) {
                if ( i == reserve[j] - 1 ) check[i]++;
            }
        }
        
        for ( int i = 0; i < check.length; i++ ) {
            if ( check[i] == 0 ) {
                if ( i > 0 ) {
                    if ( check[i - 1] >= 2 ) {
                        check[i - 1]--;
                        check[i]++;
                    }
                }
                if ( i < check.length - 1 ) {
                    if ( check[i + 1] >= 2 ) {
                        check[i + 1]--;
                        check[i]++;
                    }
                }
            }
        }
        int answer = 0;
        for ( int i = 0; i < n; i++ ) {
            if ( check[i] > 0 ) answer++;
        }
        
        return answer;
    }
}
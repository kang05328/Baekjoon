class P12945 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static int solution(int n) {
        int a = 0;
        int b = 1;
        for ( int i = 2; i <= n; i++ ) {
            int result =  a + b;
            a = b % 1234567;
            b = result % 1234567;
        }
        int answer = b % 1234567;
        return answer;
    }
}
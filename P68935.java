public class P68935{
    public static void main(String[] args) {
        solution(45);
    }

    public static int solution(int n) {
        int answer = 0;
        
        String a = ternary(n);
        answer = decimal(a);
        
        return answer;
    }

    // 3진법 변경시 거꾸로 저장
    public static String ternary(int n) {
        String answer = "";
        
        while ( n >= 3 ) {
            answer = answer + ( n % 3 ); 
            n = n / 3;
        }
        
        answer = answer + n;
        
        return answer;
    }

    public static int decimal(String n) {
        int answer = 0;
        char[] c = n.toCharArray();
        
        for ( int i = 0; i < c.length; i++ ) {
            int num = (int) c[i] - 48;
            int num2 = (int) Math.pow(3, c.length - 1 - i);
            answer = answer + ( num * num2 );
        }
        
        return answer;
    }
}
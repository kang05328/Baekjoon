public class P60057{
    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }
    public static int solution(String s) {
        int answer = s.length();
        for ( int i = 1; i <= s.length() / 2; i++ ) {
            answer = Math.min(answer, abc(i, s));
        }
        return answer;
    }

    public static int abc(int n, String s) {
        String tmp = "";
        int flag = 0;
        int num = 1;
        String result = "";
        int index = n;
        while (s.length() >= n) {
            String tmp2 = s.substring(0, n);
            s = s.substring(n, s.length());
            if ( tmp.equals(tmp2) ) {
                num++;
                result = result.substring(0, flag) + num + tmp2;
            } else {
                num = 1;
                flag = result.length();
                result = result + tmp2;
            }
            tmp = tmp2;
            index += n;
        }

        result += s;

        return result.length();
    }
}
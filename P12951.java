public class P12951 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
    public static String solution(String s) {
        char[] c = s.toCharArray();
        boolean flag = false;

        c[0] = Character.toUpperCase(c[0]);

        for ( int i = 1; i < c.length; i++ ) {
            if ( flag ) {
                c[i] = Character.toUpperCase(c[i]);
                flag = false;
            } else {
                c[i] = Character.toLowerCase(c[i]);
            }
            if ( c[i] == ' ' ) {
                flag = true;
            }
        }

        return new String(c);
    }
}
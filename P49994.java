public class P49994 {
    public static HashSet<String> set = new HashSet<>();
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        char[] c = dirs.toCharArray();
        int x = 0;
        int y = 0;
        int index = 0;
        for ( int i = 0; i < c.length; i++ ) {
            if ( c[i] == 'U' ) index = 0;
            if ( c[i] == 'D' ) index = 1;
            if ( c[i] == 'R' ) index = 2;
            if ( c[i] == 'L' ) index = 3;
            int nx = x + dx[index];
            int ny = y + dy[index];
            if ( nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5 ) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb1.append(x).append(y).append(nx).append(ny);
                sb2.append(nx).append(ny).append(x).append(y);
                set.add(sb1.toString());
                set.add(sb2.toString());
                x = nx;
                y = ny;
            }
        }

        int answer = set.size() / 2;
        return answer;
    }
}
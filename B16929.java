import java.io.*;

public class B16929 {

    public static final int[] DX = {1, 0, -1, 0};
    public static final int[] DY = {0, -1, 0, 1};
    public static int N;
    public static int M;
    public static boolean[][] check;
    public static char[][] game;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            game = new char[N][M];
            check = new boolean[N][M];

            for ( int i = 0; i < N; i++ ) {
                char[] tmp = br.readLine().toCharArray();
                for ( int j = 0; j < M; j++ ) {
                    game[i][j] = tmp[j];
                }
            }

            boolean flag = false;

            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < M; j++ ) {
                    if ( !check[i][j] ) flag = dfs(i, j, i, j, game[i][j]);
                    if ( flag ) break;
                }
                if ( flag ) break;
            }

            if ( flag ) {
                bw.write("Yes");
            } else {
                bw.write("No");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean dfs(int x, int y, int px, int py, char color) {
        if ( check[x][y] ) return true;
        check[x][y] = true;
        for ( int i = 0; i < 4; i++ ) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if ( nx >= 0 && nx < N && ny >= 0 && ny < M ) {
                if ( !(nx == px && ny == py) && game[nx][ny] == color ) {
                    if ( dfs(nx, ny, x, y, color) ) return true;
                }
            }
        }

        return false;
    }
}
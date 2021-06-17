import java.io.*;
import java.util.*;

public class B1012 {

    public static boolean[][] dfs;
    public static int[][] array;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int CASE = Integer.parseInt(br.readLine());

            for ( int c = 0; c < CASE; c++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());

                dfs = new boolean[N][M];
                array = new int[N][M];

                for ( int i = 0; i < K; i ++ ) {
                    String[] s2 = br.readLine().split(" ");
                    array[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = 1;
                }

                int count = 0;
                for ( int i = 0; i < N; i++) {
                    for ( int j = 0; j < M; j++ )
                    if ( !dfs[i][j] && array[i][j] == 1 ) {
                        count++;
                        dfs(i, j, N, M);
                    }
                }
                bw.write("" + count);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void dfs(int x, int y, int N, int M) {
        dfs[x][y] = true;

        for ( int i = 0; i < 4; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( nx >= 0 && ny >= 0 && nx < N && ny < M ) {
                if ( !dfs[nx][ny] && array[nx][ny] == 1 ) dfs(nx, ny, N, M);
            }
        }
    }

}
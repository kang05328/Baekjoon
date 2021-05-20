import java.io.*;
import java.util.*;

class Pair {
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
}

public class B2178 {

    public static boolean[][] flag;
    public static int[][] array;
    public static int[][] dist;
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};
    public static Queue<Pair> queue = new LinkedList<>();

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            array = new int[N][M];
            dist = new int[N][M];
            dist[0][0] = 1;
            flag = new boolean[N][M];

            for ( int i = 0; i < N; i++ ) {
                char[] c = br.readLine().toCharArray();
                for ( int j = 0; j < M; j++ ) {
                    array[i][j] = Integer.parseInt(String.valueOf(c[j]));
                }
            }

            bfs(N, M);

            bw.write("" + dist[N - 1][M - 1]);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n, int m) {
        queue.offer(new Pair(0, 0));
        flag[0][0] = true;

        while ( !queue.isEmpty() ) {
            Pair p = queue.peek();
            int x = p.x;
            int y = p.y;
            queue.poll();

            for ( int i = 0; i < 4; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ( nx >= 0 && ny >= 0 && nx < n && ny < m ) {
                    if (array[nx][ny] == 1 && !flag[nx][ny] ) {
                        queue.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        flag[nx][ny] = true;
                    }
                }
            }
        }
    }

}
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

public class B7576 {

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
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            array = new int[N][M];
            dist = new int[N][M];
            flag = new boolean[N][M];

            for ( int i = 0; i < N; i++ ) {
                String s2 = br.readLine();
                StringTokenizer st2 = new StringTokenizer(s2);
                for ( int j = 0; j < M; j++ ) {
                    array[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            boolean f = true;
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < M; j++ ) {
                    if ( array[i][j] == 0 ) f = false;
                    if ( array[i][j] == 1 ) {
                        queue.offer(new Pair(i, j));
                        flag[i][j] = true;
                        dist[i][j] = 1;
                    }
                }
            }
            bfs(N, M);
            if ( f ) {
                System.out.println("0");
                System.exit(0);
            }

            int max = 0;
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < M; j++ ) {
                    if ( array[i][j] == -1 ) dist[i][j] = -1;
                    if ( dist[i][j] == 0 ) {
                        System.out.println("-1");
                        System.exit(0);
                    }
                    if ( max < dist[i][j] ) max = dist[i][j];
                }
            }
            bw.write("" + (max - 1));

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n, int m) {

        while ( !queue.isEmpty() ) {
            Pair p = queue.peek();
            int x = p.x;
            int y = p.y;
            queue.poll();

            for ( int i = 0; i < 4; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ( nx >= 0 && ny >= 0 && nx < n && ny < m ) {
                    if (array[nx][ny] == 0 && !flag[nx][ny] ) {
                        queue.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        flag[nx][ny] = true;
                    }
                }
            }
        }
    }

}
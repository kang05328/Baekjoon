import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int time;

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Pair p) {
        if ( this.time > p.time ) return 1;
        else if ( this.time < p.time ) return -1;
        return 0;
    }
}

public class B1261 {

    public static PriorityQueue<Pair> queue = new PriorityQueue<>();
    public static int[][] maze;
    public static boolean[][] flag = new boolean[101][101];
    public static int result = 0;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            maze = new int[M][N];
            for ( int i = 0; i < M; i++ ) {
                String[] line = br.readLine().split("");
                for ( int j = 0; j < N; j++ ) {
                    maze[i][j] = Integer.parseInt(line[j]);
                }
            }

            bfs(M - 1, N - 1 );

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n, int m) {

        Pair p = new Pair(0, 0, 0);
        queue.offer(p);
        flag[0][0] = true;

        while ( !queue.isEmpty() ) {
            Pair p2 = queue.peek();
            int x = p2.x;
            int y = p2.y;
            int count = p2.time;
            queue.poll();

            boolean f = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ( nx >= 0 && ny >= 0 && nx <= n && ny <= m ) {
                    int c = count;
                    if ( !flag[nx][ny] ) {
                        if ( maze[nx][ny] == 1) c++;
                        if ( nx == n && ny == m ) {
                            f = true;
                            result = c;
                        }
                        queue.offer(new Pair(nx, ny, c));
                        flag[nx][ny] = true;
                    }
                }
            }
            if (f) break;
        }
    }

}
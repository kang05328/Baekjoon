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

public class B7562 {

    public static boolean[][] flag;
    public static int[][] array;
    public static int[][] dist;
    public static int dx[] = {1,2,2,1,-1,-2,-2,-1};
    public static int dy[] = {2,1,-1,-2,-2,-1,1,2};
    public static Queue<Pair> queue = new LinkedList<>();

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int loop = Integer.parseInt(br.readLine());
            for ( int k = 0; k < loop; k++ ) {
                int I = Integer.parseInt(br.readLine());
                array = new int[I][I];
                dist = new int[I][I];
                flag = new boolean[I][I];

                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                String s2 = br.readLine();
                StringTokenizer st2 = new StringTokenizer(s2);
                int c = Integer.parseInt(st2.nextToken());
                int d = Integer.parseInt(st2.nextToken());

                queue.offer(new Pair(a, b));
                flag[a][b] = true;
                dist[a][b] = 1;

                bfs(I, I);

                bw.write("" + (dist[c][d] - 1));
                bw.newLine();
            }
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

            for ( int i = 0; i < 8; i++ ) {
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
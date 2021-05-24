import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    int time;

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class B14226 {

    public static Queue<Pair> queue = new LinkedList<>();
    public static boolean[][] flag = new boolean[1001][1001];
    public static int result = 0;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            bfs(1, N);

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n, int k) {

        Pair p = new Pair(n, 0, 0);
        queue.offer(p);
        flag[n][0] = true;

        while ( !queue.isEmpty() ) {
            Pair p2 = queue.peek();
            int m = p2.x;
            int q = p2.y;
            int count = p2.time;
            queue.poll();

            int[] dm = {m, m + q, m - 1};
            int[] dq = {m, q, q};
            count++;

            boolean f = false;
            for (int i = 0; i < 3; i++) {
                if ( dm[i] > 0 && dm[i] <= 1000 && dq[i] > 0 && dq[i] <= 1000 ) {
                    if ( !flag[dm[i]][dq[i]] ) {
                        if (dm[i] == k) {
                            f = true;
                            result = count;
                        }
                        queue.offer(new Pair(dm[i], dq[i], count));
                        flag[dm[i]][dq[i]] = true;
                    }
                }
            }
            if (f) break;
        }
    }

}
import java.io.*;
import java.util.*;

class Pair {
    int x;
    int time;

    public Pair(int x, int time) {
        this.x = x;
        this.time = time;
    }
}

public class B1463 {

    public static Queue<Pair> queue = new LinkedList<>();
    public static boolean[] flag = new boolean[1000001];
    public static int result = 0;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            if ( N != 1 ) {
                bfs(N);
            }

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n) {
        Pair p = new Pair(n, 0);
        queue.offer(p);
        flag[n] = true;

        while ( !queue.isEmpty() ) {
            Pair p2 = queue.peek();
            int x = p2.x;
            int count = p2.time;
            queue.poll();

            if ( x == 1 ) {
                result = count;
                break;
            }

            if ( x >= 1 && x <= 1000000 ) {
                if ( x % 2 == 0 ) {
                    if ( !flag[x / 2] ) {
                        queue.offer(new Pair(x / 2, count + 1));
                        flag[x / 2] = true;
                    }
                }
                if ( x % 3 == 0 ) {
                    if ( !flag[x / 3] ) {
                        queue.offer(new Pair(x / 3, count + 1));
                        flag[x / 3] = true;
                    }
                }
                if ( !flag[x - 1] ) {
                    queue.offer(new Pair(x - 1, count + 1));
                    flag[x - 1] = true;
                }
            }
        }
    }

}
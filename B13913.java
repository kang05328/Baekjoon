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

public class B13913 {

    public static Queue<Pair> queue = new LinkedList<>();
    public static boolean[] flag = new boolean[100001];
    public static int[] dist = new int[100001];
    public static int result = 0;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            bfs(N, K);

            bw.write("" + result);
            bw.newLine();
            Stack<Integer> stack = new Stack<>();
            stack.push(K);
            int a = K;
            for ( int i = 0; i < result; i++ ) {
                stack.push(dist[a]);
                a = dist[a];
            }

            for ( int i = 0; i < result + 1; i++ ) {
                bw.write(stack.peek() + " ");
                stack.pop();
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void bfs(int n, int k) {

        Pair p = new Pair(n, 0);
        queue.offer(p);
        flag[n] = true;

        while ( !queue.isEmpty() ) {
            Pair p2 = queue.peek();
            int m = p2.x;
            int count = p2.time;
            queue.poll();

            int[] values = new int[3];
            values[0] = m + 1;
            values[1] = m - 1;
            values[2] = m * 2;
            count++;

            boolean f = false;
            for ( int i = 0; i < 3; i++) {
                if ( values[i] >= 0 && values[i] <= 100000) {
                    if (!flag[values[i]]) {
                        if (values[i] == k) {
                            f = true;
                            result = count;
                        }
                        queue.offer(new Pair(values[i], count));
                        flag[values[i]] = true;
                        dist[values[i]] = m;
                    }
                }
            }
            if ( f ) break;
        }
    }

}
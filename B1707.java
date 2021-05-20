import java.io.*;
import java.util.*;

class Edge {
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    int from;
    int to;
}

public class B1707 {

    public static int[] dfs;
    public static boolean[] bfs;
    public static ArrayList<Integer>[] list;
    public static ArrayList<Edge> edges;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int loop = Integer.parseInt(br.readLine());
            for ( int k = 0; k < loop; k++ ) {

                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                dfs = new int[N];
                bfs = new boolean[N];
                list = (ArrayList<Integer>[]) new ArrayList[N];
                edges = new ArrayList<>();

                for ( int i = 0; i < N; i++ ) {
                    list[i] = new ArrayList<>();
                }
                for ( int i = 0; i < M; i++ ) {
                    String s2 = br.readLine();
                    StringTokenizer st2 = new StringTokenizer(s2);
                    int x = Integer.parseInt(st2.nextToken()) - 1;
                    int y = Integer.parseInt(st2.nextToken()) - 1;

                    edges.add(new Edge(x, y));
                    edges.add(new Edge(y, x));
                    list[x].add(y);
                    list[y].add(x);
                }

                for ( int i = 0; i < N; i++ ) {
                    Collections.sort(list[i], new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    });
                }

                boolean f = true;
                for ( int i = 0; i < N; i++ ) {
                    if ( dfs[i] == 0 ) {
                        if ( !dfs(i, 1) ) f = false;
                    }
                }

                if ( f ) bw.write("YES");
                else bw.write("NO");
                bw.newLine();
            }


            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean dfs(int x, int check) {
        dfs[x] = check;
        for ( int i = 0; i < list[x].size(); i++ ) {
            int y = list[x].get(i);
            if ( dfs[y] == 0 ) {
                if ( !dfs(y, 3 - check ) ) return false;
            } if ( dfs[x] == dfs[y] ) {
                return false;
            }
        }
        return true;
    }

    public static void bfs(int x) {
        bfs[x] = true;
        queue.offer(x);
        while ( !queue.isEmpty() ) {
            int y = queue.peek();
            queue.poll();
            for ( int i = 0; i < list[y].size(); i++ ) {
                int k = list[y].get(i);
                if ( !bfs[k] ) {
                    bfs[k] = true;
                    queue.offer(k);
                }
            }
        }
    }

}
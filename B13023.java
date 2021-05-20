import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    int from;
    int to;
}

public class B13023 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[][] a = new boolean[N][N];
            ArrayList<Integer>[] b = (ArrayList<Integer>[]) new ArrayList[N];
            ArrayList<Edge> edges = new ArrayList<>();

            for ( int i = 0; i < N; i++ ) {
                b[i] = new ArrayList<>();
            }
            for ( int i = 0; i < M; i++ ) {
                String s2 = br.readLine();
                StringTokenizer st2 = new StringTokenizer(s2);
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                edges.add(new Edge(x, y));
                edges.add(new Edge(y, x));
                b[x].add(y);
                b[y].add(x);
                a[x][y] = true;
                a[y][x] = true;
            }

            M *= 2;

            for ( int i = 0; i < M; i++ ) {
                for ( int j = 0; j < M; j++ ) {
                    int A = edges.get(i).from;
                    int B = edges.get(i).to;
                    int C = edges.get(j).from;
                    int D = edges.get(j).to;
                    if ( A == B || A == C || A == D || B == C || B == D || C == D) continue;

                    if ( !a[B][C] ) continue;
                    for ( int E : b[D] ) {
                        if ( A == E || B == E || C == E || D == E ) continue;
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
            System.out.println(0);
            
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
import java.util.ArrayList;

class Edge {
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    int from;
    int to;
}

public class PNetwork {

    public static int count = 0;
    public static boolean[] check;
    public static ArrayList<Edge> edges;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};

        System.out.println(solution(n, computers));
        System.out.println(count);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        check = new boolean[n];
        edges = new ArrayList<>();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( computers[i][j] == 1 ) {
                    edges.add(new Edge(i, j));
                }
            }
        }

        for ( int i = 0; i < n; i++ ) {
            if ( !check[i] ) {
                dfs(i);
                count++;
            }
        }

        answer = count;

        return answer;
    }

    public static void dfs(int x) {
        check[x] = true;

        for ( int i = 0; i < edges.size(); i++ ) {
            Edge edge = edges.get(i);
            if ( edge.from == x ) {
                if ( !check[edge.to] ) dfs(edge.to);
            }
        }
    }

}
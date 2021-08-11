import java.util.*;
class Edge {
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    public int from;
    public int to;
}
public class P49189 {
    public static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] edge = {{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(5, edge));
    }

    public static int solution(int n, int[][] edge) {
        for ( int i = 0; i < edge.length; i++ ) {
            edgeList.add(new Edge(edge[i][0], edge[i][1]));
            edgeList.add(new Edge(edge[i][1], edge[i][0]));
        }

        int answer = bfs(1, n);

        return answer;
    }
    public static int bfs(int start, int n) {
        int max = 0;
        int[] d = new int[n];
        d[0] = 0;
        for ( int i = 1; i < n; i++ ) {
            d[i] = -1;
        }
        q.offer(start);

        while ( !q.isEmpty() ) {
            int node = q.peek();
            q.poll();

            for ( Edge e : edgeList ) {
                if ( e.from == node ) {
                    if ( d[e.to - 1] == -1 ) {
                        q.offer(e.to);
                        d[e.to - 1] = d[e.from - 1] + 1;
                        max = Math.max(max, d[e.to - 1]);
                    }
                }
            }
        }

        int result = 0;
        for ( int x : d ) {
            if ( x == max ) result++;
        }

        return result;
    }
}
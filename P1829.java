import java.util.*;
class Node {
    int x;
    int y;
    int value;
    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
public class P1829 {
    public static boolean[][] check;
    public static Queue<Node> q = new LinkedList<>();
    public static int max = 0;
    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        int[] result = solution(6, 4, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        check = new boolean[m][n];
        int numberOfArea = 0;

        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( !check[i][j] && picture[i][j] != 0 ) {
                    bfs(picture, i, j);
                    numberOfArea++;
                }
            }
        }


        int maxSizeOfOneArea = max;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void bfs(int[][] picture, int m, int n) {
        q.offer(new Node(m, n, picture[m][n]));
        check[m][n] = true;
        int count = 1;

        while ( !q.isEmpty() ) {
            Node node = q.peek();
            q.poll();

            for ( int i = 0; i < 4; i++ ) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if ( nx >= 0 && ny >= 0 && nx < picture.length && ny < picture[0].length ) {
                    if ( !check[nx][ny] && node.value == picture[nx][ny] ) {
                        q.offer(new Node(nx, ny, picture[nx][ny]));
                        check[nx][ny] = true;
                        count++;
                    }
                }
            }

        }

        max = Math.max(count, max);
    }
}
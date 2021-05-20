import java.io.*;
import java.util.*;

public class B2667 {

    public static boolean[][] flag;
    public static int[][] array;
    public static int[] community;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            array = new int[N][N];
            flag = new boolean[N][N];
            community = new int[N*N];

            for ( int i = 0; i < N; i++ ) {
                char[] c = br.readLine().toCharArray();
                for ( int j = 0; j < N; j++ ) {
                    array[i][j] = Integer.parseInt(String.valueOf(c[j]));
                }
            }

            int count = 0;
            int index = 0;
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < N; j++ ) {
                    if ( array[i][j] == 1 && !flag[i][j] ) {
                        community[index] = 1;
                        dfs(i, j, N - 1, index);
                        count++;
                        index++;
                    }
                }
            }
            bw.write("" + count);
            bw.newLine();

            Arrays.sort(community);

            for ( int i = 0; i < community.length; i++ ) {
                if ( community[i] != 0 ) {
                    bw.write("" + community[i]);
                    bw.newLine();
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void dfs(int x, int y, int n, int index) {
        flag[x][y] = true;

        if ( array[x][y] == 1 ) {

            if ( x < n && array[x + 1][y] == 1 && !flag[x + 1][y]) {
                int cnt = community[index];
                community[index] = cnt + 1;
                dfs(x + 1, y, n, index);
            }
            if ( x > 0 && array[x - 1][y] == 1 && !flag[x - 1][y]) {
                int cnt = community[index];
                community[index] = cnt + 1;
                dfs(x - 1, y, n, index);
            }
            if ( y < n && array[x][y + 1] == 1 && !flag[x][y + 1]) {
                int cnt = community[index];
                community[index] = cnt + 1;
                dfs(x, y + 1, n, index);
            }
            if ( y > 0 && array[x][y - 1] == 1 && !flag[x][y - 1]) {
                int cnt = community[index];
                community[index] = cnt + 1;
                dfs(x, y - 1, n, index);
            }
        } else {
            return;
        }
    }

}
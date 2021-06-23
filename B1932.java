import java.io.*;

public class B1932 {

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[][] triangle = new int[N][N];
            int[][] D = new int[N][N];

            for ( int i = 0; i < N; i++ ) {
                String[] s = br.readLine().split(" ");
                for ( int j = 0; j <= i; j++ ) {
                    triangle[i][j] = Integer.parseInt(s[j]);
                }
            }

            D[0][0] = triangle[0][0];
            int max = 0;

            for ( int i = 1; i < N; i++ ) {
                for ( int j = 0; j <= i; j++ ) {
                    if ( j == 0 ) {
                        D[i][j] = triangle[i][j] + D[i - 1][j];
                    } else if ( j == i ) {
                        D[i][j] = triangle[i][j] + D[i - 1][j - 1];
                    } else {
                        D[i][j] = triangle[i][j] + Math.max(D[i - 1][j - 1], D[i - 1][j]);
                    }

                }
            }

            for ( int i = 0; i < N; i++ ) {
                max = Math.max(max, D[N - 1][i]);
            }

            bw.write("" + max);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
import java.io.*;

public class B15990 {

    public static long[][] d;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());
            d = new long[100001][4];
            d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;
            for ( int s = 0; s < T; s++ ) {
                int N = Integer.parseInt(br.readLine());
                for ( int i = 4; i <= N; i++ ) {
                    for ( int j = 1; j <= 3; j++ ) {
                        if ( d[i][j] == 0 ) {
                            if ( j == 1 ) {
                                d[i][j] = ( d[i - 1][2] + d[i - 1][3] ) % 1000000009;
                            }
                            if ( j == 2 ) {
                                d[i][j] = ( d[i - 2][1] + d[i - 2][3] ) % 1000000009;
                            }
                            if ( j == 3 ) {
                                d[i][j] = ( d[i - 3][1] + d[i - 3][2] ) % 1000000009;
                            }
                        }
                    }
                }

                long count = ( d[N][1] + d[N][2] + d[N][3] ) % 1000000009;

                bw.write("" + count);
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
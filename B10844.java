import java.io.*;

public class B10844 {

    public static long[][] d;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            d = new long[101][10];
            d[1][0] = 0;
            for ( int i = 1; i <= 9; i++ ) {
                d[1][i] = 1;
            }
            for ( int i = 2; i <= N; i++ ) {
                for ( int j = 0; j <= 9; j++ ) {
                    if ( j == 0 ) {
                        d[i][j] = (d[i - 1][j + 1]) % 1000000000;
                    }
                    else if ( j == 9 ) {
                        d[i][j] = (d[i - 1][j - 1]) % 1000000000;
                    } else {
                        d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
                    }
                }
            }

            long count = 0;
            for ( int i = 0; i <= 9; i++ ) {
                count += d[N][i];
            }

            count = count % 1000000000;

            bw.write("" + count);
            bw.newLine();

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
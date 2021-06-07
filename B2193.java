import java.io.*;

public class B2193 {

    public static long[][] d;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            d = new long[91][2];
            d[1][0] = 0;
            d[1][1] = 1;

            for ( int i = 2; i <= N; i++ ) {
                for ( int j = 0; j <= 1; j++ ) {
                    if ( j == 0 ) {
                        d[i][j] = d[i - 1][0] + d[i - 1][1];
                    } else {
                        d[i][j] = d[i - 1][0];
                    }
                }
            }

            long count = d[N][0] + d[N][1];

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
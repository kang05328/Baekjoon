import java.io.*;

public class B16194 {

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] P = new int[N + 1];
            int[] d = new int[N + 1];
            for ( int i = 1; i <= N; i++ ) {
                d[i] = 1000 * 10000;
            }
            String[] s = br.readLine().split(" ");
            for ( int i = 1; i <= N; i++ ) {
                P[i] = Integer.parseInt(s[i - 1]);
            }

            for ( int i = 1; i <= N; i++ ) {
                for ( int j = 1; j <= i; j++ ) {
                    d[i] = Math.min(d[i], d[i - j] + P[j]);
                }
            }

            bw.write("" + d[N]);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
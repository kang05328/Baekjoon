import java.io.*;

public class B15988 {

    public static long[] d = new long[1000001];

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            for ( int i = 0; i < N; i++ ) {
                int number = Integer.parseInt(br.readLine());
                long count = dp(number);
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

    public static long dp(int n) {
        if ( n == 0 || n == 1) return 1;
        if ( n == 2 ) return 2;
        if ( n == 3 ) return 4;
        if ( d[n] > 0 ) return d[n];

        d[n] = ( dp(n-1) + dp(n-2) + dp(n-3) ) % 1000000009;

        return d[n];
    }

}
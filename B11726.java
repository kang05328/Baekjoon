import java.io.*;

public class B11726 {

    public static int[] d = new int[1001];

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            int count = dp(N);

            bw.write("" + count);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static int dp( int n ) {
        if ( n == 0 || n == 1 ) return 1;
        if ( d[n] > 0 ) return d[n];
        d[n] = (dp(n - 1) + dp(n - 2)) % 10007;
        return d[n];
    }

}
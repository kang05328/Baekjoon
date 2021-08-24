import java.io.*;

public class B16922 {
    public static boolean[] flag = new boolean[1001];

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            for ( int i = 0; i <= N; i++ ) {
                for ( int j = 0; j <= N - i; j++ ) {
                    for ( int k = 0; k <= N - i - j; k++ ) {
                        int l = N - i - j - k;
                        int sum = i + ( 5 * j ) + ( 10 * k ) + ( 50 * l );
                        flag[sum] = true;
                    }
                }
            }

            int count = 0;
            for ( int i = 1; i < 1001; i++ ) {
                if ( flag[i] ) count++;
            }
            bw.write("" + count);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
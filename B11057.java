import java.io.*;

public class B11057 {

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[][] D = new int[N + 1][10];
            int result = 0;

            D[0][0] = 1;


            for ( int i = 1; i < N + 1; i++ ) {
                for ( int j = 0; j < 10; j++ ) {
                    for ( int k = 0; k <= j; k++ ) {
                        D[i][j] += D[i - 1][k];
                    }
                    D[i][j] = D[i][j] % 10007;
                    if ( i == N ) {
                        result += D[i][j];
                    }
                }
            }

            bw.write("" + result % 10007);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
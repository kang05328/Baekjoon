import java.io.*;

public class B1309 {

    public static long[] d = new long[1000001];

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[][] D = new int[N][3];
            int result = 0;

            D[0][0] = D[0][1] = D[0][2] = 1;
            for ( int i = 1; i < N; i++ ) {
                D[i][0] = ( D[i - 1][0] + D[i - 1][1] + D[i - 1][2] ) % 9901;
                D[i][1] = ( D[i - 1][0] + D[i - 1][2] ) % 9901;
                D[i][2] = ( D[i - 1][0] + D[i - 1][1] ) % 9901;
            }
            result = ( D[N - 1][0] + D[N - 1][1] + D[N - 1][2] ) % 9901;

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
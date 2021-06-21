import java.io.*;

public class B2156 {

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] alcohol = new int[N + 1];
            int[] D = new int[N + 1];

            for ( int i = 1; i < N + 1; i++ ) {
                alcohol[i] = Integer.parseInt(br.readLine());
            }

            D[1] = alcohol[1];
            if ( N > 1 ) {
                D[2] = alcohol[1] + alcohol[2];
            }
            for ( int i = 3; i < N + 1; i++ ) {
                int tmp1 = D[i - 1];
                int tmp2 = D[i - 2] + alcohol[i];
                int tmp3 = D[i - 3] + alcohol[i - 1] + alcohol[i];
                if ( tmp1 > tmp2 ) {
                    D[i] = Math.max(tmp1, tmp3);
                } else {
                    D[i] = Math.max(tmp2, tmp3);
                }
            }

            bw.write("" + D[N]);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
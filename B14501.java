import java.io.*;
import java.util.StringTokenizer;

public class B14501 {

    public static int[] T;
    public static int[] P;
    public static int max = 0;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            T = new int[N];
            P = new int[N];

            for ( int i = 0; i < N; i++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                T[i] = Integer.parseInt(st.nextToken());
                P[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0, 0, N, 0);

            bw.write("" + max);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void back(int index, int t, int p, int n, int sum) {
        if ( index + t >= n ) {
            if ( index + t > n ) {
                sum = sum - p;
            }
            if ( max < sum ) max = sum;
            return;
        }
        for ( int i = index + t; i < n; i++ ) {
            back(i, T[i], P[i], n, sum + P[i]);
        }
    }

}
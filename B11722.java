import java.io.*;
import java.util.*;

public class B11722 {

    public static int[] numbers;
    public static int[] D;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            D = new int[1001];
            String[] s = br.readLine().split(" ");
            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            int max = 0;

            for ( int i = 0; i < N; i ++ ) {
                int tmp = 0;
                for ( int j = 0; j <= i; j++ ) {
                    if ( i == j && D[i] == 0 ) {
                        D[i] = 1;
                    }
                    if ( i > j && numbers[i] < numbers[j] ) {
                        if ( D[i] == 0 ) D[i]++;
                        if ( tmp < D[i] + D[j] ) tmp = D[i] + D[j];
                    }
                }
                if ( tmp > D[i] ) D[i] = tmp;
                if ( max < D[i] ) max = D[i];
            }

            bw.write("" + max );

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
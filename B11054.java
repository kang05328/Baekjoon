import java.io.*;
import java.util.Arrays;

public class B11054 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            int[] D = new int[1001];
            int[] D1 = new int[1001];
            int[] D2 = new int[1001];

            String[] s = br.readLine().split(" ");
            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(s[i]);
            }

            for ( int i = 0; i < N; i ++ ) {
                int tmp = 0;
                // i 까지 증가하는 수열 길이
                for ( int j = 0; j <= i; j++ ) {
                    if ( i == j && D1[i] == 0 ) {
                        D1[i] += 1;
                    }
                    if ( i > j && numbers[i] > numbers[j] ) {
                        if ( D1[i] == 0 ) D1[i]++;
                        if ( tmp < D1[i] + D1[j] ) tmp = D1[i] + D1[j];
                    }
                }
                if ( tmp > D1[i] ) D1[i] = tmp;
            }

            for ( int i = N - 1; i >= 0; i -- ) {
                int tmp = 0;
                // i를 시작으로 감소 수열 길이
                for ( int j = N - 1; j > i; j -- ) {
                    if ( i == j && D2[i] == 0 ) {
                        D2[i] += 1;
                    }
                    if ( i < j && numbers[i] > numbers[j] ) {
                        if ( D2[i] == 0 ) D2[i]++;
                        if ( tmp < D2[i] + D2[j] ) tmp = D2[i] + D2[j];
                    }
                }
                if ( tmp > D2[i] ) D2[i] = tmp;
            }

            for ( int i = 0; i < N; i++ ) {
                D[i] = D1[i] + D2[i];
            }

            bw.write("" + Arrays.stream(D).max().getAsInt());

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
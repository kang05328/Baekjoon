import java.io.*;
import java.util.*;

public class B1463 {

    public static int[] flag = new int[1000001];

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int result = dp(N);

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static int dp(int n) {
        if ( n == 1 ) return 0;
        if ( flag[n] > 0 ) return flag[n];

        flag[n] = dp(n-1) + 1;
        if ( n % 2 == 0 ) {
            int tmp = dp(n/2) + 1;
            if ( flag[n] > tmp ) flag[n] = tmp;
        }
        if ( n % 3 == 0 ) {
            int tmp = dp(n/3) + 1;
            if ( flag[n] > tmp ) flag[n] = tmp;
        }

        return flag[n];
    }

}
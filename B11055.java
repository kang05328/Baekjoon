import java.io.*;
import java.util.Arrays;

public class B11055 {

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

            for ( int i = 0; i < N; i++ ) {
                D[i] = numbers[i];
                for ( int j = 0; j <= i; j++ ) {
                    if ( numbers[j] < numbers[i] && D[i] < (D[j] + numbers[i]) ) D[i] = D[j] + numbers[i];
                }
            }

            int max = Arrays.stream(D).max().getAsInt();

            bw.write("" + max );

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
import java.io.*;

public class B1912 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            int[] D = new int[N];
            String[] s = br.readLine().split(" ");
            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            int max = 0;

            D[0] = max = numbers[0];
            for ( int i = 1; i < N; i++ ) {
                D[i] = Math.max(D[i - 1] + numbers[i], numbers[i]);
                max = Math.max(max, D[i]);
            }

            bw.write("" + max);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
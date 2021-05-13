import java.io.*;
public class Main {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            int[] array = new int[N];
            int[] range = new int[10001]; // 주어지는 수의 범위
            int[] result = new int[N];

            for ( int i = 0; i < N; i++ ) {
                array[i] = Integer.parseInt(br.readLine());
            }

            for ( int i = 0; i < N; i++ ) {
                range[array[i]]++;
            }
            for ( int i = 1; i < range.length; i++ ) {
                range[i] += range[i - 1];
            }
            for ( int i = N - 1; i >= 0; i--) {
                int num = array[i];
                range[num]--;
                result[range[num]] = num;
            }

            for ( int i = 0; i < N; i++ ) {
                bw.write("" + result[i]);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
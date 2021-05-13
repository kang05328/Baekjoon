import java.io.*;
public class B9663 {

    public static int[] chess;
    public static int count = 0;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            chess = new int[N];

            queen(0, N);
            bw.write("" + count);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void queen(int index, int n) {
        if ( index == n ) {
            count++;
            return;
        }

        for ( int i = 0; i < n; i++ ) {
            chess[index] = i;
            if ( check(index) ) {
                queen(index + 1, n);
            }
        }
    }

    public static boolean check(int col) {
        for ( int i = 0; i < col; i++ ) {
            if ( chess[col] == chess[i] ) {
                return false;
            }
            if ( Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {
                return false;

            }
        }
        return true;
    }

}
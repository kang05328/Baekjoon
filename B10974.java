import java.io.*;
import java.util.StringTokenizer;

public class B10974 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] a = new int[N];
            for ( int i = 0; i < N; i++ ) {
                a[i] = i + 1;
                bw.write(a[i] + " ");
            }
            bw.newLine();

            while ( nextPermutation(a) ) {
                for ( int i = 0; i < N; i++ ) {
                    bw.write(a[i] + " ");
                }
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean prevPermutation(int[] a) {
        int i = a.length - 1;
        while ( i > 0 && a[i - 1] <= a[i] ) i--;
        if ( i <= 0 ) return false;

        int j = a.length - 1;
        while ( a[j] >= a[i - 1] ) j--;

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while ( i < j ) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while ( i > 0 && a[i - 1] >= a[i] ) i--;
        if ( i <= 0 ) return false;

        int j = a.length - 1;
        while ( a[j] <= a[i - 1] ) j--;

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while ( i < j ) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
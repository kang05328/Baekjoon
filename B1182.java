import java.io.*;

public class B1182 {

    public static int sum = 0;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] input = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            int[] array = new int[Integer.parseInt(input[0])];
            int count = 0;

            for ( int i = 0; i < Integer.parseInt(input[0]); i++ ) {
                array[i] = Integer.parseInt(input2[i]);
            }

            for ( int i = 1; i < (1<<Integer.parseInt(input[0])); i++ ) {
                int sum = 0;
                for ( int k = 0; k < Integer.parseInt(input[0]); k++ ) {
                    if ( (i & (1<<k)) != 0 ) {
                        sum += array[k];
                    }
                }
                if ( sum == Integer.parseInt(input[1]) )
                    count++;
            }

            bw.write("" + count);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

/** 재귀 풀이
 * 
import java.io.*;

public class Main {

    public static int[] numbers;
    public static boolean[] check;
    public static int count = 0;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int S = Integer.parseInt(s[1]);
            String[] tmp = br.readLine().split(" ");
            numbers = new int[N];
            check = new boolean[N];

            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(tmp[i]);
            }

            back(0, N, S, 0);

            if ( S == 0 ) count = count - 1;
            bw.write("" + count);
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void back(int index, int n, int S, int sum) {
        if ( index == n ) {
            if ( sum == S ) count++;
            return;
        }
        back(index + 1, n, S, sum + numbers[index]);
        back(index + 1, n, S, sum);
    }
}
 */
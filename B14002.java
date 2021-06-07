import java.io.*;
import java.util.*;

public class B14002 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            int[][] D = new int[N][2];
            String[] s = br.readLine().split(" ");
            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            int max = 0;

            for ( int i = 0; i < N; i ++ ) {
                int tmp = 0;
                int flag = 0;
                for ( int j = 0; j <= i; j++ ) {
                    if ( i == j && D[i][0] == 0 ) {
                        D[i][0] = 1;
                        D[i][1] = i;
                    }
                    if ( i > j && numbers[i] > numbers[j] ) {
                        if ( D[i][0] == 0 ) {
                            D[i][0]++;
                            D[i][1] = i;
                        }
                        if ( tmp < D[i][0] + D[j][0] ) {
                            tmp = D[i][0] + D[j][0];
                            flag = j;
                        }
                    }
                }
                if ( tmp > D[i][0] ) {
                    D[i][0] = tmp;
                    D[i][1] = flag;
                }
                if ( D[max][0] < D[i][0] ) {
                    max = i;
                }
            }

            bw.write("" + D[max][0] );
            bw.newLine();
            int flag = D[max][0];
            int index = max;
            Stack<Integer> stack = new Stack<>();
            stack.push(numbers[index]);
            while (flag > 1 ) {
                stack.push(numbers[D[index][1]]);
                index = D[index][1];
                flag--;
            }

           while ( !stack.empty() ) {
                bw.write(stack.peek() + " ");
                stack.pop();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



}
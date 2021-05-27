import java.io.*;

public class B14391 {

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] input = br.readLine().split(" ");
            int[][] arrary = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

            for ( int i = 0; i < Integer.parseInt(input[0]); i++ ) {
                String[] input2 = br.readLine().split("");
                for ( int j = 0; j < Integer.parseInt(input[1]); j++ ) {
                    arrary[i][j] = Integer.parseInt(input2[j]);
                }
            }

            int max = 0;

            for ( int s = 0; s < (1<<(Integer.parseInt(input[0]) * Integer.parseInt(input[1]))); s++ ) {
                int sum = 0;
                for ( int i = 0; i < Integer.parseInt(input[0]); i++ ) {
                    int cur = 0;
                    for ( int j = 0; j < Integer.parseInt(input[1]); j++ ) {
                        int k = i * Integer.parseInt(input[1]) + j;
                        if ((s&(1<<k)) == 0) {
                            cur = cur * 10 + arrary[i][j];
                        } else {
                            sum += cur;
                            cur = 0;
                        }
                    }
                    sum += cur;
                }
                for ( int j = 0; j < Integer.parseInt(input[1]); j++ ) {
                    int cur = 0;
                    for ( int i = 0; i <Integer.parseInt(input[0]); i++ ) {
                        int k = i * Integer.parseInt(input[1]) + j;
                        if ((s&(1<<k)) != 0) {
                            cur = cur * 10 + arrary[i][j];
                        } else {
                            sum += cur;
                            cur = 0;
                        }
                    }
                    sum += cur;
                }
                if ( max < sum ) max = sum;
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
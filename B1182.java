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
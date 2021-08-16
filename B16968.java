import java.io.*;

public class B16968 {

    public static int count = 0;
    public static char[] result;
    public static final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] words = {'a', 'b','c', 'd', 'e', 'f','g', 'h', 'i', 'j','k', 'l', 'm', 'n','o', 'p', 'q', 'r','s', 't', 'u', 'v','w', 'x' ,'y', 'z'};
    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            char[] c = br.readLine().toCharArray();
            result = new char[c.length];

            if ( c[0] == 'd' ) {
                for ( int i = 0; i < numbers.length; i++ ) {
                    result[0] = numbers[i];
                    back(c, 1, 1);
                }
            }
            if ( c[0] == 'c' ) {
                for ( int i = 0; i < words.length; i++ ) {
                    result[0] = words[i];
                    back(c, 1, 1);
                }
            }
            bw.write("" + count);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void back(char[] c, int index, int length ) {
        if ( c.length == length ) {
            count++;
            return;
        }
        if ( c[index] == 'd' ) {
            for ( int i = 0; i < numbers.length; i++ ) {
                if ( result[index - 1] != numbers[i] ) {
                    result[index] = numbers[i];
                    back(c, index + 1, length + 1);
                }
            }
        }
        if ( c[index] == 'c' ) {
            for ( int i = 0; i < words.length; i++ ) {
                if ( result[index - 1] != words[i] ) {
                    result[index] = words[i];
                    back(c, index + 1, length + 1);
                }
            }
        }
    }
}
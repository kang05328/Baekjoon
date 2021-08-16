import java.io.*;

public class B16917 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] read = br.readLine().split(" ");

            int A = Integer.parseInt(read[0]);
            int B = Integer.parseInt(read[1]);
            int C = Integer.parseInt(read[2]);
            int X = Integer.parseInt(read[3]);
            int Y = Integer.parseInt(read[4]);

            int result = 0;
            if ( A + B > C * 2 ) {
                if ( X > Y ) {
                    result = ( C * 2 ) * Y;
                    if ( A > C * 2) {
                        result = result + (( X - Y ) * ( C * 2 ));
                    } else {
                        result = result + (( X - Y ) * A );
                    }
                } else if ( X < Y ) {
                    result = ( C * 2 ) * X;
                    if ( B > C * 2) {
                        result = result + (( Y - X ) * ( C * 2 ));
                    } else {
                        result = result + (( Y - X ) * B );
                    }
                } else {
                    result = ( C * 2 ) * X;
                }
            } else {
                result = ( A * X ) + ( B * Y );
            }

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
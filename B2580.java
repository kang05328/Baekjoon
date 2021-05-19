import java.io.*;
import java.util.StringTokenizer;

public class B2580 {

    public static int[][] sdoku;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            sdoku = new int[9][9];

            for ( int i = 0; i < 9; i++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                for ( int j = 0; j < 9; j++ ) {
                    sdoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            back(0, 0);

            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void back (int x, int y) {
        if ( y == 9 ) {
            back(x + 1, 0);
            return;
        }

        if ( x == 9 ) {
            if ( checkFlag() ) {
                print();
                System.exit(0);
            }
            return;
        }

        if ( sdoku[x][y] == 0 ) {
            for ( int i = 1; i < 10; i++ ) {
                if ( check(x, y, i) ) {
                    sdoku[x][y] = i;
                    back(x, y + 1);
                }
            }
            sdoku[x][y] = 0;
            return;
        }
        back(x, y + 1);
    }

    public static boolean checkFlag() {
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++) {
                if ( sdoku[i][j] == 0 ) return false;
            }
        }
        return true;
    }

    public static void print() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(sdoku[i][j] + " ");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean check ( int x, int y, int n ) {
        int index1 = ( x / 3 ) * 3 ;
        int index2 = ( y / 3 ) * 3;

        for ( int i = 0; i < 9; i++ ) {
            if ( sdoku[x][i] == n ) return false;
            if ( sdoku[i][y] == n ) return false;
        }
        for ( int i = index1; i < index1 + 3; i++ ) {
            for ( int j = index2; j < index2 + 3; j++ ) {
                if ( sdoku[i][j] == n ) return false;
            }
        }
        return true;
    }
}
import java.io.*;

public class B11723 {

    public static int sum = 0;

    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int M = Integer.parseInt(br.readLine());

            for ( int i = 0; i < M; i++ ) {
                String[] s = br.readLine().split(" ");
                switch (s[0]) {
                    case "add" :
                        add(Integer.parseInt(s[1]));
                        break;
                    case "remove" :
                        remove(Integer.parseInt(s[1]));
                        break;
                    case "check" :
                        bw.write("" + check(Integer.parseInt(s[1])));
                        bw.newLine();
                        break;
                    case "toggle" :
                        toggle(Integer.parseInt(s[1]));
                        break;
                    case "all" :
                        all();
                        break;
                    case "empty" :
                        empty();
                        break;
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void add ( int x ) {
        sum = sum | (1<<x);
    }

    public static void remove ( int x ) {
        sum = sum & ~(1<<x);
    }

    public static int check ( int x ) {
        if ( ( sum & (1<<x) ) != 0 ) return 1;
        return 0;
    }

    public static void toggle ( int x ) {
        if ( check(x) == 1) {
            remove(x);
        } else {
            add(x);
        }
    }
    public static void all () {
        sum = ~sum;
    }
    public static void empty () {
        sum = 0;
    }

}
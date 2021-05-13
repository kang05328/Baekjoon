import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14889 {

    public static int[][] score;
    public static int min = 2147483647;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            score = new int[N][N];

            for ( int i = 0; i < N; i++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                for ( int j = 0; j < N; j++ ) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> link = new ArrayList<>();
            min = check(0, start, link, N);

            bw.write("" + min);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static int check (int index, ArrayList<Integer> start, ArrayList<Integer> link, int n ){
        if (index == n) {
            if ( start.size() != n/2 ) return -1;
            if ( link.size() != n/2 ) return -1;
            int t1 = 0;
            int t2 = 0;
            for ( int i = 0; i < n / 2; i++ ) {
                for ( int j = 0; j < n / 2; j++ ) {
                    if ( i == j ) continue;
                    t1 += score[start.get(i)][start.get(j)];
                    t2 += score[link.get(i)][link.get(j)];
                }
            }
            int diff = Math.abs(t1 - t2);
            return diff;
        }

        int result = -1;
        start.add(index);
        int t1 = check(index + 1, start, link, n);
        if ( result == -1 || (t1 != -1 && result > t1)) {
            result = t1;
        }
        start.remove(start.size()-1);
        link.add(index);
        int t2 = check(index + 1, start, link, n);
        if ( result == -1 || (t2 != -1 && result > t2)) {
            result = t2;
        }
        link.remove(link.size()-1);
        return result;
    }

}
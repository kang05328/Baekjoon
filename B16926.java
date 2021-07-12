import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B16926 {

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int R = Integer.parseInt(s[2]);

            int[][] matrix = new int[N][M];

            for ( int i = 0; i < N; i++ ) {
                String[] tmp = br.readLine().split(" ");
                for ( int j = 0; j < M; j++ ) {
                    matrix[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
            int group = Math.min(M, N) / 2;

            for ( int i = 0; i < group; i++ ) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for ( int j = i; j < M - i; j++ ) {
                    arrayList.add(matrix[i][j]);
                }
                for ( int j = i + 1; j < N - i - 1; j++ ) {
                    arrayList.add(matrix[j][M - i - 1]);
                }
                for ( int j = M - i - 1; j > i; j-- ) {
                    arrayList.add(matrix[N - i - 1][j]);
                }
                for ( int j = N - i - 1; j > i; j-- ) {
                    arrayList.add(matrix[j][i]);
                }
                listArrayList.add(arrayList);
            }

            for ( int i = 0; i < group; i++ ) {
                ArrayList<Integer> arrayList = listArrayList.get(i);
                int len = arrayList.size();
                int index = R % len;
                for ( int j = i; j < M - i; j++, index = (index + 1) % len) {
                    matrix[i][j] = arrayList.get(index);
                }
                for ( int j = i + 1; j < N - i - 1; j++, index = (index + 1) % len) {
                    matrix[j][M - i - 1] = arrayList.get(index);
                }
                for ( int j = M - i - 1; j > i; j--, index = (index + 1) % len) {
                    matrix[N - i - 1][j] = arrayList.get(index);
                }
                for ( int j = N - i - 1; j > i; j--, index = (index + 1) % len) {
                    matrix[j][i] = arrayList.get(index);
                }
            }

            for ( int i = 0; i < matrix.length; i++ ) {
                for ( int j = 0; j < matrix[0].length; j++ ) {
                    bw.write(matrix[i][j] + " ");
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



}
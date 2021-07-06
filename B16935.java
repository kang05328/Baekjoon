import java.io.*;
import java.util.Arrays;

public class B16935 {

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

            String[] o = br.readLine().split(" ");
            for ( int i = 0; i < R; i++ ) {
                int num = Integer.parseInt(o[i]);
                int x = matrix[0].length;
                int y = matrix.length;
                switch (num) {
                    case 1:
                        matrix = operOne(matrix, y, x);
                        break;
                    case 2:
                        matrix = operTwo(matrix, y, x);
                        break;
                    case 3:
                        matrix = operThree(matrix, x, y);
                        break;
                    case 4:
                        matrix = operFour(matrix, x, y);
                        break;
                    case 5:
                        matrix = operFive(matrix, y, x);
                        break;
                    case 6:
                        matrix = operSix(matrix, y, x);
                        break;
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

    public static int[][] operOne(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < M; j++ ) {
                result[i][j] = matrix[N - 1 - i][j];
            }
        }

        return result;
    }

    public static int[][] operTwo(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j <M; j++ ) {
                result[i][j] = matrix[i][M - 1 - j];
            }
        }

        return result;
    }

    public static int[][] operThree(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < M; j++ ) {
                result[i][j] = matrix[M - 1 - j][i];
            }
        }

        return result;
    }

    public static int[][] operFour(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < M; j++ ) {
                result[i][j] = matrix[j][N - 1 - i];
            }
        }

        return result;
    }

    public static int[][] operFive(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i ++ ) {
            for ( int j = 0; j < M; j ++ ) {
                // 1 : 2번으로 옮긴다.
                if ( i >= 0 && i < N / 2 && j >= 0 && j < M / 2 ) {
                     result[i][j + (M / 2)]= matrix[i][j];
                }
                // 2 : 3번으로 옮긴다.
                if ( i >= 0 && i < N / 2 && j >= M / 2 && j < M ) {
                    result[i + (N / 2)][j]= matrix[i][j];
                }
                // 3 : 4번으로 옮긴다.
                if ( i >= N / 2 && i < N && j >= M / 2 && j < M ) {
                    result[i][j - (M / 2)]= matrix[i][j];
                }
                // 4 : 1번으로 옮긴다.
                if ( i >= N / 2 && i < N && j >= 0 && j < M / 2 ) {
                    result[i - (N / 2)][j]= matrix[i][j];
                }
            }
        }

        return result;
    }

    public static int[][] operSix(int[][] matrix, int N, int M) {
        int[][] result = new int[N][M];

        for ( int i = 0; i < N; i ++ ) {
            for ( int j = 0; j < M; j ++ ) {
                // 1 : 4번으로 옮긴다.
                if ( i >= 0 && i < N / 2 && j >= 0 && j < M / 2 ) {
                    result[i + (N / 2)][j]= matrix[i][j];
                }
                // 2 : 1번으로 옮긴다.
                if ( i >= 0 && i < N / 2 && j >= M / 2 && j < M ) {
                    result[i][j - (M / 2)]= matrix[i][j];
                }
                // 3 : 2번으로 옮긴다.
                if ( i >= N / 2 && i < N && j >= M / 2 && j < M ) {
                    result[i - (N / 2)][j]= matrix[i][j];
                }
                // 4 : 3번으로 옮긴다.
                if ( i >= N / 2 && i < N && j >= 0 && j < M / 2 ) {
                    result[i][j + (M / 2)]= matrix[i][j];
                }
            }
        }

        return result;
    }

}
import java.util.Arrays;
import java.util.HashMap;

public class PRotateMatrix {

    public static int[][] matrix;

    public static void main(String[] args) {

        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int[] a = solution(3, 3, queries);
        for ( int n : a ) {
            System.out.println(n);
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {

        matrix = new int[rows][columns];
        int value = 1;
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < columns; j++ ) {
                matrix[i][j] = value;
                value++;
            }
        }

        int[] answer = new int[queries.length];
        for ( int i = 0; i < queries.length; i++ ) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }

    public static int rotate ( int startRow, int startCol, int endRow, int endCol ) {
        int tmp = matrix[startRow - 1][startCol - 1];
        int min = tmp;

        for ( int i = startRow - 1; i < endRow - 1; i++ ) {
            matrix[i][startCol - 1] = matrix[i + 1][startCol - 1];
            min = Math.min(min, matrix[i][startCol - 1]);
        }

        for ( int j = startCol - 1; j < endCol - 1; j++ ) {
            matrix[endRow - 1][j] = matrix[endRow - 1][j + 1];
            min = Math.min(min, matrix[endRow - 1][j]);
        }

        for ( int i = endRow - 1; i > startRow - 1; i-- ) {
            matrix[i][endCol - 1] = matrix[i - 1][endCol - 1];
            min = Math.min(min, matrix[i][endCol - 1]);
        }

        for ( int j = endCol - 1; j > startCol - 1; j-- ) {
            matrix[startRow - 1][j] = matrix[startRow - 1][j - 1];
            min = Math.min(min, matrix[startRow - 1][j]);
        }

        matrix[startRow - 1][startCol] = tmp;

        return min;
    }

}
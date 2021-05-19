import java.io.*;
import java.util.StringTokenizer;

public class B11650 {

    public static int[][] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[][] numbers = new int[N][2];
            tmp = new int[N][2];

            for ( int i = 0; i < N; i++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                numbers[i][0] = Integer.parseInt(st.nextToken());
                numbers[i][1] = Integer.parseInt(st.nextToken());
            }

            mergeSort(numbers, 0, numbers.length - 1);

            for ( int i = 0; i < N; i++ ) {
                bw.write(numbers[i][0] + " " + numbers[i][1]);
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void mergeSort(int[][] numbers, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid+1, right);
            merge(numbers, left, mid, right);
        }
    }

    public static void merge(int[][] numbers, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(numbers[i][0] < numbers[j][0]) {
                tmp[k][0] = numbers[i][0];
                tmp[k][1] = numbers[i][1];
                k++;
                i++;
            } else if (numbers[i][0] == numbers[j][0]) {
                if (numbers[i][1] < numbers[j][1]) {
                    tmp[k][0] = numbers[i][0];
                    tmp[k][1] = numbers[i][1];
                    k++;
                    i++;
                } else {
                    tmp[k][0] = numbers[j][0];
                    tmp[k][1] = numbers[j][1];
                    k++;
                    j++;
                }
            } else {
                tmp[k][0] = numbers[j][0];
                tmp[k][1] = numbers[j][1];
                k++;
                j++;
            }
        }
        while(i<=mid) {
            tmp[k][0] = numbers[i][0];
            tmp[k][1] = numbers[i][1];
            k++;
            i++;
        }
        while(j<=right) {
            tmp[k][0] = numbers[j][0];
            tmp[k][1] = numbers[j][1];
            k++;
            j++;
        }
        for(int index=left; index<k; index++) {
            numbers[index][0] = tmp[index][0];
            numbers[index][1] = tmp[index][1];
        }
    }
}
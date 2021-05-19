import java.io.*;
import java.util.StringTokenizer;

public class B10971 {

    public static int[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] a = new int[N];
            int[][] value = new int[N][N];
            tmp = new int[N];
            for ( int i = 0; i < N; i++ ) {
                a[i] = i;
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                for ( int j = 0; j < N; j++ ) {
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            mergeSort(a, 0, a.length - 1);
            int min = 2147483647;
            do {
                int sum = 0;
                boolean flag = true;
                for ( int i = 1; i < a.length; i++ ) {
                    if (value[a[i - 1]][a[i]] == 0) {
                        flag = false;
                        break;
                    }
                    sum += value[a[i - 1]][a[i]];
                }
                if ( flag && value[a[a.length - 1]][a[0]] != 0 ) {
                    sum += value[a[a.length - 1]][a[0]];
                    if (min > sum) min = sum;
                }
            } while (nextPermutation(a));

            bw.write("" + min);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean prevPermutation(int[] a) {
        int i = a.length - 1;
        while ( i > 0 && a[i - 1] <= a[i] ) i--;
        if ( i <= 0 ) return false;

        int j = a.length - 1;
        while ( a[j] >= a[i - 1] ) j--;

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while ( i < j ) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while ( i > 0 && a[i - 1] >= a[i] ) i--;
        if ( i <= 0 ) return false;

        int j = a.length - 1;
        while ( a[j] <= a[i - 1] ) j--;

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while ( i < j ) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid+1, right);
            merge(numbers, left, mid, right);
        }
    }

    public static void merge(int[] numbers, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(numbers[i] < numbers[j]) {
                tmp[k++] = numbers[i++];
            }else {
                tmp[k++] = numbers[j++];
            }
        }
        while(i<=mid)
            tmp[k++] = numbers[i++];
        while(j<=right)
            tmp[k++] = numbers[j++];
        for(int index=left; index<k; index++)
            numbers[index] = tmp[index];
    }
}
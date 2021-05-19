import java.io.*;
import java.util.StringTokenizer;

public class B10819 {

    public static int[] tmp;
    public static int max = 0;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] a = new int[N];
            tmp = new int[N];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for ( int i = 0; i < N; i++ ) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            mergeSort(a, 0, a.length - 1);

            do {
                int sum = 0;
                for ( int i = 1; i < a.length; i++ ) {
                    sum += Math.abs(a[i-1] - a[i]);
                }
                if ( max < sum ) max = sum;
            } while (nextPermutation(a));

            bw.write("" + max);

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
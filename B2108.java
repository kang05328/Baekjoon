import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static int[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            int[] numbers = new int[N];
            int[] count = new int[8001];
            tmp = new int[N];
            int frequency = -4000;
            int max = -4000;
            int maxCount = -4000;
            int min = 4000;
            int sum = 0;
            ArrayList<Integer> f = new ArrayList<>();

            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(br.readLine());
                count[numbers[i] + 4000]++;
                sum += numbers[i];
                if ( max < numbers[i] ) max = numbers[i];
                if ( min > numbers[i] ) min = numbers[i];
            }

            mergeSort(numbers, 0, numbers.length - 1);
            for ( int i = 0; i < count.length; i++ ) {
                if ( count[i] > maxCount ) maxCount = count[i];
            }
            for ( int i = 0; i < count.length; i++ ) {
                if ( count[i] == maxCount ) f.add(i - 4000);
            }

            int center = numbers[(int) Math.floor((double) N/2)];
            int range = max - min;

            bw.write("" + ( (int) Math.round((double) sum / N) ));
            bw.newLine();
            bw.write("" + center);
            bw.newLine();
            if ( f.size() == 1 ) bw.write("" + f.get(0));
            else {
                f.sort(Comparator.naturalOrder());
                bw.write("" + f.get(1));
            }
            bw.newLine();
            bw.write("" + range);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
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
import java.io.*;

public class B6603 {

    public static StringBuilder sb = new StringBuilder();
    public static int[] result;
    public static boolean[] check;
    public static int[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                String[] s = br.readLine().split(" ");
                if ( s[0].equals("0") ) break;
                int[] lotto = new int[Integer.parseInt(s[0])];
                check = new boolean[Integer.parseInt(s[0])];
                for (int i = 1; i < Integer.parseInt(s[0]) + 1; i++) {
                    lotto[i - 1] = Integer.parseInt(s[i]);
                }
                result = new int[6];

                back(0, 1, lotto.length + 1, lotto);
                sb.append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void back(int index, int start, int n, int[] lotto) {
        if (index == 6) {
            tmp = new int[6];
            for ( int i = 0; i < index; i++ ) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for ( int i = start; i < n; i++) {
            if (check[i - 1]) continue;
            check[i - 1] = true;
            result[index] = lotto[i-1];
            back(index + 1, i, n, lotto);
            check[i - 1] = false;
        }
    }
}

/** 순열방식 풀이
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B6603 {

    public static int[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while ( true ) {
                String s = br.readLine();
                if ( s.equals("0") ) break;
                StringTokenizer st = new StringTokenizer(s);
                int k = Integer.parseInt(st.nextToken());
                int[] check = new int[k];
                int[] S = new int[k];

                for ( int i = 0; i < k; i++ ) {
                    S[i] = Integer.parseInt(st.nextToken());
                }

                for ( int i = 0; i < k; i++ ) {
                    if ( i < k - 6 ) check[i] = 0;
                    else check[i] = 1;
                }

                ArrayList<ArrayList<Integer>> result = new ArrayList<>();
                do {
                    ArrayList<Integer> value = new ArrayList<>();
                    for ( int i = 0; i < k; i++ ) {
                        if (check[i] == 1) {
                            value.add(S[i]);
                        }
                    }
                    result.add(value);
                } while (nextPermutation(check));

                Collections.sort(result, new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                        int n = o1.size();
                        int m = o2.size();
                        int i = 0;
                        while ( i < n && i < m ) {
                            int t1 = o1.get(i);
                            int t2 = o2.get(i);
                            if ( t1 < t2 ) return -1;
                            else if ( t1 > t2 ) return 1;
                            i++;
                        }
                        if ( i == n && i != m ) return -1;
                        else if ( i != n && i == m ) return 1;
                        return 0;
                    }
                });
                for ( int i = 0; i < result.size(); i++ ) {
                    for ( int j = 0; j < 6; j++ ) {
                        bw.write(result.get(i).get(j) + " ");
                    }
                    bw.newLine();
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
 * 
 * 
 * 
 */
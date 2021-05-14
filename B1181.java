import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static String[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            String[] s = new String[N];
            tmp = new String[N];
            for ( int i = 0; i < N; i++ ) {
                s[i] = br.readLine();
            }

            mergeSort(s, 0, s.length - 1);

            bw.write(s[0]);
            bw.newLine();

            for ( int i = 1; i < N; i++ ) {
                if ( s[i].equals(s[i-1]) ) continue;
                bw.write(s[i]);
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void mergeSort(String[] s, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(s, left, mid);
            mergeSort(s, mid+1, right);
            merge(s, left, mid, right);
        }
    }

    public static void merge(String[] s, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(s[i].length() < s[j].length()) {
                tmp[k++] = s[i++];
            } else if (s[i].length() == s[j].length()) {
                char[] a = s[i].toCharArray();
                char[] b = s[j].toCharArray();
                boolean flag = false;
                for ( int c = 0; c < a.length; c++ ) {
                    if (a[c] < b[c]) {
                        flag = true;
                        break;
                    } else if ( a[c] > b[c] ) break;

                }
                if (flag) {
                    tmp[k++] = s[i++];
                } else {
                    tmp[k++] = s[j++];
                }
            } else {
                tmp[k++] = s[j++];
            }
        }
        while(i<=mid) {
            tmp[k++] = s[i++];
        }
        while(j<=right) {
            tmp[k++] = s[j++];
        }
        for(int index=left; index<k; index++) {
            s[index] = tmp[index];
        }
    }
}
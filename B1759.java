import java.io.*;
import java.util.StringTokenizer;

public class 1759 {

    public static char[] alphabet;
    public static char[] tmp;
    public static char[] result;
    public static boolean[] check;
    public static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            alphabet = br.readLine().replace(" ", "").toCharArray();
            tmp = new char[C];
            result = new char[L];
            check = new boolean[C];

            mergeSort(alphabet, 0, alphabet.length - 1);

            check(0, 1, C + 1, L);

            bw.write(sb.toString());

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void check(int index, int start, int c, int l) {
        if ( index == l ) {

            String s = "";
            for ( int i = 0; i < index; i++ ) {
                s += result[i];
            }
            boolean flag = false;
            if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
                s = s.replaceAll("a", "");
                s = s.replaceAll("e", "");
                s = s.replaceAll("i", "");
                s = s.replaceAll("o", "");
                s = s.replaceAll("u", "");
                if ( s.length() >= 2) flag = true;
            }

            if (flag) {
                for (int i = 0; i < index; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for ( int i = start; i < c; i++) {
            if (check[i-1]) continue;
            check[i-1] = true;
            result[index] = alphabet[i-1];
            check(index + 1, i + 1, c, l);
            check[i-1] = false;
        }
    }

    public static void mergeSort(char[] alpha, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(alpha, left, mid);
            mergeSort(alpha, mid+1, right);
            merge(alpha, left, mid, right);
        }
    }

    public static void merge(char[] alpha, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(alpha[i] < alpha[j]) {
                tmp[k++] = alpha[i++];
            }else {
                tmp[k++] = alpha[j++];
            }
        }
        while(i<=mid)
            tmp[k++] = alpha[i++];
        while(j<=right)
            tmp[k++] = alpha[j++];
        for(int index=left; index<k; index++)
            alpha[index] = tmp[index];
    }
}
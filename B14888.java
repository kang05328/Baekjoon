import java.io.*;
import java.util.StringTokenizer;

public class B14888 {

    public static int max = -100_000_000;
    public static int min = 100_000_000;
    public static int[] numbers;
    public static char[] operator;
    public static boolean[] flag;
    public static char[] result;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for ( int i = 0; i < N; i++ ) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            operator = new char[N - 1];
            flag = new boolean[N - 1];
            result = new char[N - 1];
            String s2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s2);
            int plus = Integer.parseInt(st2.nextToken());
            int minus = Integer.parseInt(st2.nextToken());
            int multi = Integer.parseInt(st2.nextToken());
            int div = Integer.parseInt(st2.nextToken());
            int index = 0;
            for ( int i = index; i < index + plus; i++ ) {
                operator[i] = '+';
            }
            index += plus;
            for ( int i = index; i < index + minus; i++ ) {
                operator[i] = '-';
            }
            index += minus;
            for ( int i = index; i < index + multi; i++ ) {
                operator[i] = '*';
                            }
            index += multi;
            for ( int i = index; i < index + div; i++ ) {
                operator[i] = '/';
            }

            calculate(0, N - 1, N - 1);

            bw.write("" + max);
            bw.newLine();
            bw.write("" + min);

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void calculate ( int index, int n, int m) {
        if ( index == m ) {
            int num = numbers[0];
            for ( int i = 1; i < n + 1; i++ ) {
                switch (result[i - 1]) {
                case '+':
                    num = num + numbers[i];
                    break;
                case '-':
                    num = num - numbers[i];
                    break;
                case '*':
                    num = num * numbers[i];
                    break;
                case '/':
                    if (num < 0) {
                        num = num * -1;
                        num = num / numbers[i];
                        num = num * -1;
                    } else num = num / numbers[i];
                    break;
                }
            }
            if ( num > max ) max = num;
            if ( num < min ) min = num;
            return;
        }
        for ( int i = 0; i < n; i++ ) {
            if (flag[i]) continue;
            flag[i] = true;
            result[index] = operator[i];
            calculate(index + 1, n, m);
            flag[i] = false;
        }
    }
}
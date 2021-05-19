import java.io.*;

public class B10845 {

    public static int[] queue;
    public static int index = 0;
    public static int front = 0;
    public static int back = 0;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            queue = new int[N];

            for ( int i = 0; i < N; i++ ) {
                String s = br.readLine();
                if (s.equals("pop")) {
                    bw.write("" + pop());
                    bw.newLine();
                }
                if (s.equals("size")) {
                    bw.write("" + size());
                    bw.newLine();
                }
                if (s.equals("empty")) {
                    bw.write("" + empty());
                    bw.newLine();
                }
                if (s.equals("front")) {
                    bw.write("" + front());
                    bw.newLine();
                }
                if (s.equals("back")) {
                    bw.write("" + back());
                    bw.newLine();
                }
                if (s.contains("push ")) {
                    String[] sa = s.split(" ");
                    int num = Integer.parseInt(sa[1]);
                    push(num);
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void push(int i) {
        queue[index] = i;
        index++;
    }

    public static int pop() {
        int result = -1;

        if (empty() == 1) {
            return -1;
        } else {
            result = queue[front];
            front++;
        }
        return result;
    }

    public static int front() {
        int result = -1;

        if (empty() == 1) {
            return -1;
        } else {
            result = queue[front];
        }
        return result;
    }

    public static int back() {
        int result = -1;

        if (empty() == 1) {
            return -1;
        } else {
            result = queue[index - 1];
        }
        return result;
    }
    public static int size() {
        return index - front;
    }

    public static int empty() {
        if (index == front) return 1;
        else return 0;
    }
}
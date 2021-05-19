import java.io.*;
import java.util.StringTokenizer;

class Member {
    public Member(int age, int index, String name) {
        this.age = age;
        this.index = index;
        this.name = name;
    }

    int age;
    int index;
    String name;
}

public class B10814 {

    public static Member[] tmp;

    public static void main (String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            Member[] members = new Member[N];
            for ( int i = 0; i < N; i++ ) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                members[i] = new Member(Integer.parseInt(st.nextToken()), i, st.nextToken());
            }

            tmp = new Member[N];

            mergeSort(members, 0, members.length - 1);

            for ( int i = 0; i < N; i++ ) {
                bw.write(members[i].age + " " + members[i].name);
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void mergeSort(Member[] members, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(members, left, mid);
            mergeSort(members, mid+1, right);
            merge(members, left, mid, right);
        }
    }

    public static void merge(Member[] members, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(members[i].age < members[j].age) {
                tmp[k] = new Member(members[i].age, members[i].index, members[i].name);
                k++;
                i++;
            } else if (members[i].age == members[j].age) {
                if (members[i].index < members[j].index) {
                    tmp[k] = new Member(members[i].age, members[i].index, members[i].name);
                    k++;
                    i++;
                } else {
                    tmp[k] = new Member(members[j].age, members[j].index, members[j].name);
                    k++;
                    j++;
                }
            } else {
                tmp[k] = new Member(members[j].age, members[j].index, members[j].name);
                k++;
                j++;
            }
        }
        while(i<=mid) {
            tmp[k] = new Member(members[i].age, members[i].index, members[i].name);
            k++;
            i++;
        }
        while(j<=right) {
            tmp[k] = new Member(members[j].age, members[j].index, members[j].name);
            k++;
            j++;
        }
        for(int index=left; index<k; index++) {
            members[index] = new Member(tmp[index].age, tmp[index].index, tmp[index].name);
        }
    }
}
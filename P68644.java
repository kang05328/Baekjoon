import java.util.*;

public class P68644 {
    public static boolean[] check;
    public static int[] tmp;
    public static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        solution(numbers);
    }
    
    public static int[] solution(int[] numbers) {
        check = new boolean[numbers.length];
        sum(numbers, 0, 2, 0);
        
        int[] answer = new int[set.size()];
        
        Iterator iter = set.iterator();	
        int index = 0;
        while(iter.hasNext()) {
            answer[index] = Integer.parseInt(String.valueOf(iter.next()));
            index++;
        }
        
        //정렬
        tmp = new int[answer.length];
        mergeSort(answer, 0, answer.length - 1);
        
        return answer;
    }
    
    public static void sum(int[] numbers, int start, int r, int sum) {
        if ( r == 0 ) {
            set.add(sum);
            return;
        }
        for ( int i = start; i < numbers.length; i++ ) {
            if ( !check[i] ) {
                check[i] = true;
                sum(numbers, i + 1, r-1, sum + numbers[i]);
                check[i] = false;
            }
        }
    }
    
    public static void mergeSort(int[] n, int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(n, left, mid);
            mergeSort(n, mid+1, right);
            merge(n, left, mid, right);
        }
    }

    public static void merge(int[] n, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid && j<=right) {
            if(n[i] < n[j]) {
                tmp[k++] = n[i++];
            }else {
                tmp[k++] = n[j++];
            }
        }
        while(i<=mid)
            tmp[k++] = n[i++];
        while(j<=right)
            tmp[k++] = n[j++];
        for(int index=left; index<k; index++)
            n[index] = tmp[index];
    }
}
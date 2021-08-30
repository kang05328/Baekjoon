public class P12941
{
    public static int[] tmp;

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution(A, B));
    }

    public static int solution(int []A, int []B) {
        tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1);
        tmp = new int[B.length];
        mergeSort(B, 0, B.length - 1);
        
        int answer = 0;
        int index = 0;

        while ( index < A.length ) {
            answer += (A[index] * B[A.length - 1 - index]);
            index++;
        }

        return answer;
    }
    
    public static void mergeSort(int[] number, int left, int right) {
        if ( left < right ) {
            int mid = ( left + right ) / 2;
            mergeSort(number, left, mid);
            mergeSort(number, mid + 1, right);
            merge(number, left, mid, right);
        }
    }
    public static void merge(int[] number, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while ( i <= mid && j <= right ) {
            if ( number[i] < number[j] ) {
                tmp[k++] = number[i++];
            } else {
                tmp[k++] = number[j++];
            }
        }
        while(i <= mid) tmp[k++] = number[i++];
        while(j <= right) tmp[k++] = number[j++];
        for ( int index = left; index < k; index++ ) {
            number[index] = tmp[index];
        }
    }
}
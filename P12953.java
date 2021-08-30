public class P12953 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        int max = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            max = Math.max(max, arr[i]);
        }
        int answer = max;
        int index = 1;

        while(true) {
            boolean flag = true;
            for ( int i = 0; i < arr.length; i++ ) {
                if ( answer % arr[i] != 0 ) {
                    flag = false;
                    break;
                }
            }
            if ( flag ) {
                break;
            }
            index++;
            answer = index * max ;
        }
        return answer;
    }
}


while ( !q.isEmpty() ) {
    String node = q.peek();
    q.poll();

    if ( node.equals("1") && q.peek().equals("0") ) {
        q.poll();
        zeroCount--;
        oneCount--;
    } else if ( node.equals("0") && q.peek().equals("1") ) {
        q.poll();
        zeroCount--;
        oneCount--;
    } else {
        q.offer(node);
    }

    if ( zeroCount == 0 || oneCount == 0 ) break;
}
public class P42626 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(numbers, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for ( int i = 0; i < scoville.length; i++ ) {
            priorityQueue.offer(scoville[i]);
        }

        int answer = 0;
        while ( priorityQueue.peek() < K ) {
            if ( priorityQueue.size() > 1 ) {
                int a = priorityQueue.peek();
                priorityQueue.poll();
                int b = priorityQueue.peek();
                priorityQueue.poll();
                int newScoville = a + (b * 2);
                priorityQueue.offer(newScoville);
                answer++;
            } else break;
        }

        return ( priorityQueue.peek() < K ) ? -1:answer;
    }
}
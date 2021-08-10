class Node {
    public Node(int priority, int number) {
        this.priority = priority;
        this.number = number;
    }
    public int priority;
    public int number;
}
public class P42587 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 9, 1, 9, 1};
        System.out.println(solution(priorities, 1));
    }
    public static int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> result = new LinkedList<>();
        for ( int i = 0; i < priorities.length; i++ ) {
            queue.offer(new Node(priorities[i], i));
        }

        while ( !queue.isEmpty() ) {
            // queue peak
            Node n = queue.peek();
            boolean flag = false;
            // peak 한 Node 와 queue 안에 있는 Node 우선순위 비교
            for ( Node node : queue ) {
                if ( n.priority < node.priority) {
                    flag = true;
                    break;
                }
            }
            // queue 안에 peak 한 Node 보다 높은 우선순위 있으면 offer -> 반복
            if ( flag ) {
                queue.poll();
                queue.offer(n);
            } else {
                queue.poll();
                result.offer(n);
            }
        }

        int answer = 1;
        for ( Node node : result ) {
            if ( node.number == location ) return answer;
            answer++;
        }

        return -1;
    }
}
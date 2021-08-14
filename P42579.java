
import java.util.*;

class Node implements Comparable<Node> {
    int number;
    int count;
    int total;

    public Node(int number, int count, int total) {
        this.number = number;
        this.count = count;
        this.total = total;
    }

    @Override
    public int compareTo(Node target) {
        if ( this.total == target.total ) {
            if ( this.count == target.count ) {
                return this.number >= target.number ? 1 : -1;
            } else {
                return this.count <= target.count ? 1 : -1;
            }
        } else {
            return this.total <= target.total ? 1: -1;
        }
    }
}

public class P42579 {
    public static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] r = solution(genres, plays);
        for (int n : r) {
            System.out.println(n);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        for ( int i = 0; i < genres.length; i++ ) {
            if ( map.containsKey(genres[i]) ) map.put(genres[i], map.get(genres[i]) + plays[i]);
            else map.put(genres[i], plays[i]);
        }

        ArrayList<Node> result = new ArrayList<>();

        for ( String key : map.keySet() ) {
            ArrayList<Node> node = new ArrayList<>();
            for ( int i = 0; i < genres.length; i++ ) {
                if ( genres[i].equals(key) ) {
                    node.add(new Node(i, plays[i], map.get(key)));
                }
            }
            // node 정렬 : count 순
            Collections.sort(node);
            if ( node.size() >= 2 ) {
                result.add(node.get(0));
                result.add(node.get(1));
            } else {
                result.add(node.get(0));
            }
        }
        // result 정렬 : total -> count 순
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for ( int i = 0; i < result.size(); i++ ) {
            answer[i] = result.get(i).number;
        }
        return answer;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge {
    public Edge(String from, String to) {
        this.from = from;
        this.to = to;
    }

    String from;
    String to;
}

public class PTravel {

    public static boolean[] check;
    public static ArrayList<Edge> edgeArrayList = new ArrayList<>();
    public static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] a = solution(tickets);
        for ( String s : a ) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[][] tickets) {

        for ( int i = 0; i < tickets.length; i++ ) {
            edgeArrayList.add(new Edge(tickets[i][0], tickets[i][1]));
        }

        for ( int i = 0; i < edgeArrayList.size(); i++ ) {
            String s = "";
            check = new boolean[edgeArrayList.size()];
            Edge edge = edgeArrayList.get(i);
            if ( edge.from.equals("ICN") ) {
                check[i] = true;
                s = s + edge.from;
                search(edge, edgeArrayList, s, 1);
            }
        }

        String s = strings.get(0);

        for ( int i = 0; i < strings.size(); i++ ) {
            if ( s.compareTo(strings.get(i).toString()) > 0 ) s = strings.get(i);
        }

        String[] answer = s.split(",");

        return answer;
    }

    public static void search(Edge edge, ArrayList<Edge> arrayList, String s, int size) {
        if ( arrayList.size() == size ) {
            strings.add(s + "," + edge.to);
            return;
        }

        for ( int i = 0; i < arrayList.size(); i++ ) {
            Edge k = arrayList.get(i);
            if ( edge.to.equals(k.from) && !check[i] ) {
                check[i] = true;
                search(k, arrayList, s + "," + edge.to, size + 1);
                check[i] = false;
            }
        }
    }

}
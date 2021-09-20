import java.util.*;

public class P86048 {
    public static void main(String[] args) {
        int[] enter = {1, 4, 2, 3};
        int[] leave = {2, 1, 3, 4};
        int[] result = solution(enter, leave);
        for ( int i : result) {
            System.out.println(i);
        }
    }
    public static int[] solution(int[] enter, int[] leave) {
        Map<Integer, Boolean> map = new HashMap<>();
        int[] result = new int[enter.length];
        int outIndex = 0;

        map.put(enter[0], true);

        for ( int i = 1; i < enter.length; i++ ) {
            while ( map.containsKey(leave[outIndex]) ) {
                map.remove(leave[outIndex]);
                outIndex++;
            }
            map.put(enter[i], true);
            if ( map.size() > 1 ) {
                int count = 0;
                for ( int index : map.keySet() ) {
                    if ( map.get(index) ) count++;
                }
                if ( count > 0 ) {
                    for (int index : map.keySet()) {
                        if (map.get(index)) {
                            result[index - 1] = result[index - 1] + map.size() - 1;
                            map.put(index, false);
                        } else {
                            result[index - 1] = result[index - 1] + count;
                        }
                    }
                }
            }
        }

        return result;
    }
}
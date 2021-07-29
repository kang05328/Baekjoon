public class PWordConversion {

    public static int min = 2147483647;
    public static boolean[] check;

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
        System.out.println(min);
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        check = new boolean[words.length];
        boolean flag = false;
        if ( begin.equals(target) ) flag = true;
        for ( String word : words ) {
            if ( target.equals(word) ) flag = true;
        }

        if ( flag ) {
            searchWord(begin, target, words, target.length(), 0);
            answer = min;
        }

        return answer;
    }

    public static void searchWord (String begin, String target, String[] words, int size, int count) {
        if ( begin.equals(target) || min < count ) {
            min = Math.min(min, count);
            return;
        }

        for ( int i = 0; i < words.length; i++ ) {
            if ( check[i] ) continue;
            int n = 0;
            char[] b = begin.toCharArray();
            char[] w = words[i].toCharArray();

            for ( int j = 0; j < size; j++ ) {
                if ( b[j] != w[j] ) n++;
                if ( n >= 2 ) break;
            }

            if ( n == 1 ) {
                check[i] = true;
                searchWord(words[i], target, words, size, count+1);
                check[i] = false;
            }
        }
    }

}
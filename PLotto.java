class PLotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int count = 0;
        int zeroCount = 0;
        
        for ( int i = 0; i < 6; i++ ) {
            if ( lottos[i] == 0 ) zeroCount++;
            for ( int j = 0; j < 6; j++ ) {
                if ( win_nums[i] == lottos[j] ) {
                    count++;
                    break;
                }
            }
        }
        
        int[] answer = {searchGrade(count + zeroCount), searchGrade(count)};
        
        return answer;
    }
     
    public int searchGrade(int match) {
        int grade = 0;
        switch(match) {
            case 6:
                grade = 1;
                break;
            case 5:
                grade = 2;
                break;
            case 4:
                grade = 3;
                break;
            case 3: 
                grade = 4;
                break;
            case 2:
                grade = 5;
                break;
            default:
                grade = 6;
                break;
        }
        
        return grade;
    }
}
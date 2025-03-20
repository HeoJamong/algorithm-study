import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i = 시작
        // j = 마지막
        // k = 선택할 인덱스
        
        int[] answer = new int[commands.length];
        
        int[] debug;
        for (int i = 0; i < commands.length; i++) {
            // 시작 인덱스 + 마지막 인덱스 + 1
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int length = end - start + 1;
            int index = commands[i][2] - 1;
            int[] arr = new int[length];
            
            for (int k = 0; k < length; k++) {
                arr[k] = array[start + k];
            }
            
            Arrays.sort(arr);
            answer[i] = arr[index];
        }
        return answer;
    }
}
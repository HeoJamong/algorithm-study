class Solution {
    static int answer = 0;
    static int result = -1;
    static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {

        dfs(0, "", word);
        return answer;
    }
    
    public static void dfs(int cnt, String str, String word) {
        result++;
        if (str.equals(word)) {
            answer = result;
            return;
        }

        if (str.length() == 5 || answer != 0) {
            return;
        }
        
        for (int i =0; i < aeiou.length; i++) {
            dfs(cnt + 1, str + aeiou[i], word);
        }
    }
}
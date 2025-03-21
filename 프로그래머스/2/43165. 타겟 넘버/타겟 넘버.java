class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    public static void dfs(int n, int[] numbers, int target, int num) {
        if (n == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }
        
        dfs(n + 1, numbers, target, num + numbers[n]);
        dfs(n + 1, numbers, target, num - numbers[n]);
    }
}
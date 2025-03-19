class Solution {
    static boolean[] visit;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(0, k, 0, dungeons);
        return answer;
    }
    
    public static void dfs(int n, int k, int cnt, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                    visit[i] = true;
                    dfs(n + 1, k - dungeons[i][1], cnt + 1, dungeons);
                    visit[i] = false;
                }
            }
        }
}
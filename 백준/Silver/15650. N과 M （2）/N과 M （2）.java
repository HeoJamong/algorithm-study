import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
	static int[] select;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1];
		select = new int[M];
		dfs(0, 1);
		System.out.println(sb);
	}
	
	public static void dfs(int n, int start) {
		if (n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[n] = i;
				dfs(n + 1, start = i + 1);
				visit[i] = false;
			} 
		}
	}
}

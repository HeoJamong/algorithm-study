import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] select;
	static int N;
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		select = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			select[i][0] = Integer.parseInt(st.nextToken());
			select[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < (1 << N); i++) {
			int sour = 1;
			int bitter = 0;
			for (int k = 0; k < N; k++) {
				if ((i & (1 << k)) != 0) {
					sour *= select[k][0];
					bitter += select[k][1];
				}
			}
			result = Math.min(result, Math.abs(sour - bitter));
		}
		System.out.println(result);
	}
}

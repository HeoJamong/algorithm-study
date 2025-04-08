import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] pokemons = new String[N];
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			pokemons[i] = str;
			map.put(str, i);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if ( 0 <= (str.charAt(0) - '0') && (str.charAt(0) - '0') <= 9) {
				sb.append(pokemons[Integer.parseInt(str) - 1] + "\n");
			} else {
				sb.append(map.get(str) + 1).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}

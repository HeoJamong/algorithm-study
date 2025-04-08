import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 1. 4분할
	// 2. 한 영역 전체가 같은 색인지 확인 아니면 1.로 이동
	//    같으면 전체1 : 초록색 ++
	//	       전체0 : 흰색++
	
	static int white;
	static int green;
	static int[][] arr;
	
	public static void cut(int x, int y, int size) {
		int sum = 0;
		
		for (int i =x; i < x + size; i++) {
			for (int k = y; k < y + size; k++) {
				sum+= arr[i][k];
			}
		}
		
		// 초록색이 1로 설정 되어 있으므로 size * size 공간과 sum이 같다는것은
		// 초록색으로 가득 찼다는 뜻
		if (sum == size * size) {
			 green++;
		}
		// 하얀색은 값이 0이므로 sum이 0이면 모든 공간이 하얀색으로 가득차있다는 뜻
		else if (sum == 0) {
			white++;
		}
		else {
			int newSize = size / 2;
			
			// 4분할하여서 탐색 시작
			// 좌상, 우상, 좌하, 우하
			
			// 좌상
			cut(x, y, newSize);
			
			// 우상
			cut(x + newSize, y, newSize);
			
			// 좌하
			cut(x, y + newSize, newSize);
			
			// 우하
			cut(x + newSize, y + newSize, newSize);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}
}

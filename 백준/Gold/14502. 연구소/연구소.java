import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static List<int[]> zeroPoint = new ArrayList<int[]>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				if (map[i][k] == 0) {
					zeroPoint.add(new int[] { i, k });
				}
			}
		}
		comb(0, 0,new int[3]);
		System.out.println(result);
	}

	// 벽을 세울 수 있는 경우의 수를 전부 bfs를 돌린다.
	public static void comb(int depth, int start, int[] pick) {
		if (depth == 3) {
			
			int[][] copy = new int[map.length][];
			
			// 원본 배열을 복사하여 바이러스를 퍼트릴 배열을 만든다. 
			for (int i = 0; i < map.length; i++) {
				copy[i] = Arrays.copyOf(map[i], map[i].length);
			}
			setWall(pick, 1, copy); // 벽 생성
			
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < M; k++) {
					if (map[i][k] == 2) { 
						bfs(i, k, copy);	// 바이러스를 퍼트린다.
					}
				}
			}
			result = Math.max(result, findSafeArea(copy));
			return;
		}
		
		for (int i = start; i < zeroPoint.size(); i++) {
			pick[depth] = i;
			comb(depth + 1, i + 1, pick);
		}
	}
	
	// 벽을 만들어준다.
	public static void setWall(int[] pick, int n, int[][] arr) {
		for (int p : pick) {
			int[] tmp = zeroPoint.get(p);
			arr[tmp[0]][tmp[1]] = n;
		}
	}

	// 남은 안전구역의 크기를 계산한다.
	public static int findSafeArea(int[][] map) {
		int area = 0;

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				if (map[i][k] == 0) {
					area++;
				}
			}
		}

		return area;
	}

	// 바이러스가 이동할 경로가 있으면 모두 2로 채워준다.
	public static void bfs(int startY, int startX, int[][] map) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { startY, startX });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0) {
					map[ny][nx] = 2;
					queue.offer(new int[] { ny, nx });
				}
			}
		}
	}
}

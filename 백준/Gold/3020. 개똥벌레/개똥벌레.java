import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int depth = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
				
		int[] bottom = new int[height+1];
		int[] top = new int[height+2];
		
		for(int i=0; i<depth/2; i++) {
			int b = Integer.parseInt(br.readLine());
			int t = height - Integer.parseInt(br.readLine())+1;
			
			bottom[b]++;
			top[t]++;
		}
		
		for(int i = 1; i <= height; i ++) bottom[i] = bottom[i] + bottom[i-1];
		
		for(int i = height; i >= 1; i--) top[i] = top[i] + top[i+1];	
		
		int min = depth;
		int count = 0;
		
		for(int i = 1; i <= height; i++) {
			int cal = (bottom[height] - bottom[i-1]) + (top[1] - top[i+1]);
			
			if(cal < min) {
				min = cal;
				count = 1;
			}
			else if(cal == min) count++;
		}
		
		System.out.println(min + " " + count);
	}
}
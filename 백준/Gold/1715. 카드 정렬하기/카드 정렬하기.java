import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        
        long totalCost = 0;
        
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            
            long cost = first + second;
            totalCost += cost;
            
            pq.add(cost);
        }

        System.out.println(totalCost);
    }
}

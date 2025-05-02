import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int root = 0;

        for(int i=0;i<=N;i++)
            tree.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<N;i++){
            int node = Integer.parseInt(st.nextToken());

            if(node == -1){
                root = i;
                continue;
            }
            tree.get(node).add(i);
        }

        int remove = Integer.parseInt(br.readLine());

        if(remove == root)
            answer = 0;
        else
            search(remove, root);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void search(int remove, int node){
        if(tree.get(node).contains(remove))
            tree.get(node).remove(Integer.valueOf(remove));
 
        if(tree.get(node).isEmpty()){
            answer++;
            return;
        }

        for(int next : tree.get(node)){
            search(remove, next);
        }
    }
}
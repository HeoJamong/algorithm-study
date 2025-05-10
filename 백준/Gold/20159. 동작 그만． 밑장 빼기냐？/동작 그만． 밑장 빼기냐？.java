import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        int half = n / 2;
        int[] myCards = new int[half + 1];
        int[] yourCards = new int[half + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1, me = 0, you = 1; i <= half; i++, me += 2, you += 2) {
            myCards[i] = cards[me] + myCards[i - 1];
            yourCards[i] = cards[you] + yourCards[i - 1];
        }

        int result = 0;

        for (int i = 1; i <= half; i++) {
            result = Math.max(result, yourCards[half] - yourCards[i - 1] + myCards[i - 1]);
            result = Math.max(result, yourCards[half - 1] - yourCards[i - 1] + myCards[i]);
        }

        System.out.println(result);
    }
}
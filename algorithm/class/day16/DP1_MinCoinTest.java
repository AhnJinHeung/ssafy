import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DP1_MinCoinTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int money = Integer.parseInt(br.readLine());
		int[] D = new int[money+1]; // 각 금액에 대한 최소 동전 개수
		
		// D[i-1], D[i-4], D[i-6]
		
		D[0] = 0; // 0원에 대한 최소동전개수 0
		for (int i=1; i<=money; i++) {
			int min = Integer.MAX_VALUE;
			
			if (D[i-1] + 1 < min) min = D[i-1] + 1;
			if (i>=4 && D[i-4]+1 < min) min = D[i-4] + 1;
			if (i>=6 && D[i-6]+1 < min) min = D[i-6] + 1;
			
			D[i] = min;
		}
		
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}
}

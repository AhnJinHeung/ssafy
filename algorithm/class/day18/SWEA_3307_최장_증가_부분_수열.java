import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_3307_최장_증가_부분_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] DP, num;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			DP = new int[N];
			num = new int[N];
			answer = 0;
			String[] str = br.readLine().split(" ");
			for (int i=0; i<N; i++) {
				num[i] = Integer.parseInt(str[i]);
			}
			
			DP[0] = 1;
			
			for (int i=1; i<N; i++) {
				answer = 0;
				for (int j=0; j<i; j++) {
					if (num[i] > num[j] && answer < DP[j]) answer = DP[j] ;
				}
				DP[i] = answer + 1;
			}
			
			for (int i=0; i<N; i++) {
				if (answer < DP[i]) answer = DP[i];
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1265_달란트 {  // D5

	public static int T=0,N=0,P=0;
	public static long max=0L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		T=Integer.parseInt(br.readLine().trim());
		for (int iT = 1; iT <= T; iT++) {
			st=new StringTokenizer(br.readLine().trim());
			N=Integer.parseInt(st.nextToken().trim());
			P=Integer.parseInt(st.nextToken().trim());
			
			System.out.printf("#%d %d\n",iT,dalant(N,P));
		}
		
	}
	
	public static long dalant(int n, int p) {
		if(p==1) {
			return n;
		}else {
			return 1L* (n /p)* dalant(n-(n /p), p-1);
		}
	}
	
}
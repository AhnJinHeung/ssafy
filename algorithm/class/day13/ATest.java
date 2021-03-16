import java.util.ArrayList;
import java.util.Scanner;

public class ATest {
	/*
	무향그래프 읽기 정점, 간선의 갯수,연결
	7
	8
	0 1
	0 2
	1 3
	1 4
	3 5
	4 5
	5 6
	2 6
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt(); // 간선수
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph = new ArrayList[N];
		
		for (int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int from, to;
		for (int i=0; i<C; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			graph[from].add(to); // 유향 그래프
			graph[to].add(from); // 무향 그래프는 여기까지
		}
		
		for (int i=0; i<graph.length; i++) {
			ArrayList<Integer> temp = graph[i];
			System.out.print("from : "+i+" ");
			for (Integer data : temp) {
				System.out.print(" "+data);
			}
			System.out.println();
		}
	}
}

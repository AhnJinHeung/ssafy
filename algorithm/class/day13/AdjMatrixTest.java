import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	static boolean[][] adjMatrix;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt(); // 정점수
	    int C = sc.nextInt(); // 간선수
	    
	    adjMatrix = new boolean[N][N];
	    visited = new boolean[N];
	    for(int i=0; i<C; ++i) {
	        int from = sc.nextInt();
	        int to = sc.nextInt();
	        adjMatrix[to][from] = adjMatrix[from][to] = true;
		}
	    bfs();
	    dfs(0);
	}
	
	private static void bfs() {
        Queue<Integer>  queue = new LinkedList<Integer>();

        int start = 0;
        queue.offer(start);
        visited[start] = true;
        int current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            //Todo 
            System.out.println((char)(current+65));
//            인접 정점 탐색
            for(int i=0; i<N; ++i) {
                if(adjMatrix[current][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
	
    private static void dfs(int current) {
        visited[current] = true;
        System.out.println((char)(current+65));

        for(int i=0; i<N; ++i) {
            if(adjMatrix[current][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}

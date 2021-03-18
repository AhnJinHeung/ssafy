import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest2 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt(); // 정점수
	    int C = sc.nextInt(); // 간선수
	    
	    for (int i=0; i<N; i++) {
	    	adjList[i] = new ArrayList<>();
	    }
	    
	    adjList = new ArrayList[N];
		visited = new boolean[N];
        for(int i=0; i<C; ++i) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }
        bfs();
        dfs(0);
        sc.close();
	}
	
	private static void bfs() {
        Queue<Integer>  queue = new LinkedList<Integer>();
        boolean visited[] = new boolean[N];

        int current = 0;
        queue.offer(current);
        visited[current] = true;
        
        while(!queue.isEmpty()) {
            current = queue.poll();
            System.out.println((char)(current+65));
            
            for(int vertex : adjList[current]) {
                if(!visited[vertex]) {
                    queue.offer(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
	
    private static void dfs(int current) {
        visited[current] = true;
        System.out.println((char)(current+65));

        for(int vertex : adjList[current]) {
            if(!visited[vertex]) { // 인접한 정점만 있으므로 인접여부 체크 필요없음.
                dfs(vertex);
            }
        }
    }
}

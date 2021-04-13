import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1249_보급로_PQ {

	static int N, INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t =1 ;t <= TC; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			char[] chs = null;
			for(int i = 0; i <N; i++) {
				chs = sc.next().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = chs[j] - '0';
				}
			}
			System.out.println("#" + t + " " + solve(0,0));
		}

	}
	// 다익스트라 구현
	private static int solve(int startY, int startX) {

		boolean[][] v = new boolean[N][N]; //방문체크 배열
		int[][] D = new int[N][N]; // 최단 경로비용 저장 배열(복구 시간)
		
//		최단 경로 최대값으로 초기화 작업
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				D[i][j] = INF;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		D[startY][startX] = 0; // 출발지 0으로 설정
		pq.offer(new int[] {startX, startY,D[startY][startX]});
		
		int x = 0, y = 0, nx, ny, cost = 0;
		int[] cur;
		while(true) {
//			1. 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
			cur = pq.poll();
			x= cur[0];
			y= cur[1];
			cost = cur[2];
			v[y][x] = true; // 방문처리 완료
			if(y == N-1 && x == N-1) { //경유지가 도착지 이면
				return cost;
			}
//			2. 선택된 정점 기준으로 (인접한 정점) 중에 방문하지 않은 나머지 정점들 자신과의 경유시 비용과
//			    기존 최소비용 비교하여 최소값을 변경
			for(int d = 0; d < 4; d++) { //4방위 인접 정점 비교
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) { //범위 체크
					continue;
				}
				if(v[ny][nx]) { //방문체크
					continue;
				}
				if(D[ny][nx] > cost + map[ny][nx]) { // 기존비용보다 경유지 방문후가 최소비용이면 최소비용으로 업데이트
					D[ny][nx] = cost + map[ny][nx];
					pq.offer(new int[] {nx, ny, D[ny][nx]});
				}
			}
			
		}
		
	}

}










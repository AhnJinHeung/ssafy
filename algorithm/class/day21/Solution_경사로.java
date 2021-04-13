import java.util.Scanner;

public class Solution {

	
	static int N, X;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t <= TC ;t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i< N ;i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#" + t + " " + solve());
		}
		

	} //end-main

	private static int solve() {
		int cnt = 0;
		for(int i = 0; i < N; i++) { //행,열 단위 작업
			if(makeRoadByRow(i))
				cnt++;
			if(makeRoadByCol(i))
				cnt++;
		}
		return cnt;
	}
	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[i][0];
		int size = 0; // 연속된 동일 높이 변수
		int j = 0; // 탐색하는 열 위치
		while(j < N) {
			if(beforeHeight == map[i][j]) { //이전 높이랑 현재 높이가 같다
				size++;
				j++;
			}else if(beforeHeight+ 1 == map[i][j]) { //오르막이 형성된 경우
				if(size < X) { // 경사로 설치가 불가능한 경우
					return false;
				}
//				경사로 설치가 가능한 경우 경사로 처리
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight -  1 == map[i][j]) { //내리막 경사로 가능한 경우
				int cnt = 0;
				for(int k = j; k < N; k++) { //동일 높이 구간이 나오는지 가보기
					if(map[i][k] != beforeHeight -1) {// 동일 높이가 다른 경우이면 빠져 나감
						break;
					}
					if(++cnt == X) break;
				}
				if(cnt < X) return false; // 활주로 내리막 경사로 불가
				beforeHeight--;
				j = j + X; //경사로를 겹쳐서 지울 수 없기 때문에 사이즈 만큼 증가해야 다른 경사로 지울 수 있음
				size = 0;
			}else {
				return false;
			}
		}
		return true; // 경사로 가능한 경우
	}
	private static boolean makeRoadByCol(int j) {
		int beforeHeight = map[0][j];
		int size = 0; // 연속된 동일 높이 변수
		int i = 0; // 탐색하는 행 위치
		while(i < N) {
			if(beforeHeight == map[i][j]) { //이전 높이랑 현재 높이가 같다
				size++;
				i++;
			}else if(beforeHeight+ 1 == map[i][j]) { //오르막이 형성된 경우
				if(size < X) { // 경사로 설치가 불가능한 경우
					return false;
				}
//				경사로 설치가 가능한 경우 경사로 처리
				beforeHeight++;
				size = 1;
				i++;
			}else if(beforeHeight -  1 == map[i][j]) { //내리막 경사로 가능한 경우
				int cnt = 0;
				for(int k = i; k < N; k++) { //동일 높이 구간이 나오는지 가보기
					if(map[k][j] != beforeHeight -1) {// 동일 높이가 다른 경우이면 빠져 나감
						break;
					}
					if(++cnt == X) break;
				}
				if(cnt < X) return false; // 활주로 내리막 경사로 불가
				beforeHeight--;
				i = i + X; //경사로를 겹쳐서 지울 수 없기 때문에 사이즈 만큼 증가해야 다른 경사로 지울 수 있음
				size = 0;
			}else {
				return false;
			}
		}
		return true; // 경사로 가능한 경우
		
	}



}












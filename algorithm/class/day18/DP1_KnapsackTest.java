
import java.util.Scanner;

public class DP1_KnapsackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] weights = new int[N+1]; //물건의 개수
        int[] profits = new int[N+1]; //가방의 무게

    int[][] dp = new int[N+1][W+1]; // 해당 물건까지 고려하여 해당무게를 만들 때의 최대 가치

    // i=0은 0으로 그대로 둠.
    for (int i = 1; i <=N; i++) {
        weights[i] = sc.nextInt();
        profits[i] = sc.nextInt();
    }
    for(int i = 1; i <= N ; i++) { //첫 물건부터 고려
        for(int w = 1; w <= W; w++) { //1kg 부터 고려
            if(weights[i] <= w) { //아이템이 들어갈 수 있으면
//                    //넣어보고
//                    dp[i-1][weights[i]]+profits[i-1];
//                    //안 넣어보고
//                    dp[i-1][w];
//                    // 그 둘 중에 최대 만족도 가치 구하기
                    dp[i][w] = Math.max(dp[i-1][w-weights[i]]+profits[i], dp[i-1][w]);
                }else { //아이템이 들어갈수 없으면
                    dp[i][w] = dp[i-1][w]; // 기존 아이템 사용할 수 있을 때 값 사용
                }
            }
        }

        System.out.println(dp[N][W]); //마지막행 마지막열에 최대가치가 저장되어 있음
    }
}
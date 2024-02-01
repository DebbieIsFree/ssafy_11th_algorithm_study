import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_Q2001 {

	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][N+1];
			int[][] dp = new int[N+1][N+1];
 			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
				}
			}
			
			int ans = 0;
			
			for(int i=1; i<=N-M+1; i++) {
				for(int j=1; j<=N-M+1; j++) {
					int x2 = i + M - 1;
					int y2 = j + M - 1;
					int tmp =  dp[x2][y2] - dp[x2][j-1] - dp[i-1][y2] + dp[i-1][j-1];
					if(ans < tmp)
						ans = tmp;
				}
			}
			
			System.out.println("#" + (t+1) + " " + ans);
		}
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {

	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		
		for(int i=1; i<=N; i++) {
			dp[i] = dp[i-1] + arr[i]; 
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(dp[e] - dp[s-1]);
		}
	}
	
}

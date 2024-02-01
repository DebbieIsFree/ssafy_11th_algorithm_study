import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재료를 적절히 섞어서 ~ --> 부분집합
// 재료는 적어도 하나 사용해야 한다. --> 공집합 불가

public class Q2961 {

	static long [][] arr;
	static long res = 1000000000;
	static int N;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N][2];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = b;
		}
		
		subset(0);
		
		System.out.println(res);
	}
	
	static void subset(int idx) {
		if(idx == N) {
			long s = 1;
			long b = 0;
			
			int tmp = 0;
			for(int i=0; i<N; i++) {
				if(!isSelected[i])
					tmp++;
			}
			
			if(tmp == N)
				return;
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					s *= arr[i][0];
					b += arr[i][1];
				}
			}
			if(Math.abs(s-b) < res)
				res = Math.abs(s-b);
			return;
		}
		
		isSelected[idx] = true;
		subset(idx+1);
		
		isSelected[idx] = false;
		subset(idx+1);
	}
}

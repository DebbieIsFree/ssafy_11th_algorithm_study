import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_Q9229 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list);
			
			int left = 0;
			int right = N-1;
			int res = 0;
			
			while(left < right) {
				int sum = list.get(left) + list.get(right);
				if(sum > M) {
					right--;
				}else if(sum < M){
					if(res < sum)
						res = sum;
					left++;
				}else {
					res = M;
					break;
				}
			}
			
			if(res != 0)
				System.out.println("#" + t + " " + res);
			else
				System.out.println("#" + t + " -1");
		}
	}
	
}





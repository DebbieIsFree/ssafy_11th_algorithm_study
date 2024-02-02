import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea_Q1225 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int tn = Integer.parseInt(br.readLine());
		
		
			Deque<Integer> q = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[8];
			
			for(int i=0; i<8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		
			for(int i=7; i>=0; i--) {
				q.offerFirst(arr[i]);
			}
		
			int cnt = 1;
			boolean flag = false;
		
			while(!flag) {
				int num = q.peekFirst() - cnt;
				cnt++;
				if(cnt == 6)
					cnt = 1;
				
				if(num <= 0) {
					num = 0;
					flag = true;
				}
				q.pollFirst();
				q.offerLast(num);
			}
			
			System.out.print("#" + t + " ");
			while(!q.isEmpty()) {
				System.out.print(q.peekFirst() + " ");
				q.pollFirst();
			}
			System.out.println();
		}
	}

}

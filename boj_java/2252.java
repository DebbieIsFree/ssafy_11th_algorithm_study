import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] degree;		// 진입 차수
	static Queue<Integer> q = new ArrayDeque<Integer>();	// 위상 정렬 결과
	static List<List<Integer>> graph = new ArrayList<>();	// 인접 노드 정보 (그래프)
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N+1];	
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 입력
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			degree[b] += 1;
		}
		
		// 풀이
		for(int i=1; i<=N; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.println(cur);
			
			for(int j=0; j<graph.get(cur).size(); j++) {
				int idx = graph.get(cur).get(j);
				if(degree[idx] < 0)
					continue;
				if(degree[idx] > 0)
					degree[idx] -= 1;
				if(degree[idx] == 0) {
					degree[idx] -= 1;
					q.offer(idx);
				}
			}
		}
		
	}
	
}

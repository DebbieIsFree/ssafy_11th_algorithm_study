import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] adjMatrix;
	static int[] visited;
	static Queue<Integer> q = new ArrayDeque<>();
	static int lastMaxNode;
	static int maxBreath;
	
	public static void main(String[] args) throws Exception{
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			
			q.clear();
			lastMaxNode = 0;
			maxBreath = 0;
			adjMatrix = new int[101][101];
			visited = new int[101];
			
			// 인접행렬 입력
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=len/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}
			
			q.offer(startNode);
			visited[startNode] = 0;
			func(startNode);
			
			for(int i=1; i<=100; i++) {
				if(visited[i] == maxBreath && lastMaxNode < i)
					lastMaxNode = i;
			}
			
			System.out.println("#" + t + " " + lastMaxNode);
		} // tc
		
	}// main
	
	
	static void func(int start) {
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=100; i++) {
				if(visited[i] == 0 && adjMatrix[cur][i] == 1) {
					visited[i] = visited[cur] + 1;  // 너비 기록
					q.offer(i);
				}
				if(maxBreath < visited[i])
					maxBreath = visited[i];  
			}
		}
	}
	
}



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_Q1861 {

	static int N;
	static int cnt;
	
	static boolean[][] visited;
	static int map[][];
	static List<Result> list;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			list = new ArrayList<Result>();
			
			// 입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 초기화 
					cnt = 0;
					visited = new boolean[N][N];
					
					cnt++;
					bfs(i, j);
					list.add(new Result(map[i][j], cnt));
				}
			}
			
			Collections.sort(list, (n1, n2)-> 
				n1.cnt == n2.cnt ? n1.number-n2.number : n2.cnt-n1.cnt
			);
			
			System.out.println("#" + t + " " + list.get(0).number + " " + list.get(0).cnt);
		}
	
	}

	
	static void bfs(int row, int col) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(row, col));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = node.row + dr[i];
				int nc = node.col + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				
				if(map[node.row][node.col] +1 != map[nr][nc])
					continue;
				
				q.offer(new Node(nr, nc));
				visited[nr][nc] = true;
				cnt++;
			}
		}
	}
	
	
	static class Result{
		int number;
		int cnt;
		
		public Result() {}
		
		public Result(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
	}
	
	static class Node{
		int row;
		int col;
		
		public Node() {}
		
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_Q1954 {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int number = 1;
	static int dir = 0;

	// 오른쪽, 아래, 왼쪽, 위로
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
	    for (int k = 1; k <= t; k++) {
	        N = Integer.parseInt(br.readLine());
	        
	        arr = new int[N][N];
	        visited = new boolean[N][N];

	        visited[0][0] = true;
	        
	        int cnt = 1;
	        int row = 0, col = 0;
	        int dir = 0;
	        visited[row][col] = true;
	        arr[0][0] = 1;
	        
	        while(cnt < N*N) {
	            int nr = row + dr[dir];
	            int nc = col + dc[dir];
         
	            // 1) 범위를 벗어나거나, 2) 이미 방문한 노드라면 --> 방향 바꿈 
	            if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
	                dir = (dir + 1) % 4;
	                nr = row + dr[dir];
		            nc = col + dc[dir];
	            }
	            row = nr;
	            col = nc;
	            
	            // 그렇지 않다면, 새로 구한/같은 방향으로 이동	
	            arr[nr][nc] = ++cnt;
	            visited[nr][nc] = true;
	        }
	        
	        System.out.println("#" + k + " ");
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
}

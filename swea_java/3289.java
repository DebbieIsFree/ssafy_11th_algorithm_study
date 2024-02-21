import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합 

public class Solution {

	static int T, N, M;
	static int[] parent;	// index : 원소, value : 부모 원소, 최상위 원소 : index == value
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			// 풀이
			parent = new int[N+1];	// 0은 dummy
			makeSet();	// 초기화
			
			sb.append("#").append(t).append(" ");
			// 명령어 
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(op == 0) {	// union
					union(x, y);
				}else if(op == 1) { // find (비교 출력)
					if(findSet(x) == findSet(y))	sb.append("1");
					else 	sb.append("0");
				}
			} // for
			sb.append("\n");
		}	// for - tc
		System.out.println(sb);
	}  // main
	
	static void makeSet() {	// 초기 상태 만들기, 모두가 서로소인 원소 1개를 갖는 집합 배열 구조 (자기 자신이 대표자(루트 노드))
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	// path-compression
	// findSet() 재귀 호출이 반복적으로 호출될 때, 위 구조를 계속 적용
	// 1 -> 2 -> 3 -> 4 -> ... -> 99999
	// parent[1] 하면 바로 99999가 나오도록 하는 게 필요 --> path compression
	static int findSet(int x) { // 어떤 노드 x의 최상위(대표) 노드 반환
		if(parent[x] == x)	// 자기 자신이 곧 루트노드 (대표자)
			return x;
		else
			// return findSet(parent[x]);	// x의 바로 위 부모가 최상위가 아니므로, x의 부모의 부모를 또 찾는다.
			
			// path compression
			return parent[x] = findSet(parent[x]); // 부모노드를 대표자로 갱신하고, 리턴
	}
	
	// 2개의 원소가 각각 속하는 집단을 "하나로 합침" 
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		// 두 집합을 어떻게 하나로 합칠 것인가?
		// #1. 첫번쨰 인자 x가 부모가 되도록
		parent[py] = px;
	}
	
}


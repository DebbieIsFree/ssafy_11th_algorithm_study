import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Deque<Character> st = new ArrayDeque<>();
		
		for(int i=0; i<10; i++) {
			int len = Integer.parseInt(br.readLine());
			char [] input = br.readLine().toCharArray();
			
			for(int j=0; j<input.length; j++) {
				if(input[j] == '(' || input[j] == '[' || input[j] == '{' || input[j] == '<') {
					st.push(input[j]);
				}
				else if(input[j] == ')' && (!st.isEmpty() && st.peek() == '(')) {
					st.pop();
				}
				else if(input[j] == ']' && (!st.isEmpty() && st.peek() == '[')) {
					st.pop();
				}
				else if(input[j] == '}' && (!st.isEmpty() && st.peek() == '{')) {
					st.pop();
				}
				else if(input[j] == '>' && (!st.isEmpty() && st.peek() == '<')) {
					st.pop();
				}
				else {
					break;
				}
			}
			
			
			if(st.isEmpty()) {
				System.out.println("#" + (i+1) + " " + "1");
			}
			else {
				while(!st.isEmpty()) {
					st.pop();
				}
				System.out.println("#" + (i+1) + " " + "0");
			}
		}	
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        for(int i=0; i<T; i++) {
        	
        	String str = br.readLine();
        	int len = str.length();
        	
        	char [] input = str.toCharArray();
        	int [] origin = new int[len];
        	
        	int cnt = 0;
        	
        	for(int j=0; j<len; j++) {
        		if(input[j] == '1' && origin[j] == 0) {
        			for(int k=j; k<len; k++) {
        				origin[k] = 1;
        			}
        			cnt++;
        		}
        		else if(input[j] == '0' && origin[j] == 1){
        			for(int k=j; k<len; k++) {
        				origin[k] = 0;
        			}
        			cnt++;
        		}
        	}
        	
        	System.out.println("#" + (i+1) + " " + cnt);
        }
	}
}

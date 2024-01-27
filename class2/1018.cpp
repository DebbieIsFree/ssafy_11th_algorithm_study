#include <iostream>
using namespace std;

int main(){
    
    int N, M;
    cin >> N >> M;

    // 8*8 체스판
    string str1 = "WBWBWBWB";   // 흰색으로 시작
    string str2 = "BWBWBWBW";   // 검은색으로 시작
    
    char arr[50][50];
    
    // 맵 입력 받기
    for(int i=0; i<N; i++){
        string s;   cin >> s;
        
        for(int j=0; j<M; j++){
            arr[i][j] = s[j];
        }
    }
    
    int wf = 64, bf = 64;  // 최대 개수 : 8*8 체스판의 색을 모두 다시 칠해야 하는 경우
    
    // 비교
    for(int i=0; i<=N-8; i++){
        for(int j=0; j<=M-8; j++){
            
            int twf = 0, tbf = 0;
            
            for(int k=i; k<i+8; k++){
                string comp1;
                string comp2;
                if(k % 2 == 0){
                    comp1 = str1;
                    comp2 = str2;
                }else{
                    comp1 = str2;
                    comp2 = str1;
                }
                
                int idx = 0;    
                for(int h=j; h<j+8; h++){
                    if(comp1[idx] != arr[k][h])
                        twf++;
                    if(comp2[idx] != arr[k][h])
                        tbf++;
                    idx++;
                }
            }
            if(twf < wf)
                wf = twf;
            if(tbf < bf)
                bf = tbf;
        }
    }
  
    wf < bf ? cout << wf : cout << bf;
  
    return 0;
}


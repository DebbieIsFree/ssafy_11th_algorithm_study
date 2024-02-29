#include <iostream>
#include <algorithm>
using namespace std;

// subset

int N, L;   // 재료 개수, 제한 칼로리

// 입력값 저장 (src 역할)
int grades[20];
int calories[20];

// 선택된 것 (tgt 역할)
bool selected[20];  // 선택 : true, 미선택 : false

int ans = 0;

void subset(int srcIdx){
    if(srcIdx == N){
        int g = 0, l = 0;
        for(int i=0; i<N; i++){
            if(selected[i]){
                g += grades[i];
                l += calories[i];
            }
        }
        if(l <= L)
            ans = max(ans, g);
        return;
    }
    
    selected[srcIdx] = true;
    subset(srcIdx + 1);
    
    selected[srcIdx] = false;
    subset(srcIdx + 1);
}

int main(){
    int T;  cin >> T;
    
    for(int t=1; t<=T; t++){
        ans = 0;
        cin >> N >> L;
        
        for(int i=0; i<N; i++){
            cin >> grades[i] >> calories[i];
        }
        
        subset(0);
        
        cout << "#" << t << " " << ans << "\n";
    }

    return 0;
}

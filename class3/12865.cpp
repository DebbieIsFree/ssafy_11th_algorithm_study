#include <iostream>
#include <algorithm>
using namespace std;

int weight[101];
int value[101];
int dp[101][100001];    

int main(){
    
    int N, limit;
    cin >> N >> limit;
    
    for(int i=1; i<=N; i++){
        cin >> weight[i] >> value[i];
    }

    for(int i=1; i<=N; i++){            // 각 물건을 하나씩 돌아가며 최대 가치 계산
        for(int w=0; w<=limit; w++){    // 무게   
           dp[i][w] = dp[i-1][w];      // 현재(i번째)를 미포함 하고 & 무게가 j일 때, 최대 value값;
           
           // i번째를 포함하고 총 무게가 w일 때, 최대 value값
           if(weight[i] <= w){
               dp[i][w] = max(dp[i][w], dp[i-1][w-weight[i]]+value[i]);
           }
        }
    }
    
    cout << dp[N][limit];

    return 0;
}

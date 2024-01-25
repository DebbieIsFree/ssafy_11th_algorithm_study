#include <iostream>
using namespace std;

int arr[1000001];
int dp[1000002];


int main(){

    ios_base::sync_with_stdio(NULL);
    cin.tie(nullptr);

    // 입력값 
    int N;  cin >> N;

    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }


    
    int cnt = 0;

    // nlogn
    for(int i=1; i<=N; i++){
        if(dp[cnt] < arr[i]){
            ++cnt;
            dp[cnt] = arr[i];
        }
        
        else if(dp[cnt] > arr[i]){  
            int left = 1;
            int right = cnt;
            bool flag = false;
            
            while(left <= right){
                int mid = (left + right) / 2;
                
                if(dp[mid] == arr[i]){
                    flag = true;
                    break;
                }
                else if(dp[mid] < arr[i]){
                    left = mid + 1;
                }
                else {   // dp[mid] > arr[i] 
                    right = mid - 1;
                    // dp[mid] = arr[i];
                    // break;
                }
            }
            if(!flag)
                dp[left] = arr[i];
        }
        // cout << endl << "i = " << i << endl;
        // for(int i=1; i<=N; i++){
        //     cout << dp[i] << " ";
        // }
    }
    
    cout << cnt;

    return 0;
}

#include <iostream>
using namespace std;

int N, M;
int arr[9];
int result[8];
bool visited[9];

void backTrack(int cnt){
    if(cnt == M){
        for(int i=0; i<M; i++){
            cout << result[i] << " ";
        }
        cout << "\n";
    }
    
    for(int i=1; i<=N; i++){
        if(visited[i])  
            continue;
        if(cnt > 0 && result[cnt-1] >= i)
            continue;
        visited[i] = true;
        result[cnt] = i;
        backTrack(cnt+1);
        visited[i] = false;
    }
}

int main(){
    cin >> N >> M;
    
    backTrack(0);
    
    return 0;
}

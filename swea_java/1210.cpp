#include <iostream>
using namespace std;

// 도착지가 2인 곳(map[99][??] == 2인 곳)에서 0번째 행이 될 때까지 거꾸로 사다리를 타고 올라간다.

int main(){

    for(int t=1; t<=10; t++){
        int tc; cin >> tc;
    
        int map[100][100];
        
        int row = 99;
        int col = -1;
        
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                cin >> map[i][j];
                if(map[i][j] == 2)
                    col = j;
            }
        }
        
        bool visited[100][100] = {false};
        visited[row][col] = true;
            
        while(row != 0){
            // 좌 or 우 방향으로 길이 있을 때
            if(col-1 >= 0 && map[row][col-1] ==1 && !visited[row][col-1]){
                col--;
            }
            else if(col+1 <= 99 & map[row][col+1] == 1 && !visited[row][col+1]){
                col++;
            }
            // 위쪽 방향으로 길이 있을 때
            else {
                row--;
            }
            visited[row][col] = true;
        }
        cout << "#" << t << " " << col << "\n";
    }

    return 0;
}

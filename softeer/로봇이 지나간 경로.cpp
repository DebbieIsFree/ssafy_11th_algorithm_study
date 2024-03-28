#include <iostream>
#include <algorithm>
using namespace std;

int H, W, K;
char map[26][26];
bool visit[26][26];

// direction 상(북), 오(동), 하(남), 좌(서)
int dr[] = {-1, 0, 1, 0};
int dc[] = {0, 1, 0, -1};
char retDir[] = {'^', '>', 'v', '<'};

int rr = -1, rc = -1, rdir = -1;
string rcmd = "";

void func(int sr, int sc, int sdir, int cdir, int cr, int cc, int cnt, bool visited[26][26], string cmd){
    // '#'의 개수가 k개이면
    if(cnt == K){
        if(rcmd == "" || rcmd.length() > cmd.length()){
            rr = sr;
            rc = sc;
            rdir = sdir;
            rcmd = cmd;
        }
        return;
    }
    
    // 이동 가능 경우 4가지 
    // 현재 cdir, R1, R2, L1 회전 방향 전환 후 + forward
    // R1 --> (cdir + 1) % 4
    // R2 -- > (cdir + 2) % 4
    // L1 --> (cdir + 3) % 4
    
    // forward (i : 0)
    // rotate + forward (i : 1~3)
    for(int i=0; i<=3; i++){
        int ndir = (cdir + i) % 4;
        
        bool flag = false;
        int nr = cr;
        int nc = cc;
        
        
        bool copiedVist[26][26];
        copy(&visited[0][0], &visited[0][0] + 26 * 26, &copiedVist[0][0]);
        
        for(int j=0; j<2; j++){ // 앞의 2칸이 '#'이면 이동
            nr += dr[ndir];
            nc += dc[ndir];
            
            // 범위 체크
            if(nr < 1 || nr > H || nc < 1 || nc > W || copiedVist[nr][nc] || map[nr][nc] != '#'){
                flag = true;
                break;
            }
            copiedVist[nr][nc] = true;
        }
        if(!flag){
            string s = "";
            if(i == 0) s = "A";
            else if(i == 1) s = "RA";
            else if(i == 2) s = "RRA";
            else s = "LA";
            
            func(sr, sc, sdir, ndir, nr, nc, cnt+2, copiedVist, cmd + s);
        }
    }
    
}

int main(){
    cin >> H >> W;
    
    for(int i=1; i<=H; i++){
        for(int j=1; j<=W; j++){
            cin >> map[i][j];
            if(map[i][j] == '#')
                K++;
        }
    }

    for(int i=1; i<=H; i++){
        for(int j=1; j<=W; j++){
            if(map[i][j] != '#')
                continue;
            
            visit[i][j] = true;
            for(int d=0; d<4; d++){
                func(i, j, d, d, i, j, 1, visit, "");
            }
            visit[i][j] = false;
        }
    }
    
    cout << rr << " " << rc << "\n";
    cout << retDir[rdir] << "\n";
    cout << rcmd;

    return 0;
}


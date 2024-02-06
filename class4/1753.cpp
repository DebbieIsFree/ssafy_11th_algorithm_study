#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

int V, E, K;
// node, cost
vector<pair<int, int>> graph[20001];
int dist[20001];    // 최단 거리 테이블

void dijkstra(int start){
    // cost, node   
    priority_queue<pair<int, int>> pq;
    pq.push({0, start});
    dist[start] = 0;
    
    while(!pq.empty()){
        int now = pq.top().second;  // 현재 노드
        int cost = -pq.top().first;  // 현재 노드까지 비용
        pq.pop();
        
        if(dist[now] < cost) continue;
        
        // 현재 노드와 연결된 노드 (== 현재 노드에서 이동할 수 있는 노드)
        for(int i=0; i<graph[now].size(); i++){
            int origin = dist[graph[now][i].first];
            int tmp = cost + graph[now][i].second;
            
            if(tmp < origin){  // 현재 노드(now)를 거쳐서 가는 게 기존 방법보다 거리가 짧다면 갱신
                dist[graph[now][i].first] = tmp;
                pq.push({-tmp, graph[now][i].first});
            }
        }
    }
}


int main(){
    cin >> V >> E;
    cin >> K;
    
    for(int i=0; i<E; i++){
        int u, v, w;
        cin >> u >> v >> w;
        bool flag = false;
        for(int j=0; j<graph[u].size(); j++){
            if(graph[u][j].first == v){
                if(graph[u][j].second > w){
                    graph[u][j].second = w;
                }
                flag = true;    
            }
        }
        if(!flag){
            graph[u].push_back({v, w});
        }
    }
    
    fill_n(dist, 20001, INF);
    
    dijkstra(K);
    
    for(int i=1; i<=V; i++){
        if(dist[i] == INF)
            cout << "INF\n";
        else 
            cout << dist[i] << "\n";
    }
    
    return 0;
}

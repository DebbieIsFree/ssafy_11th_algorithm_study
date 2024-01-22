#include <iostream>
#include <map>
#include <string>
using namespace std;

bool isNumeric(string str){
    for(int i=0; i<str.length(); i++){
        if(!(str[i] >= '0' && str[i] <= '9'))
            return false;
    }
    return true;
}

int main(){
    
    ios_base::sync_with_stdio(NULL);
    cin.tie(nullptr);
    
    int N, M;
    cin >> N >> M;
    
    map<int, string> m1;
    map<string, int> m2;
    
    
    for(int i=1; i<=N; i++){
        string name;    cin >> name;
        m1.insert({i, name});
        m2.insert({name, i});
    }
    
    for(int i=0; i<M; i++){
        string input;    cin >> input;
        
        if(isNumeric(input)){
            int n = stoi(input);
            cout << m1[n] << "\n";
        }
        else{
            cout << m2[input] << "\n";
        }
    }
    
    return 0;
}

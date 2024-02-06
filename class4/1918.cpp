#include <iostream>
#include <stack>

using namespace std;

int change(char c){
    if(c == '+' || c == '-')
        return 1;
    if(c == '*' || c == '/')
        return 2;
    return 0;
}


int main(){
    
    string str; cin >> str;
    
    stack<char> st;
    char cArr[1000];
    int idx = 0;
    
    for(int i=0; i<str.length(); i++){
        // 알파벳일 때
        if(str[i] >= 'A' && str[i] <= 'Z'){
            cArr[idx++] = str[i];
            continue;
        }
        
        // 연산자 일 때
        else if(!st.empty()){
            if(str[i] == '('){
                st.push('(');
            }
            else if(str[i] == ')'){
                while(1){
                    if(st.top() == '('){
                        st.pop();
                        break;
                    }
                    cArr[idx++] = st.top();
                    st.pop();
                }
            }
            else if(change(st.top()) < change(str[i])) st.push(str[i]);
            else{ 
                while(!st.empty() && change(st.top()) >= change(str[i])){
                    cArr[idx++] = st.top();
                    st.pop();
                }
                st.push(str[i]);
            }
        }
        else if(st.empty())
            st.push(str[i]);
    }
    
    while(!st.empty()){
        cArr[idx++] = st.top();
        st.pop();
    }
    
    for(int i=0; i<idx; i++){
        cout << cArr[i];
    }
    
    return 0;
}

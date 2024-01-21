#include <iostream>

using namespace std;

unsigned long a, b, c;

// 분할정복
long long func(unsigned long num){
    if(num == 0)    
        return 1;
    
    if(num == 1)
        return a % c;
    
    // 중복 호출을 한번으로 줄이고, 값을 기억하도록 리팩터링 필요
    if(num % 2 == 0){
        return func(num/2) % c * func(num/2) % c; 
    }
    return func(num/2) % c * func(num/2 +1) % c;
}



int main(){
    
    cin >> a >> b >> c;

    cout << func(b);

    return 0;
}

#include <stdio.h>
#include <stack>

using namespace std;

int N, h;
stack<pair<int, int>> stk;

int main(){
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        scanf("%d", &h);
        while(!stk.empty()){
            if(stk.top().second >= h) break;
            else stk.pop();
        }
        if(stk.empty()) printf("0 ");
        else printf("%d ", stk.top().first);
        stk.push({i+1, h});
    }
}

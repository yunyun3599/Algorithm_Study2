#include <stdio.h>
#include <algorithm>

using namespace std;

int H, W, ans;
int block[500];

int main(){
    scanf("%d %d", &H, &W);
    for(int i=0; i<W; i++)
        scanf("%d", &block[i]);
    
    for(int i=0; i<W; i++){
        int max1 = 0, max2 = 0;
        for(int j=0; j<i; j++){
            if(max1 < block[j]) max1 = block[j];
        }
        for(int j=i+1; j<W; j++){
            if(max2 < block[j]) max2 = block[j];
        }
        int val = min(max1, max2);
        if(val > block[i]) ans += val-block[i];
    }
    
    printf("%d", ans);
}

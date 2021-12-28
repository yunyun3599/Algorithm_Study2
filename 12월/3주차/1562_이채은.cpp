#include<iostream>

using namespace std;

#define MOD 1000000000
 
long long number = 0 ;
int dp[105][10][1 << 10], N, ans;
 
int dfs(int idx, int num, int bit) {
    number++;
    if (dp[idx][num][bit])
        return dp[idx][num][bit];
    if (idx == N)
        return bit == (1 << 10) - 1 ? 1 : 0;
    
    int res = 0;
    if (num + 1 < 10)
        res += dfs(idx + 1, num + 1, bit | 1 << (num + 1));
    if (num - 1 >= 0)
        res += dfs(idx + 1, num - 1, bit | 1 << (num - 1));
    
    return dp[idx][num][bit] = res %= MOD;
}
 
int main() {
    cin >> N;
    for (int i = 1; i < 10; i++) {
        ans += dfs(1, i, 1 << i);
        ans %= MOD;
    }
    cout << ans << '\n';
}

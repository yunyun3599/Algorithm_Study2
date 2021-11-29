#include <iostream>
#include <algorithm>

using namespace std;

int N, T;
int dp[101][10001], study[101], val[101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> T;
    for (int i = 1; i <= N; i++)
        cin >> study[i] >> val[i];

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= T; j++) {
            if (study[i] <= j)
                dp[i][j] = max(val[i] + dp[i - 1][j - study[i]], dp[i - 1][j]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }

    cout << dp[N][T] << '\n';
}

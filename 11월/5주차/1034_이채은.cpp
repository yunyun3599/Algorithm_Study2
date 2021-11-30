#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int N, M, K, ans;
string lamp[50];

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        cin >> lamp[i];
    cin >> K;

    for (int i = 0; i < N; i++) {
        int zero = 0;
        for (int j = 0; j < M; j++) {
            if (lamp[i][j] == '0')
                zero++;
        }

        int cnt = 0;
        if (zero <= K && zero % 2 == K % 2) {
            for (int j = 0; j < N; j++) {
                if (lamp[i] == lamp[j]) cnt++;
            }
        }
        ans = max(cnt, ans);
    }

    cout << ans << '\n';
}

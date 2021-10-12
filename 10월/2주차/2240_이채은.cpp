#include <stdio.h>
#include <algorithm>

using namespace std;

int T, W, num, ans;
int arr[1001][31];

int main() {
    scanf("%d %d", &T, &W);
    scanf("%d", &num);
    arr[0][num - 1] = 1;
    for (int i = 1; i < T; i++) {
        scanf("%d", &num);
        arr[i][0] = arr[i - 1][0];
        if (num == 1) arr[i][0]++;
        for (int j = 1; j <= W; j++) {
            arr[i][j] = max(arr[i - 1][j], arr[i - 1][j - 1]);
            if (j % 2 == num - 1) arr[i][j]++;
        }
    }
    for (int i = 0; i <= W; i++)
        ans = max(ans, arr[T - 1][i]);
    printf("%d", ans);
}

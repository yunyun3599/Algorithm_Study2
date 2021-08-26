#include <stdio.h>
#include <vector>
#include <math.h>

using namespace std;

int N, ans = 2147483647;
int arr[10][2];
bool check[10];

void calc(int cnt, int idx, int mul, int sum) {
    if (log(mul) >= 17) return;
    if (cnt > 0)
        if (abs(mul - sum) < ans)
            ans = abs(mul - sum);

    for (int i = idx; i < N; i++) {
        if (check[i] == false) {
            check[i] = true;
            calc(cnt + 1, i, mul * arr[i][0], sum + arr[i][1]);
            check[i] = false;
        }
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d %d", &arr[i][0], &arr[i][1]);
    calc(0, 0, 1, 0);
    printf("%d", ans);
}

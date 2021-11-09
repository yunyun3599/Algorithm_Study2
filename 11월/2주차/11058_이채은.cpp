#include <stdio.h>
#include <algorithm>

using namespace std;

long long d[101];

int main() {
    int N;
    scanf("%d", &N);
    for (int i = 1; i <= N; i++) {
        d[i] = d[i - 1] + 1;
        for (int j = 3; j <= i; j++)
            d[i] = max(d[i], d[i - j] * (j - 1));
    }
    printf("%lld\n", d[N]);
}

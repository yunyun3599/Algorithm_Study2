#include <stdio.h>
#include <algorithm>
#include <cmath>

using namespace std;

int N, K;
double sum, ans = 5000000;
double arr[501];

void add(int num) {
    sum = 0;
    for (int i = 0; i < num; i++)
        sum += arr[i];
}

void calc(int cnt){
    add(cnt);
    for (int i = 0; i <= N - cnt; i++) {
        double avg = sum / cnt, v = 0;
        for (int j = i; j < i + cnt; j++)
            v += pow(arr[j] - avg, 2);
        v /= cnt;
        ans = min(ans, sqrt(v));
        sum = sum - arr[i] + arr[i + cnt];
    }
}

int main() {
    scanf("%d %d", &N, &K);
    for (int i = 0; i < N; i++)
        scanf("%lf", &arr[i]);
    for (int i = K; i <= N; i++)
        calc(i);
    printf("%.11lf", ans);
}

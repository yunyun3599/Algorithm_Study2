#include <stdio.h>

int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
} //최대공약수

int lcm(int a, int b) {
    int num = gcd(a, b);
    return a * b / num;
} //최소공배수

int main() {
    int T;
    scanf("%d", &T);
    for (int i = 0; i < T; i++) {
        int M, N, x, y;
        scanf("%d %d %d %d", &M, &N, &x, &y);
        int last = lcm(M, N), ans = -1;
        for (int cnt = 0; cnt <= last / M; cnt++) {
            int tmp = x + M * cnt;
            if ((tmp-y) % N == 0) {
                ans = tmp; break;
            }
        }
        printf("%d\n", ans);
    }
}

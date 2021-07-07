#include <stdio.h>
#include <math.h>

int N;
double ans = 0;

int main() {
    scanf("%d", &N);
    double x1, y1, px, py;
    scanf("%lf %lf", &x1, &y1);
    px = x1, py = y1;
    for (int i = 0; i < N - 1; i++) {
        double cx, cy;
        scanf("%lf %lf", &cx, &cy);
        ans += px * cy - cx * py;
        px = cx, py = cy;
    }
    ans += px * y1 - py * x1;
    ans = fabs(ans / 2);
    printf("%.1lf", ans);
}

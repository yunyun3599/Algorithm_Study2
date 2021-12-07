#include <stdio.h>

int N, dir, ans;
int map[499][499];
int dy[] = { 0,1,0,-1 };
int dx[] = { -1,0,1,0 };
int ratio[9] = { 1,1,2,7,7,2,10,10,5 };
int sandY[4][10] = {
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {-1,-1,0,0,0,0,1,1,2,1},
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {1,1,0,0,0,0,-1,-1,-2,-1}
};
int sandX[4][10] = {
    {1,1,0,0,0,0,-1,-1,-2,-1},
    {-1,1,-2,-1,1,2,-1,1,0,0},
    {-1,-1,0,0,0,0,1,1,2,1},
    {-1,1,-2,-1,1,2,-1,1,0,0}
};

void tornado(int y, int x) {
    int val = map[y][x];

    for (int i = 0; i < 10; i++) {
        int sand;
        if (i != 9) {
            sand = val * ratio[i] / 100;
            map[y][x] -= sand;
        }
        else sand = map[y][x];

        int ny = y + sandY[dir][i];
        int nx = x + sandX[dir][i];

        if (ny >= 0 && nx >=0 && ny < N && nx < N) {
            map[ny][nx] += sand;
        }
        else {
            ans += sand;
        }
    }

    map[y][x] = 0;
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            scanf("%d", &map[i][j]);

    bool flag = true;
    int y = N / 2, x = N / 2, cnt = 1;

    while (flag) {
        for (double i = 0; i < 2; i++) {
            for (int j = 0; j < cnt; j++) {
                y += dy[dir];
                x += dx[dir];

                tornado(y, x);
                if (y == 0 && x == 0) {
                    flag = false; break;
                }
            }
            if (!flag) break;
            dir = (dir + 1) % 4;
        }
        cnt++;
    }

    printf("%d", ans);
}

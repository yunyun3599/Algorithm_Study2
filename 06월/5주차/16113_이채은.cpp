#include <stdio.h>

int N;
char signal[5][20000];

bool chkOne(int x) {
    for (int i = 1; i < 5; i++) {
        if (signal[i][x] == '.') {
            return false;
        }
    }
    return true;
}

void number(int x, bool one) {
    if (x == N / 5 - 1) { printf("1"); return; }
    if (one && signal[0][x + 1]=='.') printf("1");
    else if (one) {
        if (signal[2][x + 1] == '.') printf("0");
        else if (signal[1][x + 2] == '.') printf("6");
        else printf("8");
    }
    else {
        if (signal[0][x + 1] == '.') printf("4");
        else if (signal[4][x] == '.') printf("7");
        else {
            if (signal[1][x] == '#' && signal[1][x + 2] == '#') printf("9");
            else if (signal[1][x] == '#') printf("5");
            else if (signal[3][x] == '#') printf("2");
            else printf("3");
        }
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < 5; i++)
        for (int j = 0; j < N / 5; j++)
            scanf(" %c", &signal[i][j]);

    for (int i = 0; i < N / 5; i++) {
        if (signal[0][i] == '.') continue;
        bool one = chkOne(i);
        number(i, one);
        if (one && signal[0][i + 1] == '.') continue;
        i += 2;
    }
}

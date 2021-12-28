#include <iostream>
#include <stack>

using namespace std;

int T, N;
int check[10];
char arr[] = { ' ', '+', '-' };

void findAll(int cnt, int num, int ans) {
    if (cnt == N) {
        ans += num;
        if (ans == 0) {
            for (int i = 1; i < N; i++) {
                cout << i << arr[check[i]];
            }
            cout << N << '\n';
        }
        return;
    }


    int next = cnt + 1;
    check[cnt] = 0;
    if (num < 0) findAll(next, num * 10 - next, ans);
    else findAll(next, num * 10 + next, ans);
    check[cnt] = 1;
    findAll(next, next, ans + num);
    check[cnt] = 2;
    findAll(next, -next, ans + num);
}

int main() {
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> N;
        findAll(1, 1, 0);
        cout << '\n';
    }
}

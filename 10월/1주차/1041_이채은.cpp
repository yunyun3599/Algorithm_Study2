#include <iostream>
#include <algorithm>
#define LLMAX 9223372036854775807

using namespace std;

long long N, ans, min_val = 51;
long long dice[6];
bool check[6];

void select(int cnt, long long sum, int num) {
    if (cnt == num) {
        min_val = min(sum, min_val);
        return;
    }

    for (int i = 0; i < 6; i++) {
        if (!check[i]) {
            check[i] = true; check[5 - i] = true;
            select(cnt + 1, sum + dice[i], num);
            check[i] = false; check[5 - i] = false;
        }
    }
}

void calc() {
    if (N == 1) {
        long long sum = 0, max_val = 0;
        for (int i = 0; i < 6; i++) {
            sum += dice[i];
            max_val = max(max_val, dice[i]);
        }
        ans = sum - max_val;
        return;
    }

    ans += (N - 2) * (N - 2) * min_val * 5 + (N - 2) * min_val * 4;

    min_val = LLMAX;
    select(0, 0, 2);
    ans += (N - 2) * min_val * 8 + min_val * 4;

    min_val = LLMAX;
    select(0, 0, 3);
    ans += min_val * 4;
}

int main() {
    cin >> N;
    for (int i = 0; i < 6; i++) {
        cin >> dice[i];
        min_val = min(dice[i], min_val);
    }
    calc();
    cout << ans << '\n';
}

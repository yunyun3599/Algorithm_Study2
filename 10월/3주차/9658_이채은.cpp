#include <iostream>

using namespace std;

int N;
int dp[1001] = { 0, 1, 2, 1, 2, };

bool game(int num) {
    if (dp[num] != 0) return dp[num] - 1;
    if (!game(num - 1) || !game(num - 3) || !game(num - 4)) {
        dp[num] = 2; return true;
    }
    else {
        dp[num] = 1; return false;
    }
}

int main() {
    cin >> N;
    if (game(N)) cout << "SK" << '\n';
    else cout << "CY" << '\n';
}

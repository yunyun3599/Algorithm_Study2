#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

bool pos, neg;
int N, M, ans, book[50];
vector<int> positive, negative;

int main() {
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        scanf("%d", &book[i]);
    }

    for (int i = 0; i < N; i++) {
        if (book[i] > 0) positive.push_back(book[i]);
        else negative.push_back(book[i]);
    }

    sort(positive.begin(), positive.end());
    sort(negative.begin(), negative.end());

    for (int i = positive.size() - 1; i >= 0; i -= M) {
        ans += positive[i] * 2;
    }

    for (int i = 0; i < negative.size(); i += M) {
        ans += abs(negative[i]) * 2;
    }

    int num;
    if (positive.empty()) num = abs(negative[0]);
    else if (negative.empty()) num = positive[positive.size() - 1];
    else num = max(abs(negative[0]), positive[positive.size() - 1]);

    printf("%d", ans - num);
}

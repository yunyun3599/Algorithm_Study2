#include <stdio.h>
#include <stack>

using namespace std;

int N, P, cnt = 0;
stack<int> guitar[7];

int main() {
    scanf("%d %d", &N, &P);
    for (int i = 0; i < N; i++) {
        int sNo, pNo;
        scanf("%d %d", &sNo, &pNo);

        while (!guitar[sNo].empty() && guitar[sNo].top() > pNo) {
            guitar[sNo].pop();
            cnt++;
        }

        if (guitar[sNo].empty() || guitar[sNo].top() != pNo) {
            guitar[sNo].push(pNo);
            cnt++;
        }
    }

    printf("%d", cnt);
}

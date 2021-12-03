#include <stdio.h>
#include <queue>

using namespace std;

int N, e;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &e);
        pq.push(e);
    }

    for (int i = 0; i < N - 1; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &e);
            pq.push(e);
            pq.pop();
        }
    }

    printf("%d", pq.top());
}

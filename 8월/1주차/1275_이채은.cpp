#include <stdio.h>

int N, Q;
long long arr[100001];
long long tree[1000001];

long long init(int node, int start, int end) {
    if (start == end) return tree[node] = arr[start];

    int mid = (start + end) / 2;
    long long left = init(node * 2, start, mid);
    long long right = init(node * 2 + 1, mid + 1, end);
    tree[node] = left + right;

    return tree[node];
}

long long sum(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return 0;
    if (left <= start && end <= right) return tree[node];

    int mid = (start + end) / 2;
    return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
}

void update(int node, int start, int end, int index, long long diff) {
    if (index < start || index > end) return;
    tree[node] += diff;
    if (start != end) {
        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, diff);
        update(node * 2 + 1, mid + 1, end, index, diff);
    }
}

int main() {
    scanf("%d %d", &N, &Q);
    for (int i = 0; i < N; i++)
        scanf("%lld", &arr[i]);
    init(1, 0, N - 1);

    for (int i = 0; i < Q; i++) {
        int x, y, a, low, high;
        long long b;
        scanf("%d %d %d %lld", &x, &y, &a, &b);
        if (x < y) {
            low = x; high = y;
        }
        else {
            low = y; high = x;
        }
        long long diff = b - arr[a - 1];
        arr[a - 1] = b;
        printf("%lld\n", sum(1, 0, N - 1, low - 1, high - 1));
        update(1, 0, N - 1, a - 1, diff);
    }
}

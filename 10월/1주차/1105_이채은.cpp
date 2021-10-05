#include <iostream>
#include <algorithm>
using namespace std;

int L, R;
int min_num[10], max_num[10];

int count() {
    int i = 0, ans = 0;
    while (L > 0 || R > 0) {
        if (L > 0) {
            min_num[i] = L % 10; L /= 10;
        }
        if (R > 0) {
            max_num[i] = R % 10; R /= 10;
        }
        i++;
    }

    bool flag = false;
    for (int j = 0; j < i; j++) {
        if (min_num[j] == 8 && max_num[j] == 8) {
            ans++; flag = true;
        }
        else if (min_num[j] != max_num[j] && flag) {
            ans = 0; flag = false;
        }
    }
    return ans;
}

int main() {
    cin >> L >> R;
    cout << count() << '\n';
}

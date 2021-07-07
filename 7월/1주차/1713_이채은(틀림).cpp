#include <stdio.h>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main() {
    int N, t;
    scanf("%d %d", &N, &t);
    unordered_map<int, int> photo;
    for (int i = 0; i < t; i++) {
        int s;
        scanf("%d", &s);
        auto tmp = photo.find(s);
        if (tmp != photo.end()) tmp->second++;
        else {
            if (photo.size() == N) {
                auto min = photo.begin();
                for (auto iter = photo.begin(); iter != photo.end(); iter++) {
                    if (iter->second == 1) {
                        min = iter; break;
                    }
                    min = (min->second > iter->second) ? iter : min;
                }
                photo.erase(min);
            }
            photo.insert({ s, 1 });
        }
    }

    vector<int> ans;
    for (auto iter = photo.begin(); iter != photo.end(); iter++) {
        ans.push_back(iter->first);
    }
    sort(ans.begin(), ans.end());
    for (int i = 0; i < ans.size(); i++) {
        printf("%d ", ans[i]);
    }
}

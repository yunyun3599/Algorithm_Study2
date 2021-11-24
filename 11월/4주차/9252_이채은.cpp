#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int LCS[1001][1001];
int sol[1001][1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string s1, s2;
    cin >> s1 >> s2;
    int l1 = s1.size(), l2 = s2.size();
    for (int i = 1; i <= l1; i++) {
        for (int j = 1; j <= l2; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                LCS[i][j] = LCS[i - 1][j - 1] + 1;
                sol[i][j] = 1;
            }
            else {
                if (LCS[i][j - 1] > LCS[i - 1][j]) {
                    LCS[i][j] = LCS[i][j - 1];
                    sol[i][j] = 2;
                }
                else {
                    LCS[i][j] = LCS[i - 1][j];
                    sol[i][j] = 3;
                }
            }
        }
    }
    int ans = LCS[l1][l2];
    cout << ans << "\n";
    if (ans != 0) {
        string res;
        while (sol[l1][l2] != 0) {
            if (sol[l1][l2] == 1) {
                res += s1[--l1];
                l2--;
            }
            else if (sol[l1][l2] == 2) {
                l2--;
            }
            else if(sol[l1][l2]==3) {
                l1--;
            }
        }
        reverse(res.begin(), res.end());
        cout << res << "\n";
    }

}

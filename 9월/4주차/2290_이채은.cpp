#include <iostream>
#include <string>

using namespace std;

int s;
string n;
bool digit[10][7] = { {1, 1, 1, 0, 1, 1, 1},
                     {0, 0, 1, 0, 0, 1, 0},
                     {1, 0, 1, 1, 1, 0, 1},
                     {1, 0, 1, 1, 0, 1, 1},
                     {0, 1, 1, 1, 0, 1, 0},
                     {1, 1, 0, 1, 0, 1, 1},
                     {1, 1, 0, 1, 1, 1, 1},
                     {1, 0, 1, 0, 0, 1, 0},
                     {1, 1, 1, 1, 1, 1, 1},
                     {1, 1, 1, 1, 0, 1, 1} };

    int main() {
    cin >> s >> n;
    int size = n.length();
    for (int i = 0; i < 7; i++) {
        if (i == 2 || i == 5) continue;
        if (i % 3 == 0) {
            for (int j = 0; j < size; j++) {
                int num = n[j] - '0';
                printf(" ");
                for (int k = 0; k < s; k++) {
                    if (digit[num][i]) printf("-");
                    else printf(" ");
                }
                printf("  ");
            }
        }
        else {
            for (int k = 0; k < s; k++) {
                for (int j = 0; j < size; j++) {
                    int num = n[j] - '0';

                    if (digit[num][i]) printf("|");
                    else printf(" ");

                    for (int l = 0; l < s; l++) printf(" ");

                    if (digit[num][i + 1]) printf("|");
                    else printf(" ");

                    printf(" ");
                }
                if (k != s - 1) printf("\n");
            }
        }
        printf("\n");
    }
}

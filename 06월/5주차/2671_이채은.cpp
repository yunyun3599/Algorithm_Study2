#include <iostream>
#include <regex>
#include <string>

using namespace std;

int main() {
    string snd;
    std::cin >> snd;
    std::regex pattern("(100+1+|01)+");
    if (regex_match(snd, pattern)) cout << "SUBMARINE" << endl;
    else cout << "NOISE" << endl;
}

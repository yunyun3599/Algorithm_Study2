#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>


using namespace std;

vector<int> ans;
int N;

bool isPrime(int num) {
	if (num <= 2) return true;
	if (num % 2 == 0) return false;
	for (int i = 3; i < num; i += 2) {
		if (num % i == 0) return false;
	}
	return true;
}

void makeNum(int idx, int num) {
	if (idx == N) {
		ans.push_back(num);
		return;
	}
	int prime[5] = { 1,3,7,9 };
	for (int i = 0; i < 4; i++) {
		int nextNum = num * 10 + prime[i];	
		if (isPrime(nextNum)) {
			makeNum(idx + 1, nextNum);
		}
	}
}

int main() {
	scanf("%d", &N);

	int prime[4] = { 2,3,5,7 };

	for (int i = 0; i < 4; i++) {
		makeNum(1, prime[i]);
	}

	sort(ans.begin(), ans.end());
	for (int i = 0; i < ans.size(); i++) {
		printf("%d\n", ans[i]);
	}
}

/*
2023. 신기한 소수
https://www.acmicpc.net/problem/2023

문제
수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.

7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.

수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.

입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

출력
N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.

2333
2339
2393
2399
2939
3119
3137
3733
3739
3793
3797
5939
7193
7331
7333
7393

맨 앞자리에만 2357이 들어갈 수 있음
그 뒷자리들은 1379로만 가능
*/
#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<stack>


using namespace std;

//각 휴게소 사이의 거리가 x 일 때 가능한가?
int binarySearch(int N, int M, int L, vector<int> dist) {
	int left = 1;	
	int right = L - 1;
	while (left <= right) {
		int mid = (right + left) / 2;
	
		int cnt = 0;
		for (int i = 1; i < dist.size(); i++) {
			int d = dist[i] - dist[i - 1];
			cnt += (d / mid);//i-1, i번째 휴게소 사이에 세울 수 있는 휴게소의 수
			if (d % mid == 0) {
				cnt--;
			}//이미 세워져있기 때문에 휴게소가 겹침
		}
		if (cnt > M) {
			left = mid + 1;
		}
		else right = mid - 1;//x 이상이 되게 할 때 설치 휴게소가 모자랄 경우 -> 더 간격이 넓어져야 함.
	}
	return left;
}


int main() {
	int N, M, L;
	scanf("%d%d%d", &N, &M, &L);

	vector<int> shelters;

	shelters.push_back(0);
	for (int i = 0; i < N; i++) {
		int shelter;
		scanf("%d", &shelter);
		shelters.push_back(shelter);
	}
	shelters.push_back(L);

	sort(shelters.begin(), shelters.end());

	printf("%d\n", binarySearch(N, M, L, shelters));
}

/*
1477. 휴게소 세우기
https://www.acmicpc.net/problem/1477

문제
다솜이는 유료 고속도로를 가지고 있다. 다솜이는 현재 고속도로에 휴게소를 N개 가지고 있는데, 휴게소의 위치는 고속도로의 시작으로부터 얼만큼 떨어져 있는지로 주어진다. 다솜이는 지금 휴게소를 M개 더 세우려고 한다.

다솜이는 이미 휴게소가 있는 곳에 휴게소를 또 세울 수 없고, 고속도로의 끝에도 휴게소를 세울 수 없다. 휴게소는 정수 위치에만 세울 수 있다.

다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문한다. 다솜이는 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다. (반드시 M개를 모두 지어야 한다.)

예를 들어, 고속도로의 길이가 1000이고, 현재 휴게소가 {200, 701, 800}에 있고, 휴게소를 1개 더 세우려고 한다고 해보자.

일단, 지금 이 고속도로를 타고 달릴 때, 휴게소가 없는 구간의 최댓값은 200~701구간인 501이다. 하지만, 새로운 휴게소를 451구간에 짓게 되면, 최대가 251이 되어서 최소가 된다.

입력
첫째 줄에 현재 휴게소의 개수 N, 더 지으려고 하는 휴게소의 개수 M, 고속도로의 길이 L이 주어진다. 둘째 줄에 현재 휴게소의 위치가 공백을 사이에 두고 주어진다.

출력
첫째 줄에 M개의 휴게소를 짓고 난 후에 휴게소가 없는 구간의 최댓값의 최솟값을 출력한다.
*/
﻿#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<map>


using namespace std;


int main() {
	int n, h;
	scanf("%d%d", &n, &h);
	int arr1[100001];
	int arr2[100001];


	for (int i = 0; i < n/2; i++) {
		scanf("%d%d", &arr1[i], &arr2[i]);

	}

	sort(arr1, arr1 + n / 2);
	sort(arr2, arr2 + n / 2);

	int answer = 200001;
	int cnt = 0;
	for (int i = 1; i <= h; i++) {
		int obstacle = lower_bound(arr1, arr1 + n / 2, i) - arr1;//0~i 의 범위에서 i가 처음 등장한 인덱스 or 없으면 upperbound랑 같은 인덱스
		obstacle += upper_bound(arr2, arr2 + n / 2, h - i) - arr2;//h-i보다 큰 것 중 가장 작은 값의 인덱스

		obstacle = n - obstacle;

		if (answer == obstacle)
			cnt++;
		else if (answer > obstacle) {
			answer = obstacle;
			cnt = 1;
		}
	}

	printf("%d %d\n", answer, cnt);
}

/*
3020. 개똥벌레 
https://www.acmicpc.net/problem/3020

문제
개똥벌레 한 마리가 장애물(석순과 종유석)로 가득찬 동굴에 들어갔다. 동굴의 길이는 N미터이고, 높이는 H미터이다. (N은 짝수) 첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장한다.

아래 그림은 길이가 14미터이고 높이가 5미터인 동굴이다. (예제 그림)



이 개똥벌레는 장애물을 피하지 않는다. 자신이 지나갈 구간을 정한 다음 일직선으로 지나가면서 만나는 모든 장애물을 파괴한다.

위의 그림에서 4번째 구간으로 개똥벌레가 날아간다면 파괴해야하는 장애물의 수는 총 여덟개이다. (4번째 구간은 길이가 3인 석순과 길이가 4인 석순의 중간지점을 말한다)



하지만, 첫 번째 구간이나 다섯 번째 구간으로 날아간다면 개똥벌레는 장애물 일곱개만 파괴하면 된다.

동굴의 크기와 높이, 모든 장애물의 크기가 주어진다. 이때, 개똥벌레가 파괴해야하는 장애물의 최솟값과 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 H가 주어진다. N은 항상 짝수이다. (2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000)

다음 N개 줄에는 장애물의 크기가 순서대로 주어진다. 장애물의 크기는 H보다 작은 양수이다.

출력
첫째 줄에 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그러한 구간의 수를 공백으로 구분하여 출력한다.
*/
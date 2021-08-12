#include<stdio.h>
#include<vector>
#include<queue>
#include<iostream>
#include<math.h>
#include<limits.h>
#include<cfloat>


using namespace std;

double x, y, c;

double get_height(double n) {
	double h1 = sqrt(x * x - n * n);
	double h2 = sqrt(y * y - n * n);
	return (h1 * h2) / (h1 + h2);
}

int main() {
	scanf("%lf%lf%lf", &x, &y, &c);
	double ans = 0;
	double low = 0;
	double high = DBL_MAX;
	while (high - low > 0.0001) {
		double mid = (high + low) / 2;
		if (get_height(mid) >= c) {
			ans = mid;
			low = mid;
		}
		else high = mid;
	}//c에 가장 근접한 n을 찾는 이분탐색
	printf("%.3lf\n", ans);
}


/*
2022. 사다리
https://www.acmicpc.net/problem/2022

문제
아래의 그림과 같이 높은 빌딩 사이를 따라 좁은 길이 나있다. 두 개의 사다리가 있는데 길이가 x인 사다리는 오른쪽 빌딩의 아래를 받침대로 하여 왼쪽 빌딩에 기대져 있고 길이가 y인 사다리는 왼쪽 빌딩의 아래를 받침대로 하여 오른쪽 빌딩에 기대져 있다. 그리고 두 사다리는 땅에서부터 정확하게 c인 지점에서 서로 교차한다. 그렇다면 두 빌딩은 얼마나 떨어져 있는 걸까?



입력
첫째 줄에 차례대로 x, y, c에 해당하는 양의 실수 세 개가 입력된다. 수는 소수점 여섯째 자리까지 주어질 수 있다.

출력
두 빌딩사이에 너비가 되는 수치를 출력한다. 절대/상대 오차는 10-3까지 허용한다.

*/
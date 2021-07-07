#include<stdio.h>
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<queue>
#include<math.h>

using namespace std;

pair<double, double> XY[10001];
double ans = 0;

double ccw(double x1, double x2, double x3, double y1, double y2, double y3) {
	double result = x1 * y2 + x2 * y3 + x3 * y1;
	result += (-y1 * x2 - y2 * x3 - y3 * x1);
	return result / 2;
}//벡터의 외적


int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%lf%lf", &XY[i].first, &XY[i].second);
	}


	for (int i = 1; i < n; i++) {
		ans += ccw(XY[0].first, XY[i - 1].first, XY[i].first, XY[0].second, XY[i - 1].second, XY[i].second);
	}

	printf("%.1lf\n", abs(ans));
}



/*
2166. 다각형의 면적
https://www.acmicpc.net/problem/2166

문제
2차원 평면상에 N(3 ≤ N ≤ 10,000)개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 다음 N개의 줄에는 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다. 좌표값은 절댓값이 100,000을 넘지 않는 정수이다.

출력
첫째 줄에 면적을 출력한다. 면적을 출력할 때에는 소수점 아래 둘째 자리에서 반올림하여 첫째 자리까지 출력한다.
*/

#include <iostream>

typedef struct Point2D
{
	int x;
	int y;

	Point2D() {}
	Point2D(int _x, int _y) :x(_x), y(_y) {}
} POINT;

POINT home[101];
POINT chicken[14];
int arr[500];

int count_home, count_chicken;
int answer = 200000000;

int distance(POINT a, POINT b)
{
	return abs(b.x - a.x) + abs(b.y - a.y);
}

int shortest_distance(int arr[], int len)
{
	int min = 200000000;
	int value;
	int sum = 0;
	for (int i = 0; i < count_home; i++)
	{
		min = 200000000;
		for (int j = 0; j< len; j++)
		{
			value = distance(home[i], chicken[arr[j]]);
			if (value < min)min = value;
		}
		sum += min;
	}
	return sum;
}


void f(int arr[], int N, int r, int count, int k)
{
	if (count == r)
	{
		int value = shortest_distance(arr, count);
		if (value < answer)answer = value;
		return;
	}

	if (N <= k)return;

	arr[count] = k;
	f(arr, N, r, count + 1, k + 1);
	f(arr, N, r, count, k + 1);
} // 치킨집 골라주는 함수

int main()
{
	int N, M, a;
	std::cin >> N >> M;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			std::cin >> a;
			if (a == 1)home[count_home++] = Point2D(i, j);
			else if (a == 2)chicken[count_chicken++] = Point2D(i, j);
		}
	}
	f(arr, count_chicken, M, 0, 0);
	std::cout << answer;
	return 0;
}
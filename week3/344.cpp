// 백준 18405번 문제
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <functional>

int arr[205][205]; // 받아주는 배열
int count;

class Point
{
public:
	int x; // y좌표
	int y; // x좌표
	int z; // 바이러스 번호
	int w; // 증식 횟수
	Point(int _x, int _y, int _z, int _w) :x(_x), y(_y), z(_z), w(_w) {}
};

// Point 클래스의 크기를 판별하기 위한 operator 함수 오버로딩
bool operator>(const Point& a, const Point& b)
{
	return a.z > b.z;
}

bool operator<(const Point& a, const Point& b)
{
	return a.z < b.z;
}

bool operator==(const Point& a, const Point& b)
{
	return a.z == b.z;
}

int main()
{
	int N, M, S, X, Y, v;
	std::cin >> N >> M; // N, K를 받아준다.
	std::priority_queue<Point, std::vector<Point>, std::greater<Point>> aq; // 바이러스 번호로 오름차순을 하기 위한 우선순위 큐
	for (int i = 0; i < N; i++) 
	{
		for (int j = 0; j < N; j++)
		{
			std::cin >> v;
			if (v != 0)aq.push(Point(i, j, v, 1));
			arr[i][j] = v;
		}
	} // 배열을 먼저 받아준다.
	std::cin >> S >> X >> Y; // 초, 좌표를 받아준다.
	std::queue<Point> q;
	while (!aq.empty()) // 우선순위 큐 내용을 큐로 옮겨준다
	{
		q.push(aq.top());
		aq.pop();
	}

	while (!q.empty()) // 큐가 빌때까지  = bfs를 수행한다.
	{
		Point p = q.front();
		q.pop();

		if (p.x - 1 >= 0 && arr[p.x - 1][p.y] == 0) // x - 1로 가는 코드
		{
			arr[p.x - 1][p.y] = p.z;
			q.push(Point(p.x - 1, p.y, p.z, p.w + 1));
		}
		if (p.x + 1 < N && arr[p.x + 1][p.y] == 0) // x + 1로 가는 코드
		{
			arr[p.x + 1][p.y] = p.z;
			q.push(Point(p.x + 1, p.y, p.z, p.w + 1));
		}
		if (p.y - 1 >= 0 && arr[p.x][p.y - 1] == 0) // y - 1로 가는 코드
		{
			arr[p.x][p.y - 1] = p.z;
			q.push(Point(p.x, p.y - 1, p.z, p.w + 1));
		}
		if (p.y + 1 < N && arr[p.x][p.y + 1] == 0) // y + 1로 가는 코드
		{
			arr[p.x][p.y + 1] = p.z;
			q.push(Point(p.x, p.y + 1, p.z, p.w + 1));
		}
		count = p.w;
		if (count >= S)break; // 횟수가 S보다 크면 의미가 없기 때문에 큐에 남아있어도 반복을 수행하지 않는다.
	}
	std::cout << arr[X - 1][Y - 1]; // 답 출력
	return 0;
}
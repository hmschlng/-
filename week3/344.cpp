// ���� 18405�� ����
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <functional>

int arr[205][205]; // �޾��ִ� �迭
int count;

class Point
{
public:
	int x; // y��ǥ
	int y; // x��ǥ
	int z; // ���̷��� ��ȣ
	int w; // ���� Ƚ��
	Point(int _x, int _y, int _z, int _w) :x(_x), y(_y), z(_z), w(_w) {}
};

// Point Ŭ������ ũ�⸦ �Ǻ��ϱ� ���� operator �Լ� �����ε�
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
	std::cin >> N >> M; // N, K�� �޾��ش�.
	std::priority_queue<Point, std::vector<Point>, std::greater<Point>> aq; // ���̷��� ��ȣ�� ���������� �ϱ� ���� �켱���� ť
	for (int i = 0; i < N; i++) 
	{
		for (int j = 0; j < N; j++)
		{
			std::cin >> v;
			if (v != 0)aq.push(Point(i, j, v, 1));
			arr[i][j] = v;
		}
	} // �迭�� ���� �޾��ش�.
	std::cin >> S >> X >> Y; // ��, ��ǥ�� �޾��ش�.
	std::queue<Point> q;
	while (!aq.empty()) // �켱���� ť ������ ť�� �Ű��ش�
	{
		q.push(aq.top());
		aq.pop();
	}

	while (!q.empty()) // ť�� ��������  = bfs�� �����Ѵ�.
	{
		Point p = q.front();
		q.pop();

		if (p.x - 1 >= 0 && arr[p.x - 1][p.y] == 0) // x - 1�� ���� �ڵ�
		{
			arr[p.x - 1][p.y] = p.z;
			q.push(Point(p.x - 1, p.y, p.z, p.w + 1));
		}
		if (p.x + 1 < N && arr[p.x + 1][p.y] == 0) // x + 1�� ���� �ڵ�
		{
			arr[p.x + 1][p.y] = p.z;
			q.push(Point(p.x + 1, p.y, p.z, p.w + 1));
		}
		if (p.y - 1 >= 0 && arr[p.x][p.y - 1] == 0) // y - 1�� ���� �ڵ�
		{
			arr[p.x][p.y - 1] = p.z;
			q.push(Point(p.x, p.y - 1, p.z, p.w + 1));
		}
		if (p.y + 1 < N && arr[p.x][p.y + 1] == 0) // y + 1�� ���� �ڵ�
		{
			arr[p.x][p.y + 1] = p.z;
			q.push(Point(p.x, p.y + 1, p.z, p.w + 1));
		}
		count = p.w;
		if (count >= S)break; // Ƚ���� S���� ũ�� �ǹ̰� ���� ������ ť�� �����־ �ݺ��� �������� �ʴ´�.
	}
	std::cout << arr[X - 1][Y - 1]; // �� ���
	return 0;
}
#include <iostream>
#include <queue>

int arr[201][201];
int map[201][201];
int count;

int bfs(int i, int j, int N, int M);

int main()
{
	int N, M;
	char c;
	std::cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			std::cin >> c;
			arr[i][j] = c - 48;
		}
	}
	std::cout << bfs(0, 0, N, M);
	return 0;
}

int bfs(int i, int j, int N, int M)
{
	int x, y;
	std::queue<std::pair<int, int>> q;
	q.push(std::pair<int, int>(i, j));
	while (!q.empty())
	{
		x = q.front().first;
		y = q.front().second;
		q.pop();
		if ((x - 1) >= 0 && arr[x-1][y] == 1 && map[x-1][y] == 0) // ������ ����� �ʰ�, ����̸�, �� ���� �������� ����
		{
			q.push(std::pair<int, int>(x - 1, y)); // ť�� �߰����ش�
			arr[x - 1][y] = arr[x][y] + 1; // ��� + 1
			map[x - 1][y] = 1; // ���������� ǥ���Ѵ�.
		}
		if ((x + 1) < N && arr[x + 1][y] == 1 && map[x + 1][y] == 0)
		{
			q.push(std::pair<int, int>(x + 1, y));
			arr[x + 1][y] = arr[x][y] + 1;
			map[x + 1][y] = 1;
		}
		if ((y - 1) >= 0 && arr[x][y-1] == 1 && map[x][y-1] == 0)
		{
			q.push(std::pair<int, int>(x, y-1));
			arr[x][y-1] = arr[x][y] + 1;
			map[x][y-1] = 1;
		}
		if ((y + 1) >= 0 && arr[x][y+1] == 1 && map[x][y+1] == 0)
		{
			q.push(std::pair<int, int>(x, y+1));
			arr[x][y+1] = arr[x][y] + 1;
			map[x][y+1] = 1;
		}
	}
	return arr[N - 1][M - 1]; // �������� ��� �ջ��� �Ѵ�.
}


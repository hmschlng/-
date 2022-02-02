#include <iostream>
#include <queue>

int arr[10][10];
int map[10][10];
int temp[100];
int size;

//void h(int i, int j, int N, int M) // stack overflow
//{
//	if (i < 0 || i >= N || j < 0 || j >= M)return;
//	if (map[i][j] == 1)return;
//	if (map[i][j] == 0)map[i][j] = 2;
//	h(i - 1, j, N, M);
//	h(i + 1, j, N, M);
//	h(i, j - 1, N, M);
//	h(i, j + 1, N, M);
//	return;
//}

void bfs(int i, int j, int N, int M)
{
	std::queue<std::pair<int, int>> q;
	q.push(std::pair<int, int>(i, j));

	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (x - 1 >= 0 && map[x - 1][y] == 0)
		{
			map[x - 1][y] = 2;
			q.push(std::pair<int, int>(x - 1, y));
		}
		if (x + 1 < N && map[x + 1][y] == 0)
		{
			map[x + 1][y] = 2;
			q.push(std::pair<int, int>(x + 1, y));
		}
		if (y - 1 >= 0 && map[x][y - 1] == 0)
		{
			map[x][y - 1] = 2;
			q.push(std::pair<int, int>(x, y - 1));
		}
		if (y + 1 < M && map[x][y + 1] == 0)
		{
			map[x][y + 1] = 2;
			q.push(std::pair<int, int>(x, y + 1));
		}
	}
}

void g(int temp[], int N, int M)
{
	int value = 0;
	std::queue<std::pair<int, int>> q;
	for (int i = 0; i < 3; i++)
	{
		int x = temp[i];
		arr[x / M][x % M] = 1; // 일반 공간을 벽으로 변환
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)map[i][j] = arr[i][j];
	}

	for (int i = 0; i < 3; i++)
	{
		int x = temp[i];
		arr[x / M][x % M] = 0; // 일반 공간을 벽으로 변환
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 2)
			{
				bfs(i, j, N, M);
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 0)value++;
		}
	}
	if (value > size)size = value;
}

void f(int temp[], int idx, int n, int k, int N, int M)
{
	if (idx == 3)
	{
		for (int i = 0; i < idx; i++)
		{
			int x = temp[i];
			if (arr[x / M][x % M] != 0)return; // 벽 또는 바이러스면 설치할 수 없다.
		}
		g(temp, N, M);
		return;
	}

	if (n <= k)return;

	temp[idx] = k;
	f(temp, idx+1, n, k + 1, N, M);
	f(temp, idx, n, k + 1, N, M);
}

int main()
{
	int n, m;
	std::cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			std::cin >> arr[i][j];
			map[i][j] = arr[i][j];
		}
	}

	f(temp, 0, n*m, 0, n, m);
	std::cout << size;
	return 0;
}
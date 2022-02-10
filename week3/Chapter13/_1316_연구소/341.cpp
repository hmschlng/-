// 백준 14502번 문제
// 연구소
#include <iostream>
#include <queue>

int arr[10][10]; // 배열 설정
int map[10][10]; // 지나갔는지 확인하는 배열
int temp[100]; // f 함수에서 사용하는 배열
int size;

//void h(int i, int j, int N, int M) // stack overflow로 인한 error
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

void bfs(int i, int j, int N, int M) // 바이러스가 있는 곳에서 0으로 확산시키는 함수
{
	std::queue<std::pair<int, int>> q;
	q.push(std::pair<int, int>(i, j));

	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (x - 1 >= 0 && map[x - 1][y] == 0) // 왼쪽으로 확산
		{
			map[x - 1][y] = 2;
			q.push(std::pair<int, int>(x - 1, y));
		}
		if (x + 1 < N && map[x + 1][y] == 0) // 오른쪽으로 확산
		{
			map[x + 1][y] = 2;
			q.push(std::pair<int, int>(x + 1, y));
		}
		if (y - 1 >= 0 && map[x][y - 1] == 0) // 위로 확산
		{
			map[x][y - 1] = 2;
			q.push(std::pair<int, int>(x, y - 1));
		} 
		if (y + 1 < M && map[x][y + 1] == 0) // 아래로 확산
		{
			map[x][y + 1] = 2;
			q.push(std::pair<int, int>(x, y + 1));
		}
	}
}

void g(int temp[], int N, int M) // 3개의 좌표를 받아서 벽을 세우거나 벽을 제거하는 함수
{
	int value = 0;
	std::queue<std::pair<int, int>> q;
	for (int i = 0; i < 3; i++) // 3개의 벽을 세움
	{
		int x = temp[i];
		arr[x / M][x % M] = 1; // 일반 공간을 벽으로 변환
	}

	for (int i = 0; i < N; i++) // map으로 전송하고
	{
		for (int j = 0; j < M; j++)map[i][j] = arr[i][j];
	}

	for (int i = 0; i < 3; i++) // arr[i][j]는 다시 원본으로 돌아간다.
	{
		int x = temp[i];
		arr[x / M][x % M] = 0; // 일반 공간을 벽으로 변환
	}

	for (int i = 0; i < N; i++) // 2(바이러스)가 있는 곳을 찾기 위해 for문을 돌린다.
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 2)
			{
				bfs(i, j, N, M); // 2를 확산시키는 함수
			}
		}
	}
	for (int i = 0; i < N; i++) // 0의 개수를 세서 답을 구한다.
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 0)value++;
		}
	}
	if (value > size)size = value; // 최대값을 찾는다.
}

void f(int temp[], int idx, int n, int k, int N, int M) // n 개 중에서 3개를 선택하는 함수 
{ // temp[]와 idx는 선택한 값들이 있는 배열과 배열의 크기, k는 배열에 넣을 값, N 과 M은 배열의 세로와 가로입니다.
	if (idx == 3) // 3개의 좌표를 구하면 
	{
		for (int i = 0; i < idx; i++)
		{
			int x = temp[i];
			if (arr[x / M][x % M] != 0)return; // 벽 또는 바이러스면 설치할 수 없다.
		} // 배열을 보내면 3개의 좌표를 계속해서 전송할 수 있다.
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
	std::cin >> n >> m; // 세로크기, 가로크기 입력
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			std::cin >> arr[i][j]; // 
			map[i][j] = arr[i][j]; // 원본을 저장해준다.
		}
	}

	f(temp, 0, n*m, 0, n, m); // N*M개 중에서 3개를 고르는 함수
	std::cout << size;
	return 0;
}
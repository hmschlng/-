// ���� 14502�� ����
// ������
#include <iostream>
#include <queue>

int arr[10][10]; // �迭 ����
int map[10][10]; // ���������� Ȯ���ϴ� �迭
int temp[100]; // f �Լ����� ����ϴ� �迭
int size;

//void h(int i, int j, int N, int M) // stack overflow�� ���� error
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

void bfs(int i, int j, int N, int M) // ���̷����� �ִ� ������ 0���� Ȯ���Ű�� �Լ�
{
	std::queue<std::pair<int, int>> q;
	q.push(std::pair<int, int>(i, j));

	while(!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (x - 1 >= 0 && map[x - 1][y] == 0) // �������� Ȯ��
		{
			map[x - 1][y] = 2;
			q.push(std::pair<int, int>(x - 1, y));
		}
		if (x + 1 < N && map[x + 1][y] == 0) // ���������� Ȯ��
		{
			map[x + 1][y] = 2;
			q.push(std::pair<int, int>(x + 1, y));
		}
		if (y - 1 >= 0 && map[x][y - 1] == 0) // ���� Ȯ��
		{
			map[x][y - 1] = 2;
			q.push(std::pair<int, int>(x, y - 1));
		} 
		if (y + 1 < M && map[x][y + 1] == 0) // �Ʒ��� Ȯ��
		{
			map[x][y + 1] = 2;
			q.push(std::pair<int, int>(x, y + 1));
		}
	}
}

void g(int temp[], int N, int M) // 3���� ��ǥ�� �޾Ƽ� ���� ����ų� ���� �����ϴ� �Լ�
{
	int value = 0;
	std::queue<std::pair<int, int>> q;
	for (int i = 0; i < 3; i++) // 3���� ���� ����
	{
		int x = temp[i];
		arr[x / M][x % M] = 1; // �Ϲ� ������ ������ ��ȯ
	}

	for (int i = 0; i < N; i++) // map���� �����ϰ�
	{
		for (int j = 0; j < M; j++)map[i][j] = arr[i][j];
	}

	for (int i = 0; i < 3; i++) // arr[i][j]�� �ٽ� �������� ���ư���.
	{
		int x = temp[i];
		arr[x / M][x % M] = 0; // �Ϲ� ������ ������ ��ȯ
	}

	for (int i = 0; i < N; i++) // 2(���̷���)�� �ִ� ���� ã�� ���� for���� ������.
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 2)
			{
				bfs(i, j, N, M); // 2�� Ȯ���Ű�� �Լ�
			}
		}
	}
	for (int i = 0; i < N; i++) // 0�� ������ ���� ���� ���Ѵ�.
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == 0)value++;
		}
	}
	if (value > size)size = value; // �ִ밪�� ã�´�.
}

void f(int temp[], int idx, int n, int k, int N, int M) // n �� �߿��� 3���� �����ϴ� �Լ� 
{ // temp[]�� idx�� ������ ������ �ִ� �迭�� �迭�� ũ��, k�� �迭�� ���� ��, N �� M�� �迭�� ���ο� �����Դϴ�.
	if (idx == 3) // 3���� ��ǥ�� ���ϸ� 
	{
		for (int i = 0; i < idx; i++)
		{
			int x = temp[i];
			if (arr[x / M][x % M] != 0)return; // �� �Ǵ� ���̷����� ��ġ�� �� ����.
		} // �迭�� ������ 3���� ��ǥ�� ����ؼ� ������ �� �ִ�.
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
	std::cin >> n >> m; // ����ũ��, ����ũ�� �Է�
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			std::cin >> arr[i][j]; // 
			map[i][j] = arr[i][j]; // ������ �������ش�.
		}
	}

	f(temp, 0, n*m, 0, n, m); // N*M�� �߿��� 3���� ���� �Լ�
	std::cout << size;
	return 0;
}
// ���� 18352��
// ���̽����� �ſ� ������ ����
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

int visited[300001]; // �湮�� �Ÿ�

int main() 
{
	int N, M, K, X;
	int a, b;
	std::cin >> N >> M >> K >> X;
	std::vector<std::vector<int>> arr(N + 1); // 2���� �迭�� ũ�⿡ ������� ���� �� �ִ�. 
	std::queue<std::pair<int, int>> q; // ť�� ��ǥ�� �����Ѵ�.
	std::vector<int> result;
	for (int i = 0; i < M; i++)
	{
		std::cin >> a >> b;
		arr[a].push_back(b);
	}

	visited[X] = 1;
	q.push(std::pair<int, int>(X, 0));

	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (y == K) //�Ÿ� ������ ������
		{
			result.push_back(x);
		}
		for (int i = 0; i < (signed)arr[x].size(); i++) // (signed)�� ������ ������ ������ ���´�.
		{
			int z = arr[x][i];
			if (visited[z] == 0)
			{
				// �湮�� ���� ������
				visited[z] = 1;
				q.push(std::pair<int, int>(z, y + 1));
			}
		}
	}

	if (result.empty()) // �Ÿ��� ���� ��찡 �����ٸ�
	{
		std::cout << -1; // -1�� ����մϴ�.
		return 0;
	}

	std::sort(result.begin(), result.end()); // �� �ٿ� �ϳ��� ������������ ����

	for (auto i : result)std::cout << i << "\n"; // ���
	return 0; 
}

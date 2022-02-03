// ���� 14888�� �����Դϴ�.
#include <iostream>

int oper[12]; // ����
int op[12]; // ������
int pmmd[4]; // ������ ����
int arr[100]; // f �Լ����� ����� �迭
int min = 2147483600, max = -2147483600; // �ּڰ��� �ִ� : �� ������ ������ ����� �� ����

bool find(int arr[], int idx, int v) // �迭�� ���ԵǾ� �ִ��� Ȯ���ϴ� �Լ�
{
	for (int i = 0; i < idx; i++)
	{
		if (arr[i] == v)return true;
	}
	return false;
}

void f(int arr[], int idx, int n, int k, int N) // ������ ����� �Լ�
{
	if (idx == n)
	{
		int value = oper[0]; // ù ��° ���ڸ� �޾ƿ´�.
		int iter = 0;

		for (int i = 1; i < N; i++) // ������ �� �迭�� ������ for���� ������.
		{
			int x = op[arr[iter]]; // �����ڵ��� �޾ƿ´�.
			if (x == 0) // ���ϱ�
			{
				value += oper[i];
			}
			else if (x == 1) // ����
			{
				value -= oper[i];
			}
			else if (x == 2) // ���ϱ�
			{
				value *= oper[i];
			}
			else if (x == 3) // ������
			{
				value /= oper[i];
			}
			++iter; //���� �����ڸ� ���ؼ� ����
		}
		if (value > max)max = value; // �ּڰ��� ã�´�.
		if (value < min)min = value; // �ִ밪�� ã�´�.
		return;
	}
	for (int i = 0; i < k; i++) 
	{
		if (!find(arr, idx, i)) //������ ����� �Լ� -> �̰� ������ �ߺ������� �ȴ�.
		{
			arr[idx] = i;
			f(arr, idx + 1, n, k, N); 
		}
		else
			continue;
	}
	return;
}

int main()
{
	int N;

	std::cin >> N; // ���� ���� N��
	for (int i = 0; i < N; i++)std::cin >> oper[i]; // N���� ���ڵ��� �Է¹޴´�.
	for (int i = 0; i < 4; i++)std::cin >> pmmd[i]; // ���ϱ�, ����, ���ϱ�, ������(plus, minus, multiply, divide)
	int count = 0;
	for (int i = 0; i < 4; i++) // ���ϱ�, ����, ���ϱ�, �����⸦ �� �迭�� �ٲٴ� ����
	{
		if (pmmd[i] == 0)continue;
		else
		{
			for (int j = 0; j < pmmd[i]; j++)op[count++] = i; // 2 1 1 1 �� ��� [0 0 1 2 3]�� �ǰ�, 0 0 1 1�� ��� [2 3]�� �˴ϴ�.
		}
		if (count == N - 1)break;
	}
	f(arr, 0, N-1, N-1, N); // ���� �����ִ� �Լ�
	std::cout << max << "\n" << min;
	return 0;
}

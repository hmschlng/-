#include <iostream>

int arr[30001];

int min(int a, int b)
{
	if (a * b == 0)return a + b;
	else return (a > b) ? b : a;
}

int main()
{
	int n;
	std::cin >> n;
	for (int i = 1; i <=n; i++)
	{
		if(i*5 < 30001)arr[i * 5] = min(arr[i * 5], arr[i] + 1); // ũ�Ⱑ 30000�� ������ �� 
		if(i*3 < 30001)arr[i * 3] = min(arr[i * 3], arr[i] + 1); // 30000 * 5�� �ε����� Out of Index!
		if(i*2 < 30001)arr[i * 2] = min(arr[i * 2], arr[i] + 1); // �׷��� ���ǹ��� ����
		if(i+1 < 30001)arr[i + 1] = min(arr[i + 1], arr[i] + 1);
	}
	std::cout << arr[n];
}
// �Ž����� ����

// 500��, 100��, 50��, 10��
#define _CRT_SECURE_NO_WARNINGS

#include <iostream>

void Run1()
{
	int N, a[4] = { 500, 100, 50, 10 }, i = 0, answer = 0;

	scanf("%d", &N);
	while (i <= 3) //4�� ������ �ڵ�
	{
		answer += N / a[i]; // �信 ���� �� ���Ѵ�.
		N %= a[i++]; // N�� �������� ���Ѵ�.
	}
	std::cout << answer; //�� 
	return;
}

// ū ���� ��Ģ

#include <set>

void Run2()
{
	int N, M, K, a, answer=0;
	std::multiset<int, std::greater<int>> s; // �ߺ��� ����ϱ� ���� multiset ���, greater : ��������, less : ��������
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &a);
		s.insert(a);
	}
	std::multiset<int>::iterator iter_2 = s.begin(); // ���� ū ��
	iter_2++; // �� ��°�� ū ��
	std::multiset<int>::iterator iter = s.begin(); // ���� ū ��
	for (int i = 1; i <= M; i++) 
	{
		if (i % (K+1) == 0)	answer += *iter_2; // K+1 ��°�� �� ��° �� 
		else answer += *iter; // �������� ���� ū ��
	}
	std::cout << answer;
	return;
}

// ���� ī�� ����


void Run3()
{
	int n, m;
	scanf("%d %d", &n, &m);
	std::set<int, std::greater<int>> s; // greater : ��������
	for (int i = 0; i < n; i++)
	{
		int value, min=INT_MAX;
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &value);
			if (min > value)min = value; // �Է� ���� �ٿ��� ���� ���� ��
		}
		s.insert(min); //�� set�� �Է�
	}
	std::set<int>::iterator iter = s.begin(); // ���� ū ���� ã�� ������ ���� ���� �ִ� ��
	std::cout << *iter;
	return;
}

// 1�� �� �� ����

void Run4() 
{
	int N, K, i=0;
	scanf("%d %d", &N, &K);
	while (N >= K) // ���� �� ���� ������ 
	{
		N /= K; // ������
		i++;
	}
	std::cout << i + (N-1); //1�� �Ƿ��� N-1�� �����ϱ� ������ + (N-1)
	return;
}

// ���谡 ���

void Q1()
{
	int N, a, count=0, answer=0;
	std::multiset<int, std::less<int>> ms; 
	scanf("%d", &N);
	for (int i = 0; i < N; i++) // N�� �Է�
	{
		scanf("%d", &a);
		ms.insert(a);
	}
	for (auto i : ms) //ms ���� ���� ����
	{
		++count;
		if (i == count) // ���� ������
		{
			answer++; // +1
			count = 0;
		}
	}
	std::cout << answer;
}

// ���ϱ� Ȥ�� ���ϱ�

#include <string>
#include <vector>

void Q2()
{
	std::string str;
	std::vector<int> v;
	std::cin >> str;
	for (int i = 0; i < str.length(); i++)v.push_back(str[i] - 48); // char ������ 48�� �����Ѵ�
	int answer = v[0];
	for (int i = 1; i < v.size(); i++)
	{
		if (v[i] <= 1 || answer <= 1)answer += v[i]; // 0 �Ǵ� 1�� ���ϴ°� ũ��
		else answer *= v[i]; // �������� ���Ѱ� ũ��
	}
	std::cout << answer;
	return;
} // 0 1 2 3 4 -> 36

//���ڿ� ������

int count[2];

void Q3() 
{
	std::string str;
	std::cin >> str; // ���ڿ��� �޴´�.
	int state; 
	for (int i = 0; i < str.length(); i++)
	{
		if (i == 0)
		{
			state = str[0] - 48; // 0���� 1����
			count[state]++;
		}
		else
		{
			if ((str[i] - 48) != state)
			{
				state = (state + 1) % 2; // 0�� 1�� �����ư��� �ϴ� �ڵ�
				count[state]++;
			}
		}
	}
	(count[0] > count[1]) ? std::cout << count[1] : std::cout << count[0]; // 0�� 1 �� ���� Ƚ�� ���
	return;
}

// ���� �� ���� �ݾ� 
#include <vector>
#include <algorithm>

void Q4()
{
	int N, a, answer;
	std::vector<int> v;
	std::cin >> N;
	for (int i = 0; i < N; i++)
	{
		std::cin >> a;
		v.push_back(a);
	}
	std::sort(v.begin(), v.end()); // vector ����
	answer = 1;
	for (auto i : v)
	{
		if (answer < i)break; // ���� ���� < �Է¹��� ���ο� ���ڸ� ����
		answer += i;
	}
	std::cout << answer << std::endl;
	return;
}

void Q5() // ���� ���
{
	int N, M, a;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &a);
	}
	std::cout << N * (N - 1) / 2 - (N - M); // nC2 - �ߺ� ����
}

int main()
{
	//����� �ڵ常 �ּ� ����
	//Run1(); // 1260
	//Run2(); // 5 8 3 
			  // 2 4 5 4 6	
	//Run3(); //3 3	3 1 2	4 1 4	2 2 2		2 4		7 3 1 8		3 3 3 4
	//Run4();

	//Q1();
	//Q2();
	//Q3();
	//Q4();
	//Q5();
	return 0;
}
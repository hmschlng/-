// 거스름돈 문제

// 500원, 100원, 50원, 10원
#define _CRT_SECURE_NO_WARNINGS

#include <iostream>

void Run1()
{
	int N, a[4] = { 500, 100, 50, 10 }, i = 0, answer = 0;

	scanf("%d", &N);
	while (i <= 3) //4번 돌리는 코드
	{
		answer += N / a[i]; // 답에 몫을 다 더한다.
		N %= a[i++]; // N의 나머지를 구한다.
	}
	std::cout << answer; //답 
	return;
}

// 큰 수의 법칙

#include <set>

void Run2()
{
	int N, M, K, a, answer=0;
	std::multiset<int, std::greater<int>> s; // 중복을 허락하기 위해 multiset 사용, greater : 내림차순, less : 오름차순
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &a);
		s.insert(a);
	}
	std::multiset<int>::iterator iter_2 = s.begin(); // 가장 큰 값
	iter_2++; // 두 번째로 큰 값
	std::multiset<int>::iterator iter = s.begin(); // 가장 큰 값
	for (int i = 1; i <= M; i++) 
	{
		if (i % (K+1) == 0)	answer += *iter_2; // K+1 번째는 두 번째 값 
		else answer += *iter; // 나머지는 가장 큰 값
	}
	std::cout << answer;
	return;
}

// 숫자 카드 게임


void Run3()
{
	int n, m;
	scanf("%d %d", &n, &m);
	std::set<int, std::greater<int>> s; // greater : 내림차순
	for (int i = 0; i < n; i++)
	{
		int value, min=INT_MAX;
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &value);
			if (min > value)min = value; // 입력 받은 줄에서 가장 작은 값
		}
		s.insert(min); //을 set에 입력
	}
	std::set<int>::iterator iter = s.begin(); // 가장 큰 값을 찾기 때문에 가장 먼저 있는 값
	std::cout << *iter;
	return;
}

// 1이 될 때 까지

void Run4() 
{
	int N, K, i=0;
	scanf("%d %d", &N, &K);
	while (N >= K) // 나눌 수 없을 때까지 
	{
		N /= K; // 나눈다
		i++;
	}
	std::cout << i + (N-1); //1이 되려면 N-1번 빼야하기 때문에 + (N-1)
	return;
}

// 모험가 길드

void Q1()
{
	int N, a, count=0, answer=0;
	std::multiset<int, std::less<int>> ms; 
	scanf("%d", &N);
	for (int i = 0; i < N; i++) // N개 입력
	{
		scanf("%d", &a);
		ms.insert(a);
	}
	for (auto i : ms) //ms 원소 전부 보기
	{
		++count;
		if (i == count) // 값이 같으면
		{
			answer++; // +1
			count = 0;
		}
	}
	std::cout << answer;
}

// 곱하기 혹은 더하기

#include <string>
#include <vector>

void Q2()
{
	std::string str;
	std::vector<int> v;
	std::cin >> str;
	for (int i = 0; i < str.length(); i++)v.push_back(str[i] - 48); // char 형에서 48을 빼야한다
	int answer = v[0];
	for (int i = 1; i < v.size(); i++)
	{
		if (v[i] <= 1 || answer <= 1)answer += v[i]; // 0 또는 1은 더하는게 크다
		else answer *= v[i]; // 나머지는 곱한게 크다
	}
	std::cout << answer;
	return;
} // 0 1 2 3 4 -> 36

//문자열 뒤집기

int count[2];

void Q3() 
{
	std::string str;
	std::cin >> str; // 문자열을 받는다.
	int state; 
	for (int i = 0; i < str.length(); i++)
	{
		if (i == 0)
		{
			state = str[0] - 48; // 0인지 1인지
			count[state]++;
		}
		else
		{
			if ((str[i] - 48) != state)
			{
				state = (state + 1) % 2; // 0과 1을 번갈아가게 하는 코드
				count[state]++;
			}
		}
	}
	(count[0] > count[1]) ? std::cout << count[1] : std::cout << count[0]; // 0과 1 중 작은 횟수 출력
	return;
}

// 만들 수 없는 금액 
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
	std::sort(v.begin(), v.end()); // vector 정렬
	answer = 1;
	for (auto i : v)
	{
		if (answer < i)break; // 만든 숫자 < 입력받은 새로운 숫자면 종료
		answer += i;
	}
	std::cout << answer << std::endl;
	return;
}

void Q5() // 조합 사용
{
	int N, M, a;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &a);
	}
	std::cout << N * (N - 1) / 2 - (N - M); // nC2 - 중복 개수
}

int main()
{
	//사용할 코드만 주석 제거
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
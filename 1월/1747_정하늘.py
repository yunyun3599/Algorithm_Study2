import math

def eratos(num):
    arr = [False, False] + [True] * (num + 1) # 0, 0, 1, 1 ...
    for i in range(2, int(math.sqrt(num + 1))):
        if arr[i] == True:
            for j in range(i + i, num + 2, i):
                arr[j] = False
    return [i for i in range(2, num + 1) if arr[i] == True]

def isPalindrome(num):
    for i in range(0,len(str(num)) // 2):
        if str(num)[i] != str(num)[-1-i]:
            return False
    return True
        
n = int(input())
arr = eratos(1234567)

for prime in arr:
    if prime >= n:
        if isPalindrome(prime):
            print(prime)
            break

    

'''
1747. 소수&팰린드롬
https://www.acmicpc.net/problem/1747

문제
어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 조건을 만족하는 수를 출력한다.
'''
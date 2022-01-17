import math

def isPrime(num):
    for i in range(2, int(math.sqrt(num) + 1)):
        if num % i == 0:
            return False
    return True

def isPalindrome(num):
    if str(num) == str(num)[::-1]:
        return True
    return False
    
N = int(input())
for i in range(N, 2000001):
    if isPalindrome(i) and isPrime(i) and i != 1:
        print(i)
        exit()

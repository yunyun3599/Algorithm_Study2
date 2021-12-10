arr = input()
isPalindrome = True
ans = -1

for i in range(len(arr)//2):
    if arr[i] != arr[-1 -i]:
        isPalindrome = False

if not isPalindrome:
    ans = len(arr)
else:
    for i in range(len(arr)):
        if(arr[i] != arr[0]):
            ans = len(arr) - 1
            break

print(ans)

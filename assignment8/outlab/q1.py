from ISPALIN import ISPALIN

T = int(input())
wordList = []
for i in range(T):
    wordList.append(input())
for word in wordList:
    answer = ISPALIN(word)
    print('Yes' if answer else 'No')
s = int(input())
n = str(input())
counter = 0
counter2 = 0
listOfChars = list()
listOfChars.extend(n)
for i in range(s * 2 - 1):
    if(listOfChars[i] == 'U' and listOfChars[i + 1] == 'U'):
        counter += 1
    if(listOfChars[i] == 'I' and listOfChars[i + 1] == 'I'):
        counter2 += 1
if (listOfChars[0] == 'U'): counter2+=1;
if (counter > counter2):
    print(counter)
else:
    print(counter2)
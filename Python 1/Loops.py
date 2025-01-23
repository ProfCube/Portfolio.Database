##T = 0
##
##for N in [1, 2, 3, 4, 5,]:
##    T += N
##    
##print('The sum is:', N)
##
### What if I want to 100?
##
##iTotal = 0
##
##for iNumber in range(1, 101):
##    iTotal += iNumber
##print('The sum is:', iNumber)
##
### What if I want even number to 10
##
##iT = 0
##
##for iNumber in range(2, 11):
##    if (iNumber % 2) == 0:
##        iT += iNumber
##print('The sum of even numbers to 10 is:', iT)
##
### Parameter
##
##iTt = 0
##
##for iNumber in range(2, 11, 2):
##    iTt += iNumber
##print('The sum of even numbers to 10 is:', iTt)
##
##
### Other Example
##
##Total = 0
##Number = 1
##
##while Number <= 5:
##    Total += Number
##    print(Number)
##    Number += 1
##print('The sum is:', Total)

##iTotal = 0
##for iCount in range(4,6):
##    iTotal += iCount
##    print(iTotal)

##def main():
##    print("The answer is", magic(5))
##def magic(num):
##    answer = num + 2 * 10
##    return answer
##main()

##def pass_it(x, y):
##    z = y**x
##    return(z)
##num1 = 3
##num2 = 4
##answer = pass_it(num1, num2)
##print(answer)

##def pass_it(x, y):
##    z = x*y
##    result = get_result(z)
##    return(result)
##def get_result(number):
##    z = number + 2
##    return(z)
##num1 = 3
##num2 = 4
##answer = pass_it(num1, num2)
##print(answer)

def pass_it(x, y):
    z = x + ", " + y
    return(z)
name2 = "Brian"
name1 = "Candido"
fullname = pass_it(name1, name2)
print(fullname)

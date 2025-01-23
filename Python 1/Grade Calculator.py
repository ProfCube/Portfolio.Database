# Output for requirements
def Non_Negative(sInput):
    
    value = -1 # essential
    while value < 0:
        try:
            value = float(input(sInput))
            if(value < 0):
                print("Input must be a positive numeric value")
                
        except ValueError:
            print("Input must be a positive numeric value")
            
    return value


def Grades(TestIn):
    if TestIn >= 97.0 and TestIn <= 100:
        return 'A+'
    elif TestIn >= 94.0 and TestIn <= 96.9:
        return 'A'
    elif TestIn >= 90.0 and TestIn <= 93.9:
        return 'A-'
    elif TestIn >= 87.0 and TestIn <= 89.9:
        return 'B+'
    elif TestIn >= 84.0 and TestIn <= 86.9:
        return 'B'
    elif TestIn >= 80.0 and TestIn <= 83.9:
        return 'B-'
    elif TestIn >= 77.0 and TestIn <= 79.9:
        return 'C+'
    elif TestIn >= 74.0 and TestIn <= 76.9:
        return 'C'
    elif TestIn >= 70.0 and TestIn <= 73.9:
        return 'C-'
    elif TestIn >= 67.0 and TestIn <= 69.9:
        return 'D+'
    elif TestIn >= 64.0 and TestIn <= 66.9:
        return 'D' 
    elif TestIn >= 60.0 and TestIn <= 63.9:
        return 'D-'
    else:
        return 'F'

# outputs
Name = input('Name of person that we are calculating the Grades for: ')
Test1 = float(input('Test 1: '))
Test2 = float(input('Test 2: '))
Test3 = float(input('Test 3: '))
Test4 = float(input('Test 4: '))

iSum = sum((Test1, Test2, Test3, Test4))
iMin = min(Test1, Test2, Test3, Test4)
numOfGrades=4
DropLowestGrade = input('Do you wish to Drop the Lowest Grade Y or N? ')

if DropLowestGrade.upper() == "Y":
    numOfGrades = 3
    average = (iSum - iMin) / numOfGrades
else:
    average = iSum / numOfGrades

print(Name, 'test average is: {:.1f}'.format(average))
print('Letter Grade for the test is: {}'.format(Grades(average)))


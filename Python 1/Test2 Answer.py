# Carlos Badillo
# Test Answer 2

# Prompt input
year = int(input("Enter the Year: "))
 
if (( year%400 == 0) or (( year%4 == 0 ) and ( year%100 != 0))):
    print("This is a Leap Year. February has 29 days in it.")
else:
    print("This is NOT a Leap Year. February has only 28 days in it.")

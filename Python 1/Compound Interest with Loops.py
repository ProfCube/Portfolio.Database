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

Deposit = Non_Negative("What is the Original Deposit (positive value): ")
Interest_Rate = Non_Negative("What is the Interest Rate (positive value): ")
Number_of_Month = int(Non_Negative("What is the Nuber of Months (positive value): "))
Goal_Amount = Non_Negative("What is the Goal Amount (can enter 0 but not negative): ")

# Calculations of the Months
r = Interest_Rate/100

for i in range(1, 1+Number_of_Month):
    FV = Deposit * (((1 + (r/12)) ** (i)))
    print("Month {} Account Balance is: $ {:,.2f}".format(i, FV))

Acut = 0
t = 0
while t < Goal_Amount:
    Acut += 1
    t = Deposit * (((1 + (r/12)) ** (Acut)))
print('It will take: {} months to reach the goal of $ {:,.2f}'.format(Acut, Goal_Amount))

# User must input principal, Compound rate, annual rate, and years.
PV = float(input("Enter the starting principal: "))
R = float(input("Enter the annual interest rate: "))
m = int(input("How many times per year is the interest compounded? "))
t = int(input("For how many years will the account earn interest? "))

# Calculations to out put the final total
r = R/100
FV = PV * (((1 + (r/m)) ** (m*t)))


# Display the year and the total
print ("At the end of {} years will have $ {:,.2f}".format(t, FV))
    

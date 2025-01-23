# Require input of Payments
Hourly_Rate = float(input('Enter hours worked: '))
Pay_Rate = float(input('Enter hourly rate: '))
Regular_Pay = 0.0
Time_and_Half_Pay = 0.0
Double_Time_Pay = 0.0

# Calculations to compute the right pay
if Hourly_Rate <= 40 and Hourly_Rate <= 60:
    Regular_Pay = Hourly_Rate
    Time_and_Half_Pay = Hourly_Rate - 40
    Regular_Pay = 40
else:
    Time_and_Half_Pay = 20
    Regular_Pay = 40
    Double_Time_Pay = Hourly_Rate - 60

fRegular_Pay = float(Regular_Pay * Pay_Rate)
fTime_and_Half_Pay = float((Pay_Rate * 1.5) * Time_and_Half_Pay)
fDouble_Time_Pay = float((Pay_Rate * 2) * Double_Time_Pay)
Total_Pay = fRegular_Pay + fTime_and_Half_Pay + fDouble_Time_Pay

# Final Print Outs
print('Regular Pay is: ${:,.2f}'.format(fRegular_Pay))
print('Time and Half Pay is: ${:,.2f}'.format(fTime_and_Half_Pay))
print('Double time Pay is: ${:,.2f}'.format(fDouble_Time_Pay))
print('Total_Pay is: ${:,.2f}'.format(Total_Pay))

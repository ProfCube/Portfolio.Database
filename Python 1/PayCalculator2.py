##Grade = float(input('What is the grade you got(Numbers Only.): '))
##
##if Grade >= 90:
##    print('You Passed')
##    if Grade == 100:
##        print('You got a Perfect Score')
##else:
##    print('You will need to retake Retake')
##    

# Asking for Hours & Pay
Hours_in_Week = float(input('Enter hours worked: '))
Pay_Rate = float(input('Enter hourly rate: '))
Double_Time_Pay = 0

# Calculations
if Hours_in_Week <= 55:
    Regular_Pay = (Hours_in_Week - 15) * Pay_Rate
    Time_and_Half_Pay = (Hours_in_Week - 40) * 20 * 1.5
    print('Regular Pay is: ${:,.2f}'.format(Regular_Pay))
    print('Time and Half Pay: ${:,.2f}'.format(Time_and_Half_Pay))
    print('Double Time: ${}'.format(Double_Time_Pay))
    print('Total Pay is: ${:,.2f}'.format(Regular_Pay + Time_and_Half_Pay))
else:
    Regular_Pay = (Hours_in_Week - 25) * Pay_Rate
    Time_and_Half_Pay = (Hours_in_Week - 45) * Pay_Rate * 1.5
    Double_Time = ((Hours_in_Week - 60)* Pay_Rate * (Double_Time_Pay + 2))   
    print('Regular Pay is: ${:,.2f}'.format(Regular_Pay))
    print('Time and Half Pay: ${:,.2f}'.format(Time_and_Half_Pay))
    print('Double Time: ${}'.format(Double_Time))
    print('Total Pay is: ${:,.2f}'.format(Regular_Pay + Time_and_Half_Pay + Double_Time))    

    

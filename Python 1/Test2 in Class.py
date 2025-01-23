###--------------------#
##if fSales > 50000:
##    bBonus = True
###--------------------#
##if fSales >= 60000:
##    bBonus = True
##    iCommisionRate = .125
##    iDaysOff += 1
###--------------------#
##if iAge > 20:
##    sMessage = "Legal"
##else:
##    sMessage = "Not Leagl"
###--------------------#
##if iTemp <= 40:
##    sMessage = "Cold"
##elif iTemp > 40 and iTemp <= 60:
##    sMessage = "Chilly"
##elif iTemp > 60 and iTemp <= 75:
##    sMessage = "Warm"
##else:
##    sMessage = "Hot"
###--------------------#
##if fSalary > 30000 and iYears >2:
##    sLoan = "Approved"
##elif iYears > 5:
##    sLoan = "Approved"
##else:
##    sLoan = "Not Approved"
###--------------------#
##if iNumber >= 22 and iNumber <= 65:
##    bNumberOK = True
##else:
##    bNumberOk = False
###--------------------#
##iNumber= " "
##for iNumber in range(22, 65):
##    bNumberOutside = True
##else:
##    bNumberOutside = False
###--------------------#
##if  eState == "CT" or eState == "VT":
##    fTax = .06
##elif eState == "MA":
##    fTax = .0625
##elif eState == "ME":
##    fTax = .85
##elif eState == "NH":
##    fTax = 0
##elif eState == "RI":
##    fTax = .7
##else:
##    fTax = "Good Tax"
###--------------------#
##
##Name = input('What is your name: ') # Name they want to be called.
##Age = input('Please prvide you Age: ') # People will imput their age
##
##if Age is < 5:
##    print(Name, "you will pay $0")
##elif Age is < 12:
##    print(Name, "you will pay $4.00")
##elif Age is < 18:
##    print(Name, "you will pay $5.00")
##elif Age is < 22:
##    print(Name, "you will pay $6.00")
##elif Age is < 64:
##    print(Name, "you will pay $8.50")
##else:
##    print(Name, "Senoir will pay $6.00")
##

Village = float(input('How big is your Village: '))
if Village  <= 500:
    print('Village')
elif Village <= 5000:
    print('Town')
elif Village <= 9999:
    print('Small Town')
else:
    print('Large City')

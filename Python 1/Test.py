Name = input('What is your name: ') # Name they want to be called.
Age = int(input('Please prvide you Age: ')) # People will imput their age

if Age < 5:
    fAdmissionCost = 0.0
    sAdmissionType = "Infant"
elif Age < 12:
    fAdmissionCost = 4.00
    sAdmissionType = "Tween"
elif Age < 18:
    fAdmissionCost = 5.00
    sAdmissionType = "Teen"
elif Age < 22:
    fAdmissionCost = 6.00
    sAdmissionType = "Student"
elif Age < 64:
    fAdmissionCost = 8.50
    sAdmissionType = "Adult"
else:
    fAdmissionCost = 6.00
    sAdmissionType = "Senior"

print(Name, 'you will pay', fAdmissionCost, "and you will be located in", sAdmissionType)


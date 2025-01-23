# Out put of all request
print("Welcome to Carlos's BMI Calcualtor")
print('')

Name = input('Name of person that we are calculating the BMI for: ')
Height = float(input('Supply Height in Inches: '))
Weight = float(input('Supply Weight in Pounds: '))

# Calculations
Meters = Height / 39.36
Kilograms = Weight / 2.2
BMI = Kilograms / ( Meters * Meters )

print(Name, "BMI is: {:.2f}".format(BMI))



# String Section
if BMI <= 18.50:
    print('BMI finding is the subject is: Underweight')
elif BMI <= 24.90:
    print('BMI finding is the subject is: Normal')
elif BMI <= 29.90:
    print('BMI finding is the subject is: Overweight')
else:
    print('BMI finding is the subject is: Obese')

# Carlos Badillo
# Test Answer 1

# Prompt inputs
Temperature = float(input('Enter a temeprature: '))
FC = input('Is the temp F for Fahrenheit or C for Celsius? ')

# Calculations
if FC.upper() == "F":
    if Temperature > 212:
        print('Temp can not be > 212')
    elif Temperature < 212:
        Celsius = (5.0/9) * (Temperature - 32)
        print('The Celsius equivalent is: {:.1f}'.format(Celsius))
elif FC.upper() == "C":
    if Temperature > 100:
        print('Temp can not be > 100')
    elif Temperature < 100:
        Fahrenhiet = ((9.0/5.0) * Temperature) + 32
        print('The Fahrenhiet equicalent is: {:.1f}'.format(Fahrenhiet))
else:
    print('Enter a F or C')    
    


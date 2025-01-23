# Requesting input from the user
try:
    fWEEKLY_HOURS = float(input("How many hours you worked durring the week?: "))
    fPAY_RATE = float(input("What is your pay rate?: "))
except ValueError:
    print("Please enter a valid number for hours worked and pay rate.")
    exit()



# Calculating the regular pay, time and a half, and double time
fREGULAR_PAY = fWEEKLY_HOURS * fPAY_RATE
fTIME_AND_A_HALF = 0.0
fTIME_DOUBLE = 0.0

# Calculating the total pay
if fWEEKLY_HOURS <= 40:
    print(f"Your regular pay is: ${fREGULAR_PAY:,.2f}")
    print(f"Your time and a half pay is: ${fTIME_AND_A_HALF:,.2f}")
    print(f"Your double time pay is: ${fTIME_DOUBLE:,.2f}")
    print(f"Your total pay is: ${fREGULAR_PAY:,.2f}")
elif fWEEKLY_HOURS > 40 and fWEEKLY_HOURS <= 60:
    fREGULAR_PAY = (fWEEKLY_HOURS - 15) * fPAY_RATE
    fTIME_AND_A_HALF = (fWEEKLY_HOURS - 40) * 20 * 1.5
    fTOTAL_PAY = fREGULAR_PAY + fTIME_AND_A_HALF
    print(f"Your regular pay is: ${fREGULAR_PAY:,.2f}")
    print(f"Your time and a half pay is: ${fTIME_AND_A_HALF:,.2f}")
    print(f"Your double time pay is: ${fTIME_DOUBLE:,.2f}")
    print(f"Your total pay is: ${fTOTAL_PAY:,.2f}")
else:
    fREGULAR_PAY = (fWEEKLY_HOURS - 25) * fPAY_RATE 
    fTIME_AND_A_HALF = (fWEEKLY_HOURS - 45) * fPAY_RATE * 1.5
    fDOUBLE_TIME = ((fWEEKLY_HOURS - 60) * fPAY_RATE * (fTIME_DOUBLE + 2))
    fTOTAL_PAY = fREGULAR_PAY + fTIME_AND_A_HALF + fDOUBLE_TIME
    print(f"Your regular pay is: ${fREGULAR_PAY:,.2f}")
    print(f"Your time and a half pay is: ${fTIME_AND_A_HALF:,.2f}")
    print(f"Your double time pay is: ${fDOUBLE_TIME:,.2f}")
    print(f"Your total pay is: ${fTOTAL_PAY:,.2f}")
# Final Print Outs
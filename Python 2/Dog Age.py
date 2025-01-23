fDog_Convertion = 7.3
sName = input("What is the dog's name: ")
try:
    fAge = float(input(f"What is {sName}'s age: "))
except:
        print("Please enter a valid number for the age.")
        exit()

fHumanAge = fAge * fDog_Convertion
print(f"{sName} is {fHumanAge} years old in human years.") 
print(f"{sName} is {fHumanAge:.2f} years old in human years.")
print(f"{sName} is {fHumanAge:.1f} years old in human years.")
print(f"{sName} is {fHumanAge:.0f} years old in human years.")

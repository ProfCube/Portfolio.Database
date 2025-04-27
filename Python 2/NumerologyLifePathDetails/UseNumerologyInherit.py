from NumerologyLifePathDetails import NumerologyLifePathDetails
from datetime import datetime

def is_valid_date(dob):
    try:
        datetime.strptime(dob.replace('/', '-'), '%m-%d-%Y')
        return True
    except ValueError:
        return False

def main():
    print("Welcome to the Numerology Calculator\n")

    name = input("What's your full birth name? ").strip()
    while not name:
        name = input("Please enter a valid name: ").strip()

    dob = input("Enter your birthdate (MM-DD-YYYY or MM/DD/YYYY): ").strip()
    while not is_valid_date(dob):
        dob = input("Invalid format. Use MM-DD-YYYY or MM/DD/YYYY: ").strip()

    profile = NumerologyLifePathDetails(name, dob)

    print(f"\nNumerology Profile for {profile.Name}")
    print(f"Birthdate: {profile.Birthdate}")
    print(f"Life Path Number: {profile.LifePath}")
    print(f"Life Path Meaning: {profile.LifePathDescription}")
    print(f"Birthday Number: {profile.BirthDay}")
    print(f"Attitude Number: {profile.Attitude}")
    print(f"Soul Number: {profile.Soul}")
    print(f"Personality Number: {profile.Personality}")
    print(f"Power Name Number: {profile.PowerName}")

main()
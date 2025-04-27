from Numerology import Numerology

def validate_date_format(date_str):
    if len(date_str) != 10:
        return False
    if date_str[2] not in ['-', '/'] or date_str[5] not in ['-', '/']:
        return False
    month = date_str[:2]
    day = date_str[3:5]
    year = date_str[6:]
    if not (month.isdigit() and day.isdigit() and year.isdigit()):
        return False
    if not (1 <= int(month) <= 12 and 1 <= int(day) <= 31 and len(year) == 4):
        return False
    return True

def main():
    name = input("Enter your full birth name: ").strip()
    while not name:
        name = input("Name cannot be empty. Please enter your full birth name: ").strip()

    dob = input("Enter your birth date (MM-DD-YYYY or MM/DD/YYYY): ").strip()
    while not validate_date_format(dob):
        dob = input("Invalid format. Please enter your birth date (MM-DD-YYYY or MM/DD/YYYY): ").strip()

    numerology = Numerology(name, dob)

    print(f"\nClient Name: {numerology.getName()}")
    print(f"Client Date Of Birth: {numerology.getBirthdate()}")
    print(f"Life Path: {numerology.getLifePath()}")
    print(f"Attitude: {numerology.getAttitude()}")
    print(f"Birth Day: {numerology.getBirthDay()}")
    print(f"Personality: {numerology.getPersonality()}")
    print(f"Power Name: {numerology.getPowerName()}")
    print(f"Soul: {numerology.getSoul()}")

main()
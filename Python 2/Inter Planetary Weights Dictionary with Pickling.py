print("###############################################")
print("######### INTER PLANETARY WEIGHTS AND #########")
print("#########   DICTIONARY AND PICKLING   #########")
print("#########                             #########")
print("######### CREATED BY: CARLOS BADILLO  #########")
print("###############################################")

import pickle
    # Creating a dictonary with planetary weight factors
dictPlanetaryWeights = {
    'Mercury': 0.38,
    'Venus': 0.91,
    'Moon': 0.165,
    'Mars': 0.38,
    'Jupiter': 2.34,
    'Saturn': 0.93,
    'Uranus': 0.92,
    'Neptune': 1.12,
    'Pluto': 0.066
}

def main():

    # Initialize the dictionary to store past weights (from the pickled file)
    dictPlanetHistory = {}

    # Try to load data from the pickled file if it exists
    try:
        with open('bcPlanetaryWeights.db', 'rb') as file:
            dictPlanetHistory = pickle.load(file)
    except FileNotFoundError:
        pass

    # Ask user if they want to see history
    sShowHistory = input("Would you like to see the history? (Y/y for yes, N/n for no): ").lower()
    if sShowHistory == 'y':
        if dictPlanetHistory:
            print("\nHistory of Previous Weights:")
            for sName, dictPersonWeights in dictPlanetHistory.items():
                print(f"\n{sName}'s Solar System's Weights:")
                for sPlanet, fWeight in dictPersonWeights.items():
                    print(f"Weight on {sPlanet + ':':10} {fWeight:10.2f}")
        else:
            print("No history found.") # No History Message


    # Requesting the user to enter the name desired
    while True:
        sName = input("\nWhat is your name (or press Enter to exit): ")
    # If they input is blank don't continue but stop the code
        if sName == "":
            break
        sName = sName.capitalize()
    # Checking in the dictPlanetHistory to see if that name already exists
        if sName in dictPlanetHistory:
            print("This name already exists. Please try another one.") # Duplicate Message
            continue
    # Checking to ensure that the input is valid for the numerical value
        while True:
            try:
                fEarthWeight = float(input(f"Enter the Earth weight for {sName}: "))
                break
            except ValueError:
                print("Invalid input. Please enter a valid number for Earth weight.") # Error message
        
        dictPersonWeights = {} # Empty Dictionary
        for sPlanet, fGravity in dictPlanetaryWeights.items():
            dictPersonWeights[sPlanet] = fEarthWeight * fGravity # Stringing the dictPersonWeights to be sPlanet and declaring the multiplication

        dictPlanetHistory[sName] = dictPersonWeights # Stringing the dictPlanetHistory to be sName

    with open('bcPlanetaryWeights.db', 'wb') as file:
        pickle.dump(dictPlanetHistory, file) # Dumping all information towards the dictPlanetHistory File

    # If the output is not different output the new information
    for sName, dictPersonWeights in dictPlanetHistory.items():
        print(f"\n{sName}'s here are your weights on our Solar System's planets:")
        for sPlanet, fWeight in dictPersonWeights.items():
            print(f"Weight on {sPlanet + ':':10} {fWeight:10.2f}")
main()

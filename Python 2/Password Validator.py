def vPassword(sPassword,sName):
    checking = 0
    if len(sPassword) < 8 or len(sPassword) > 12: # Checking the legnth of the password
        print("Password must be between 8 and 12 characters.")
    else:
        checking += 1
# Checking for duplicated test that it will catch
    if sPassword.lower().startswith("pass"):
        print("Password can’t start with 'Pass' or 'pass'") # Error message if the password contains 'Pass' or 'pass'
    else:
        checking += 1
# error message for Uppercase, Lowercase & Numbers
    errMsg = checking_c_l_n(sPassword)
    iL = len(errMsg)
    if errMsg == []:
        checking += 3
    else:
        for i in range(iL):
                print(f"{errMsg[i]}") # Prints out the error message of def checking_c_l_n(sPassword):

# Special Character Checker
    spec_Char = "!@#$%^" # list of all the special character
    sChar_Error = False
    for sChar in sPassword: # Checking the password to see if it has 1 of the special characters
        if sChar in spec_Char:
            sChar_Error = True
    if sChar_Error is False:
        print("Password must contain at least 1 of these special characters: ! @ # $ % ^") # Error massage if it doesn't include a special character
    else:
        checking += 1

# Checking the password for the Initials of the sName input
    sPassword = sPassword.lower()
    sInitials = sName[0] + sName[sName.find(" ") + 1] # Taking the initials from sName and spliting it
    if sPassword.find(sInitials.lower()[0]) == -1 or sPassword.find(sInitials.lower()[1]) == -1:
        checking += 1
    else:
        print("Password must not contain user initials.") # Error message if the initials are found

# Dictionary to checking how many characters of the same character
    cDic = {}
    Err = False
    for sChar in sPassword: # Checking the password 
        if sChar not in cDic:
            cDic[sChar] = 1 # Adding the characters to the dictionary
        else:
            cDic[sChar] += 1 # Tallying up the duplicates
            Err = True
    if Err is True:
        print("These characters appear more than once.")  # Error message to see if there is any duplicate tally
    else:
        checking += 1

    for i, num in cDic.items():
        if num > 1:
                print(f"{i}: {num} times") # Displaying the letter and total number
    return checking
   

def checking_c_l_n(sPassword): 
    errormsg = [] # Setting a list for displaying error messages
    sUpper = False
    sLower = False
    sNumber = False
    for sChar in sPassword: # Checking password for Uppercase, Lowercase & Numbers
        if sChar.isupper():  # Check for uppercase letter
            sUpper = True
        elif sChar.islower():  # Check for lowercase letter
            sLower = True
        elif sChar.isdigit():  # Check for number
            sNumber = True
    if not sUpper: # Adding them to the list
        errormsg.append("Password must contain at least 1 uppercase letter.") # Error message if the password doesn't have a uppercase letter
    if not sLower:
        errormsg.append("Password must contain at least 1 lowercase letter.") # Error message if the password doesn't have a lowercase letter
    if not sNumber:
        errormsg.append("Password must contain at least 1 number.") # Error message if the password doesn't have a number
    return errormsg
     

def main():
    # Declaring the name variable
    sName = input("\nWhat is your legal First and Last name: ") # Requesting the user to in put there legal name
    
    while True:
        try:
            sPassword = input("\nEnter your desired password: ")
            checking = vPassword(sPassword,sName)
            if checking == 8:
                print("Password is valid and OK to use.")
                break # leaves the while True
            else:
                continue # trying again till there is a valid password
        except:
                exit() # exeting the while true 
main()

# DATING_ACCEPTABLE_AGE = 14.5

# #1 Get 2 ages of partners:
# fPerson1 = float( input("What is person 1: ") )
# fPerson2 = float( input("What is person 2: ") )

# # Determine of morally acceptable age:

# if fPerson1 < DATING_ACCEPTABLE_AGE or  fPerson2 < DATING_ACCEPTABLE_AGE:
#     print("One or both of the persons is less than", DATING_ACCEPTABLE_AGE)
#     print("No way are we doing this.")
#     raise SystemExit 
    

# #2 Determine the lowest acceptable age:

# if fPerson1 == fPerson2:
#     print("The ages are equal so have fun!")
#     raise SystemExit

# if fPerson1 > fPerson2:
#     fOlder = fPerson1
#     fYounger = fPerson2
# else:
#     fOlder = fPerson2
#     fYounger = fPerson1
    
# #3 Find the lowest accdeptable age:
# fLowestAgeAcceptable = (fOlder / 2) + 7

# #4 Logical Compare

# if fYounger >= fLowestAgeAcceptable :
#     sMessage = "Someone is younger but the age gap is OK"
# else:
#     sMessage = "No way...too young...find someone else"
    
# #4 Output results
# print("The older age is:", fOlder)
# print("The younger age is:", fYounger)
# print("The absolute lowest age to date is:",fLowestAgeAcceptable) 
# print(sMessage)

fPerson1 = float(input("What is the age of Person #1: "))
fPerson2 = float(input("What is the age of Person #2: "))

ACEPTABLE_DATING_AGE = 14.5
# DETERMINE IF EITHER PERSON IS UNDER THE ACCEPTABLE AGE
if fPerson1 < ACEPTABLE_DATING_AGE or fPerson2 < ACEPTABLE_DATING_AGE:
    print("One or both of the persons is less than", ACEPTABLE_DATING_AGE)
    print("No way are we doing this.")
    raise SystemExit
elif fPerson1 == fPerson2:
    print("The ages are equal so have fun!")
    raise SystemExit
elif fPerson1 > fPerson2:
    fOlder = fPerson1
    fYounger = fPerson2
else:
    fOlder = fPerson2
    fYounger = fPerson1

# DETERMINE THE LOWEST ACCEPTABLE AGE
fLOWEST_AGE_ACEEPTABLE = (fOlder / 2) + 7
if fYounger >= fLOWEST_AGE_ACEEPTABLE:
    sMessage = "Someone is younger but the age gap is OK"
else:
    sMessage = "No way...too young...find someone else"
    
# OUTPUT RESULTS
print("The older age is:", fOlder)
print("The younger age is:", fYounger)
print("The absolute lowest age to date is:", fLOWEST_AGE_ACEEPTABLE)
print(sMessage)
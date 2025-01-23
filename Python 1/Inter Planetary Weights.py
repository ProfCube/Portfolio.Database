# Output if all request
Name = input('What is your name: ') # Name they want to be called.
Earth_Weight = float(input('What is your weight: ')) # Their weight.

print(Name, "here are your weights on our Solar System's planets:", )

# Calculations
SGF = \
[["Mercury", 0.38],
 ["Venus", 0.91],
 ["our Moon", 0.165],
 ["Mars", 0.38],
 ["Jupiter", 2.34],
 ["Saturn", 0.93],
 ["Uranus", 0.92],
 ["Neptune", 1.12],
 ["Pluto", 0.066]]

# End of OutPut
for planet,weight in SGF:
    print('Weight on {:10} {:>10.2f}'.format(planet+':', Earth_Weight*weight))

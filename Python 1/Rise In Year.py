# Everything xD
RISE_PER_YEAR = 1.6
FR = 0.0
FI = 0.0


print('Year\t\tRise(mm)\tRise (in)')
print('-----------------------------------------')

for Y in range(25):
    FR += RISE_PER_YEAR
    FI = FR * 0.039
    print((Y + 1), '\t\t', format(FR, '.2f'),'\t\t', format(FI, '.2f'))

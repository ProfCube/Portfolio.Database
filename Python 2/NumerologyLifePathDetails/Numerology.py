class Numerology:
    def __init__(self, name, dob):
        self.name = name.strip()
        self.dob = dob.strip()

        self.vowels = {'A', 'E', 'I', 'O', 'U'}

        # Mapping letters to numbers for numerology
        self.letter_values = {
            'A': 1, 'J': 1, 'S': 1,
            'B': 2, 'K': 2, 'T': 2,
            'C': 3, 'L': 3, 'U': 3,
            'D': 4, 'M': 4, 'V': 4,
            'E': 5, 'N': 5, 'W': 5,
            'F': 6, 'O': 6, 'X': 6,
            'G': 7, 'P': 7, 'Y': 7,
            'H': 8, 'Q': 8, 'Z': 8,
            'I': 9, 'R': 9
        }

    def _reduce(self, number):
        while number > 9 and number not in (11, 22, 33):
            number = sum(int(digit) for digit in str(number))
        return number

    @property
    def Name(self):
        return self.name

    @property
    def Birthdate(self):
        return self.dob

    @property
    def LifePath(self):
        digits = [int(char) for char in self.dob if char.isdigit()]
        return self._reduce(sum(digits))

    @property
    def BirthDay(self):
        parts = self.dob.replace('/', '-').split('-')
        day = int(parts[1])
        return self._reduce(day)

    @property
    def Attitude(self):
        parts = self.dob.replace('/', '-').split('-')
        month = int(parts[0])
        day = int(parts[1])
        return self._reduce(month + day)

    def _calculate_name_number(self, use_vowels=None):
        total = 0
        for char in self.name.upper():
            if char.isalpha():
                if use_vowels is None:
                    total += self.letter_values.get(char, 0)
                elif (char in self.vowels) == use_vowels:
                    total += self.letter_values.get(char, 0)
        return self._reduce(total)

    @property
    def Soul(self):
        return self._calculate_name_number(use_vowels=True)

    @property
    def Personality(self):
        return self._calculate_name_number(use_vowels=False)

    @property
    def PowerName(self):
        return self._reduce(self.Soul + self.Personality)
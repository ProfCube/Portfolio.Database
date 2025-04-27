class Numerology:
    def __init__(self, sName, sDOB):
        self.name = sName.strip()
        self.dob = sDOB.strip()
        self.vowel_set = {'A', 'E', 'I', 'O', 'U'}
        self.letter_to_number = {
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

    def getName(self):
        return self.name

    def getBirthdate(self):
        return self.dob

    def _reduce_number(self, num):
        while num > 9:
            num = sum(int(d) for d in str(num))
        return num

    def getLifePath(self):
        digits = [int(ch) for ch in self.dob if ch.isdigit()]
        return self._reduce_number(sum(digits))

    def getBirthDay(self):
        parts = self.dob.replace('/', '-').split('-')
        day = int(parts[1])
        return self._reduce_number(day)

    def getAttitude(self):
        parts = self.dob.replace('/', '-').split('-')
        month = int(parts[0])
        day = int(parts[1])
        return self._reduce_number(month + day)

    def _name_to_numbers(self, use_vowels=None):
        total = 0
        for char in self.name.upper():
            if char.isalpha():
                if use_vowels is None:
                    total += self.letter_to_number.get(char, 0)
                elif (char in self.vowel_set) == use_vowels:
                    total += self.letter_to_number.get(char, 0)
        return self._reduce_number(total)

    def getSoul(self):
        return self._name_to_numbers(use_vowels=True)

    def getPersonality(self):
        return self._name_to_numbers(use_vowels=False)

    def getPowerName(self):
        soul = self.getSoul()
        personality = self.getPersonality()
        return self._reduce_number(soul + personality)
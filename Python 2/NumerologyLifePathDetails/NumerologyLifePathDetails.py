from Numerology import Numerology

class NumerologyLifePathDetails(Numerology):
    def __init__(self, name, dob):
        super().__init__(name, dob)

    @property
    def LifePathDescription(self):
        meanings = {
            1: "The Independent: Wants to work/think for themselves",
            2: "The Mediator: Avoids conflict and wants love and harmony",
            3: "The Performer: Likes music, art, and to be seen or heard",
            4: "The Teacher: Values truth and is often a guide to others",
            5: "The Adventurer: Loves freedom, travel, and meeting new people",
            6: "The Inner Child: Nurturing, loving, and family-oriented",
            7: "The Naturalist: Drawn to nature, spirituality, and deeper meanings",
            8: "The Executive: Ambitious, with an eye for power and success",
            9: "The Humanitarian: Feels deeply and often helps others"
        }
        return meanings.get(self.LifePath, "No description available.")

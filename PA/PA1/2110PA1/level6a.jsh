String[] options = {"apple", "banana", "car", "orange"}
int[] answers = {2, 1, 4}
MRQ mrq = new MRQ("Pick the fruits.", options, answers)
mrq.answer(4)
mrq.answer(4).answer(3)
mrq.answer(4).answer(3).answer(4)
mrq
/exit
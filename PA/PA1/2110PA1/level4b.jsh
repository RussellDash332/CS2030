Question q = new FillInBlank("Snow white and the ? dwarfs", 7)
q.answer(3)
q.answer(3).answer(4)
q.answer(3).answer(7).lock()
q.answer(3).answer(7).lock().answer(5)
q.answer(3).answer(7).mark()
q.answer(3).answer(7).lock().mark()
q.answer(3).answer(7) instanceof FillInBlank
q.answer(3).answer(7).lock() instanceof FillInBlank
q.mark()
q = new MCQ("Colour of orange?", new String[]{"red", "green", "blue", "orange"}, 4)
q.mark()
q.answer(4).mark()
q.answer(4).lock().answer(3)
q.answer(4).lock().mark()
q.answer(4).answer(3)
q.answer(4).answer(3) instanceof MCQ
q.answer(4).answer(3).lock() instanceof MCQ
q = new TFQ("An orange is blue.", "False")
q.mark()
q.answer(1).mark()
q.answer(1).lock().answer(2)
q.answer(1).lock().mark()
q.answer(1).answer(2)
q.answer(1).answer(2) instanceof TFQ
q.answer(1).answer(2).lock() instanceof TFQ
/exit
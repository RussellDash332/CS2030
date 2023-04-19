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
/exit
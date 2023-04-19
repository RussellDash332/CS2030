Rand.of(2030) instanceof Rand == true;
Rand.of(2030).get() == 2030
Rand.of(2030).next() instanceof Rand == true
Rand.of(2030).next().get() == 1327734301
Rand.of(2030).next().next().get() == 1503777125
Rand r = Rand.of(2030)
r.get()
r.next().get()
r.get()
r.next().next().get()
r.get()
/exit
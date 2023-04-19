Pager p1 = new Pager("pager1")
Transmitter r1 = new Transmitter("transmit1")
p1.snd(r1)
p1.snd(r1).equals(r1)
Host h1 = r1
new Host()
p1.snd(r1).equals(h1)
r1.equals(h1)
h1.equals(p1)
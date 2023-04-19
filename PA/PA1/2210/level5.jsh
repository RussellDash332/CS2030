Pager p1 = new Pager("pager1")
Transmitter r1 = new Transmitter("transmit1")
p1.snd(r1)
p1.snd(r1).rcv().ack()
Pager p2 = new Pager("pager2")
Host h1 = p2.snd(p1.snd(r1).rcv().ack()).rcv().ack()
Host h2 = p2.snd(r1).rcv().ack()
h1.broadcast()
h2.broadcast()
p1.snd(r1).broadcast() // p1 has yet to establish connection
p1.snd(r1).rcv().ack().broadcast() // p1 has established connection
p2.snd(p1.snd(r1).rcv().ack()).broadcast() // p2 has yet to establish connection after p1
p2.snd(p1.snd(r1)).rcv().ack()
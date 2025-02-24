Functle<Terrapin> t = Functle.<Terrapin>of().forward(100).right(1)
t.andThen(t).run(new Terrapin())
t.andThen(t).reverse().run(new Terrapin())
t.andThen(t.reverse()).run(new Terrapin())

t.loop(2).run(new Terrapin())
t.loop(4).run(new Terrapin())
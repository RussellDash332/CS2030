Operator<Integer> add = Operator.<Integer>of((x, y) -> {
    System.out.println("#");
    return x + y;
}, 4)
Operator<Integer> mul = Operator.<Integer>of((x, y) -> {
    System.out.println("#");
    return x * y;
}, 3)
Expr.<Integer>of(2).op(mul, 3).op(add, 4).op(mul, 5)
Expr.<Integer>of(2).op(mul, 3).op(add, 4).op(mul, 5).hashCode() != 0
Expr.<Integer>of(2).op(mul, Expr.of(3).op(add, 4)).op(mul, 5)
Expr.<Integer>of(2).op(mul, Expr.of(3).op(add, 4)).op(mul, 5).hashCode() != 0
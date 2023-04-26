int sum = 0

int doSomething(int x) {
    return sum + x * x;
}

for (int i = 0; i < 10; i++) {
    sum = doSomething(i);
}

sum
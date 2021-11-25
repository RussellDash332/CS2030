int[][][] grid = new int[6][3][3]
int d = 1
for (int k = 0; k < 6; k++)
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) grid[k][i][j] = d++;
Rubik rubik = new RubikFront(grid);
new RubikUp(rubik).left()
new RubikUp(rubik).right()
new RubikUp(rubik).half()
new RubikRight(rubik).left()
new RubikRight(rubik).right()
new RubikRight(rubik).half()
new RubikDown(rubik).left()
new RubikDown(rubik).right()
new RubikDown(rubik).half()
new RubikLeft(rubik).left()
new RubikLeft(rubik).right()
new RubikLeft(rubik).half()
new RubikBack(rubik).left()
new RubikBack(rubik).right()
new RubikBack(rubik).half()
/exit

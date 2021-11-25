int[][][] grid = new int[6][3][3]
int d = 1
for (int k = 0; k < 6; k++)
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) grid[k][i][j] = d++;
Rubik r = new Rubik(grid)
Rubik r = new RubikFront(grid)
Rubik s = r.clone();
Cloneable c = s
c.clone()
r.left()
r.right()
r.half()
s
/exit

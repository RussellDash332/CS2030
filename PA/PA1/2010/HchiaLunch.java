class HchiaLunch implements Constraint {
    private static final int LUNCH_TIME = 14;

    @Override
    public boolean test(Schedule schedule) {
        for (Class c : schedule) {
            if (c.overlapping(LUNCH_TIME, 2)) {
                return false;
            }
        }
        return true;
    }
}

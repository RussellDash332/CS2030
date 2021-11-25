class GapBetweenLectures implements Constraint {
    private static final int GAP_DURATION = 1;

    @Override
    public boolean test(Schedule s) {
        for (Class c1 : s) {
            for (Class c2 : s) {
                if (c1 != c2 && c1.hasSameModule(c2) && !c1.haveGap(GAP_DURATION, c2) && 
                        c1 instanceof Lecture && c2 instanceof Lecture) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Class implements Comparable<Class> {
    private final String code;
    private final int id;
    private final String venue;
    private final int startTime;
    private final Instructor instructor;
    private final int duration;
    private final String abbrev;
    private static final int THREE = 3;

    Class(String code, int id, String venue, Instructor instructor, 
            int startTime, int duration, String abbrev) {
        this.code = code;
        this.id = id;
        this.venue = venue;
        this.instructor = instructor;
        this.startTime = startTime;
        this.duration = duration;
        this.abbrev = abbrev;
    }

    boolean hasSameModule(Class o) {
        return this.code.equals(o.code);
    }

    boolean hasSameInstructor(Class o) {
        return this.instructor.equals(o.instructor);
    }

    boolean hasSameVenue(Class o) {
        return this.venue.equals(o.venue);
    }

    public boolean overlapping(int x1, int x2) {
        int maxX = x1 + x2;
        int y1 = this.startTime;
        int y2 = this.duration;
        int maxY = y1 + y2;
        return (maxY <= maxX && maxY > x1) || (maxX <= maxY && maxX > y1);
    }

    public boolean haveGap(int d, Class o) {
        if (this.startTime + this.duration <= o.startTime) {
            return o.startTime - (this.startTime + this.duration) >= d;
        } else {
            return this.startTime - (o.startTime + o.duration) >= d;
        }
    }

    boolean clashWith(Class o) {
        if (this.code != o.code) {
            return ((this.venue.equals(o.venue) || this.instructor.equals(o.instructor)) && 
                    this.overlapping(o.startTime, o.duration));
        } else {
            if (this.duration == 1 && o.duration == 1 && this.startTime == o.startTime) {
                return (this.instructor.equals(o.instructor) || this.venue.equals(o.venue));
            } else {
                return this.overlapping(o.startTime, o.duration);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s%d @ %s [%s] %d--%d", this.code, this.abbrev, this.id, 
                this.venue, this.instructor, this.startTime, this.startTime + this.duration);
    }

    @Override
    public int compareTo(Class o) {
        if (this.startTime != o.startTime) {
            return this.startTime - o.startTime;
        } else if (this.duration != o.duration) {
            return this.duration - o.duration;
        } else if (this.code != o.code) {
            return this.code.compareTo(o.code);
        } else if (this.id != o.id) {
            return this.id - o.id;
        } else {
            return this.instructor.toString().compareTo(o.instructor.toString());
        }
    }
}

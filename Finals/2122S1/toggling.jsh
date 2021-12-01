void toggling(TrafficLight t, int n) { // toggle n times
    System.out.print(t);
    for (int i = 1; i < n; i++) {
        t = t.toggle();
        System.out.print(" -> " + t);
    }
    System.out.println();
}
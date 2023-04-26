<T extends Comparable<T>> T processList(List<T> list) {
    T max = null;
    try {
        max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
    } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
        return max;
    }
    return max;
}
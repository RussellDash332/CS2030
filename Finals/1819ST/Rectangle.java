class Rectangle { 
    private int width; 
    private int height;

    public Rectangle(int height, int width) { 
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        String top = "+" + "-".repeat(width - 2) + "+";
        String side = "|" + " ".repeat(width - 2) + "|\n";
        return top + "\n" + side.repeat(height - 2) + top;
    }
}
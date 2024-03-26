class City {
    int x, y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(City other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
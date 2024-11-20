public enum Direction {
    NORTH(2),SOUTH(0),EAST(3),WEST(1);
    private int frameLineNumber;

    Direction(int frameLineNumber) {
        this.frameLineNumber = frameLineNumber;
    }

    /**
     * Renvoie le numéro de ligne de cadre associé à la direction
     * @return
     */
    public int getFrameLineNumber() {
        return frameLineNumber;
    }
}

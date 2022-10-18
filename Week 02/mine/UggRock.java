public class UggRock {
    private UggRockType rockType;
    private UggRockSize rockSize;

    public UggRockType getRockType() {
        return rockType;
    }

    public UggRockSize getRockSize() {
        return rockSize;
    }

    @Override
    public String toString() {
        return this.rockSize + "bigun, " + this.rockType;
    }

    public UggRock(UggRockType _rockType, UggRockSize _rockSize) {
        rockType = _rockType;
        rockSize = _rockSize;
    }
}

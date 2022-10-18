public enum UggRockSize {
    quite(3),
    notso(1),
    EMPTY(5);

    private short multiplierValue;


//    private UggRockSize size;
//
//    UggRockSize(UggRockSize s, short mv) {
//        this.size = s;
//        this.multiplierValue = mv;
//    }
//

    private UggRockSize(Integer i) {
        this.multiplierValue = i.shortValue();
    }

    public short getMultiplierValue() {
        return multiplierValue;
    }

//    UggRockSize() {
//        if (this.toString() == "quite") {
//            this.multiplierValue = 3;
//        } else if (this.toString() == "notso") {
//            this.multiplierValue = 1;
//        } else {
//            this.multiplierValue = 5;
//        }
//    }


    @Override
    public String toString() {
        return this == EMPTY ? "" : super.toString() + "-";
    }

}

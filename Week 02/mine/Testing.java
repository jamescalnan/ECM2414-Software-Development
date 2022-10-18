

public class Testing {

    public static void main(String[] args) {
        UggRock test = new UggRock(UggRockType.floaty, UggRockSize.EMPTY);

        System.out.println(test);

        System.out.println(test.getRockSize().getMultiplierValue());

    }

}

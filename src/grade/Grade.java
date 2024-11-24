package grade;

import shared.exceptions.exceptions.NotValidInputException;

import java.util.Arrays;

public enum Grade {
    MEDAL_OF_HONOR(1, "국가 유공자", 10),
    SOLDIER(2, "군인", 5),
    STUDENT(3, "학생", 3),
    STANDARD(4, "일반", 0),
    HIDE_ON_BUSH(5, "고전파", 99),
    ;

    private final int index;
    private final String name;
    private final int ratio;

    Grade(int index, String name, int ratio) {
        this.index = index;
        this.name = name;
        this.ratio = ratio;
    }

    public static int getDiscountRatio(int commandInput) {
        return Arrays.stream(values())
                .filter(e -> e.index == commandInput)
                .findFirst()
                .map(Grade::getRatio)
                .orElseThrow(NotValidInputException::new);
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getRatio() {
        return this.ratio;
    }

    public static int getLength() {
        return values().length;
    }
}

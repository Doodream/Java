public class UnitConverter {
    // 필요한 상수 정의
    public static final double KILOGRAMS_PER_POUND = 1 / 0.45359237;
    public static final double POUNDS_PER_KILOGRAM = 0.45359237;
    public static final double CENTIMETERS_PER_INCH = 1 / 2.54;
    public static final double INCHES_PER_CENTIMETER = 2.54;



    private UnitConverter(){
    }
    public static double toPounds(double kilograms) {
        return kilograms * KILOGRAMS_PER_POUND;
        // 메소드 내부를 채워주세요
    }
    public static double toKilograms(double pounds) {
        return pounds * POUNDS_PER_KILOGRAM;
        // 메소드 내부를 채워주세요
    }
    public static double toCentimeters(double inches) {
        // 메소드 내부를 채워주세요
        return inches * INCHES_PER_CENTIMETER;
    }
    public static double toInches(double centimeters) {
        // 메소드 내부를 채워주세요
        return centimeters * CENTIMETERS_PER_INCH;
    }
    public static double toFahrenheit(double celsius) {
        double answer = celsius * (9.0 / 5.0) + 32;
        return answer;
        // 메소드 내부를 채워주세요
    }
    public static double toCelsius(double fahrenheit) {
        // 메소드 내부를 채워주세요
        return ((fahrenheit - 32) * (5.0 / 9.0));
    }
}
public class Calc {

    private static double x = 1.5;
    private static double y = 3.7;

    public static double calculate(double x, double y, ICalculator score) {
        return score.executeOperation();
    }

    public static void main(String[] args) {

        ICalculator addition = () -> x + y;
        System.out.println("Сложение:  " + x + " + " + y + " = " + (Calc.calculate(x, y, addition)));


        ICalculator multiplication = () -> x * y;
        System.out.println("Умножение: " + x + " * " + y + " = " + (Calc.calculate(x, y, multiplication)));


        ICalculator division = () -> x / y;
        System.out.println("Деление:   " + x + " / " + y + " = " + (Calc.calculate(x, y, division)));


        ICalculator selectMax = () -> (Math.max(x, y));
        System.out.println("Выбор максимального: " + x + " или " + y + " max: " + (Calc.calculate(x, y, selectMax)));


        ICalculator expression = () -> {
            if (x > y) {
                return ((Math.pow(y, (x - y)) * 10) / x);
            } else {
                return ((Math.pow(x, (y - x)) * 10) / y);
            }
        };
        System.out.println("Результат выражения: ((min^(max-min))*10)/max =  " + (Calc.calculate(x, y, expression)));


        ICalculator modulusOfDifference = () -> (Math.abs((x - y)));
        System.out.println("Модуль разности:     " + x + " и " + y + " = " + (Calc.calculate(x, y, modulusOfDifference)));


        ICalculator roundingSum = () -> (Math.ceil(x + y));
        System.out.println("Округление суммы в большую сторону:   " + x + " и " + y + " = " + (Calc.calculate(x, y, roundingSum)));

    }

}

@FunctionalInterface
interface ICalculator {
    //Выполнить операцию
    double executeOperation();
}
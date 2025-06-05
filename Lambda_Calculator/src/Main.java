public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        // Ошибка возникнет по той причине, что мы делим на 0, что является математической ошибкой, поэтому мы получаем ArithmeticException
        // Реализация решения в калькуляторе

        int c = calc.divide.apply(a, b);

        calc.println.accept(c);

    }

}
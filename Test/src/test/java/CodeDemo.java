public class CodeDemo {

    public static void main(String[] args) {
        System.out.println(CodeDemo.calculate(4));
        System.out.println(CodeDemo.calculate(9));
        System.out.println(CodeDemo.calculate(7));
    }

    public static int calculate(int number) {
        if (number % 2 == 0) {
            return number * 2;
        } else if (number % 3 == 0) {
            return number * 3;
        } else {
            return number * 5;
        }
    }
}

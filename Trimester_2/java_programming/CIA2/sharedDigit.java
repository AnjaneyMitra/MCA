public class sharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 >= 10 && num1 <= 99 && num2 >= 10 && num2 <= 99) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int tempNum1 = num1 / 10;
            int tempNum2 = num2 / 10;
            
            return (digit1 == digit2 || digit1 == tempNum2 || tempNum1 == digit2 || tempNum1 == tempNum2);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean result = hasSharedDigit(11, 23);
        System.out.println(result);
    }
}

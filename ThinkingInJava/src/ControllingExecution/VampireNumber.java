package ControllingExecution;

public class VampireNumber {

    static boolean isVampireNumber(int firstNumber, int secondNumber) {
        Integer result = firstNumber * secondNumber;
        if(result<1000 || result>9999)
            return false;
        int[] positionVector = new int[10];
        while (result > 0) {
            positionVector[result % 10]++;
            result /= 10;
        }
        if (positionVector[firstNumber % 10] == 1 && positionVector[firstNumber / 10 % 10] == 1
                && positionVector[secondNumber % 10] == 1 && positionVector[secondNumber / 10 % 10] == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        for (int firstNumber = 10; firstNumber < 100; firstNumber++) {
            for (int secondNumber = firstNumber+1; secondNumber < 100; secondNumber++) {
                if (isVampireNumber(firstNumber, secondNumber)) {
                    System.out.println(firstNumber * secondNumber);
                }
            }
        }
    }
}

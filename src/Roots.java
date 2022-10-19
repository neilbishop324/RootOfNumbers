import java.util.Scanner;

class Roots {

    // Z ints
    static int x = 2;
    static int indexZ;
    static int innerI, outerI;
    static int innerM = 1, outerM = 1;

    // Q ints numerator
    static int numerator;
    static int numerIn = 1, numerOut = 1;
    static int y = 2;
    static int indexQ;
    static int numerInI, numerOutI;

    // Q ints denominator
    static int denominator;
    static int denomPow = 0;
    static int denomIn, denomOut;

    static boolean isPos(int it) {return it > 0;}
    static boolean isVisib(int it) {return it != 1;}

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: √ ");
        double number = input.nextDouble();

        System.out.print("Enter a root number : ");
        int root = input.nextInt();

        printCtrls(number, root);

        input.close();

    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }

    static void printCtrls(double number, int root) {
        boolean firstRoot = root == 2;

        //if number is rational
        if (number % 1 != 0) {
            isRational(number, root);
        }
        ////if number is integer
        else {
            isInt(number, root);
        }

        System.out.println(firstRoot ? "" : " (" + root + ")");
    }

    static void isRational(double number, int root) {
        for (; number % 1 != 0; denomPow++) {
            number *= 10;
        }

        numerator = (int) number;
        denominator = (int) Math.pow(10, denomPow);

        if (number < 0 && root % 2 == 0) {
            System.out.println("An even root cannot take a negative value!");
            return;
        }
        
        if (root < 1) {
            System.out.println("A root number can not be less than 1!");
            return;
        }

        if (root == 1) {
            System.out.println("Result : " + numerator + " / " + denominator);
            return;
        }

        while (true) {
            indexQ = 0;

            if (numerator != 1) { break; }

            for (; numerator % y != 0; y++) {}

            for (; numerator % y == 0; indexQ++) {
                numerator /= y;
            }

            numerOutI = (indexQ >= root) ? indexQ / root : 0;
            numerInI = (indexQ >= root) ? indexQ % root : indexQ;

            numerIn *= Math.pow(y, numerInI);
            numerOut *= Math.pow(y, numerOutI);

            y++;

            if (Math.abs(numerator) == 1) { break; }
        }

        denomIn = (int) Math.pow(10, denomPow % root);
        denomOut = (int) Math.pow(10, (float) denomPow / root);

        int outGCD = findGCD(numerOut, denomOut);
        int inGCD = findGCD(numerIn, denomIn);

        numerOut /= outGCD;
        denomOut /= outGCD;
        numerIn /= inGCD;
        denomIn /= inGCD;

        System.out.print("Result : ");

        System.out.print(
            ((isPos(numerator)) ? "" : "- ") +
            ((isVisib(numerOut)) ? numerOut : "") +
            ((isVisib(numerIn)) ? " √ " + numerIn : "") +
            (((isPos(numerator)) || (isVisib(numerOut)) || (isVisib(numerIn))) ? " / " : "1 / ") +
            ((isVisib(denomOut)) ? denomOut : "") +
            ((isVisib(denomIn)) ? " √ " + denomIn : "")
        );
    }

    static void isInt(double number, int root) {
        int wholeNum = (int) Math.round(number);

        if ((wholeNum == 0) || (wholeNum == 1)) {
            System.out.println("Result : " + wholeNum);
            return;
        } 

        if (wholeNum < 0 && root % 2 == 0) {
            System.out.println("An even root cannot take a negative value!");
            return;
        } 

        if (root < 1) {
            System.out.println("A root number can not be less than 1!");
            return;
        }
        
        if (root == 1) {
            System.out.println("Result : " + wholeNum);
            return;
        }

        while (true) {
            indexZ = 0;

            for (; wholeNum % x != 0; x++) {}

            for (; wholeNum % x == 0; indexZ++) {
                wholeNum /= x;
            }
            
            outerI = (indexZ >= root) ? indexZ / root : 0;
            innerI = (indexZ >= root) ? indexZ % root : indexZ;

            innerM *= Math.pow(x, innerI);
            outerM *= Math.pow(x, outerI);

            x++;

            if (Math.abs(wholeNum) == 1) { break; }
        }

        System.out.print("Result : ");

        System.out.print(
            ((isPos(wholeNum) ? "" : "- ")) +
            ((isVisib(outerM) ? outerM : "")) +
            ((isVisib(innerM) ? " √ " + innerM : ""))
        );
    }

}
package java_core.homework.assignment5.exercise2.question4;

public class Program {
    public static void main(String[] args) {
        MyMath math = new MyMath();

        int intResult = math.sum(10, 25);
        System.out.println("Sum (int): 10 + 25 = " + intResult);

        byte byteA = 5;
        byte byteB = 7;
        byte byteResult = math.sum(byteA, byteB);
        System.out.println("Sum (byte): " + byteA + " + " + byteB + " = " + byteResult);

        float floatResult = math.sum(3.14f, 2.86f);
        System.out.println("Sum (float): 3.14 + 2.86 = " + floatResult);

        System.out.println("\nDemo overloading:");
        System.out.println("math.sum(100, 200)          -> " + math.sum(100, 200));           // gọi int
        System.out.println("math.sum((byte) 10, (byte) 20) -> " + math.sum((byte) 10, (byte) 20)); // gọi byte
        System.out.println("math.sum(1.5f, 2.5f)        -> " + math.sum(1.5f, 2.5f));       // gọi float
    }
}
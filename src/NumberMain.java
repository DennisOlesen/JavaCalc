import math.NumberConverter;


public class NumberMain {

    public static void main(String[] args) {
        NumberConverter nc1 = new NumberConverter(8);
        System.out.println("8 in decimal is " + nc1.toBinary() + " in binary.");
        
        NumberConverter nc2 = new NumberConverter(1000);
        System.out.println("1000 in binary is " + nc2.toDecimal() + " in decimal.");
    }
    
}

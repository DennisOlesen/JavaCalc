package math;

public class NumberConverter {
    
    private final int number;
    
    /**
     * Constructs a NumberConverter.
     * 
     * It let's you define a number that can have any base. You just have to
     * remember which base it is, since the methods doesn't care for the numbers
     * actual base.
     * 
     * @param   number  This can be any base.
     */
    public NumberConverter(final int number) {
        this.number = number;
    }
    
    /**
     * Convert a decimal number to a binary number.
     * 
     * @return  binary  String
     */
    public String toBinary() {
        StringBuilder binary = new StringBuilder();
        int n = this.number;
        
        while (n != 0) {
            binary.append(n % 2);
            n /= 2;
        }
        
        return binary.toString();
    }
    
    /**
     * Convert a binary number to a decimal number.
     * 
     * @return  decimal String
     */
    public String toDecimal() {
        StringBuilder decimal = new StringBuilder();
        int n = this.number;
        
        for (int i = 0; i < Integer.toString(n).length(); i++) {
            decimal.append(Math.pow(n % 10, i));
            n /= 10;
        }
        
        return decimal.toString();
    }
    
}

package math;

public class NumberConverter {
    
    private final int number;
    
    public NumberConverter(final int number) {
        this.number = number;
    }
    
    public String toBinary() {
        StringBuilder binary = new StringBuilder();
        int n = this.number;
        
        while (n != 0) {
            binary.append(n % 2);
            n /= 2;
        }
        
        return binary.toString();
    }
    
    public static String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        
        while (n != 0) {
            binary.append(n % 2);
            n /= 2;
        }
        
        return binary.toString();
    }
    
}

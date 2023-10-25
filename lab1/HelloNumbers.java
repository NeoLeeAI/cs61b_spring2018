public class HelloNumbers {
    public static void main(String[] args) {
        int x = 1;
        int y = 0;
        while (x < 10) {
            y = x + y; 
            System.out.print(y + " ");
            x = x + 1;
        }
    }
}
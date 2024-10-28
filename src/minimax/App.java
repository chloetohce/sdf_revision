package minimax;

public class App {

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n -2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            System.out.println(fib(i));
        }
    }
    
}
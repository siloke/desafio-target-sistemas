package desafio;

public class Fibonacci {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        
        somaFibonacci(a, b, 144);
    }
    
    //Recebe o começo da sequência e o numero a encontrar na sequencia de Fibonacci.
    static int somaFibonacci(int a, int b, int num) {
       
        int soma = a + b;
        System.out.print(a + " ");
        if (a >= num){
            if (a == num) {
                System.out.println("\nExiste na sequência");
            }
            else {
                System.out.println("\nNão existe na sequência");
            }
            return a;
        }
        return somaFibonacci(b, soma, num);
        
    }
    
}

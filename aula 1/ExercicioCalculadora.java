import java.util.Scanner;

public class ExercicioCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a operação que vai utilizar: 1[+] 2[-] 3[*] 4[/]");
        String operacao = sc.nextLine();

        if(!operacao.matches("[+-/*]")){
            throw new IllegalArgumentException("A operação não é válida.");
        }
        
        System.out.println("Digite o primeiro número:");
        int var1 = sc.nextInt();

        System.out.println("Digite o segundo número:");
        int var2 = sc.nextInt();
        
        int resultado = 0;

        switch(operacao){
            case "+":
                resultado = var1+var2;
                break;
            case "-":
                resultado = var1-var2;
                break;
            case "*":
                resultado = var1*var2;
                break;
            case "/":
                resultado = var1/var2;
                break;
        }
        System.out.println("O resultado é:"+resultado);
        sc.close();
    }
}

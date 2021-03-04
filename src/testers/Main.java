package testers;

import java.io.IOException;
import java.util.Scanner;

/*public class Main {
	
    public static void main(String[] args) {
    	
    	System.out.println("Ingrese la cantidad de elementos del vector:");
        Scanner sc = new Scanner(System.in);
        int cantVector = sc.nextInt();
        int [] numeros=new int[cantVector];
    
        
        for (int i=0; i<(cantVector); i++){
        	System.out.println("Ingrese los elementos de a uno: ");
            numeros[i]=sc.nextInt();   
        }
        System.out.println("Cuantos elementos descarta desde el ultimo?");
        int k=sc.nextInt();
        
        for (int i=0; i<(cantVector-k); i++){
            System.out.print(numeros[i]);
        }
    }
}*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] numeros=new int[n];
    
        for (int i=0; i<(n); i++){
            numeros[i]=sc.nextInt();   
        }
        int k=sc.nextInt();
        for (int i=0; i<(n-k); i++){
            System.out.print(numeros[i]);
        }
    }
}
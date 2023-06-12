import java.util.*;

public class cuerdas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una cuerda: ");
        String temp = sc.nextLine();
        String teclado = "λ" + temp;
        System.out.println("Ingrese la instrucción deseada");
        System.out.println("-> p(Prefijos) \n-> s(Sufijos) \n-> sc(Subcuerdas) \n-> ss(Subsecuencias) \n-> e(Salir)");
        while(true) {
            System.out.print("Instrucción: ");
            String vand = sc.nextLine();
            switch (vand) {
                case "p":
                    System.out.println("\nLos prefijos para la cuerda '" + temp + "' son: ");
                    prefijos(teclado);
                    break; 
                case "s": 
                    System.out.println("\nLos sufijos para la cuerda '" + temp + "' son: ");
                    sufijos(teclado);
                    break;
                case "sc": 
                    System.out.println("\nLas subcuerdas para la cuerda '" + temp + "' son: ");
                    subcuerdas(teclado);
                    break;
                case "ss": 
                    System.out.println("\nLas subsecuencias para la cuerda '" + temp + "' son: ");
                    subsecuencias(temp);
                    break;
                case "e":
                    sc.close();
                    System.exit(-1);
            }
        }
    }

    public static void prefijos(String cuerda) {
        for (int i = cuerda.length(); i > 1; i--) {
            System.out.println("- " + cuerda.substring(1, i));
        }
        System.out.println("- " + cuerda.charAt(0) + "\nTotal de cuerdas: " + cuerda.length());
    }

    public static void sufijos(String cuerda) {
        for (int i = 1; i < cuerda.length(); i++) {
            System.out.println("- " + cuerda.substring(i));
        }
        System.out.println("- " + cuerda.charAt(0)+ "\nTotal de cuerdas: " + cuerda.length());
    }

    public static void subcuerdas(String cuerda) {
        System.out.println("- " + cuerda.charAt(0));
        for (int i = 1; i < cuerda.length(); i++) {
            for (int n = 1; n <= cuerda.length()-i; n++) {
                System.out.println("- " + cuerda.substring(n,n+i));
            }
        }
        int t = cuerda.length()-1;
        int total = (t*(t+1))/2;
        System.out.println("Total de cuerdas: " + (total+1));
    }

    public static void subsecuencias(String cuerda) {
        System.out.println("- λ");
        List<String> subse = getSubsecuencia(cuerda);
        int total = (int)(Math.pow(2, cuerda.length()));
        for (int c = 0; c < total-1; c++) {
            System.out.println("- " + subse.get(c));
        }
        System.out.println("Total de cuerdas: " + total);
    }

    public static List<String> getSubsecuencia(String secuencia) {
        List<String> subsecuencia = new ArrayList<>();
        generador(secuencia, 0, "", subsecuencia);
        return subsecuencia;
    }

    public static void generador(String secuencia, int n, String cuerda, List<String> subse) {
        if (n == secuencia.length()) {
            subse.add(cuerda);
            return;
        }

        generador(secuencia, n+1, cuerda + secuencia.charAt(n), subse);
        generador(secuencia, n+1, cuerda, subse);
    }
}
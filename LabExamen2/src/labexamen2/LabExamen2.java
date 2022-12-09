package labexamen2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class LabExamen2 {

    public static Scanner rm = new Scanner(System.in);
    public static Scanner vini = new Scanner(System.in);

    public static void main(String[] args) {
        juego();
    }

    public static void juego() {
        String nomgranja = JOptionPane.showInputDialog("Ingrese nombre de la granja: ");
        Granja granja = new Granja(nomgranja);
        System.out.println("Bienvenido a la granja: " + granja.nombre);
        boolean fin = true;
        int dia = 0;
        int diascosecha = -1;
        int plantas = 0;
        boolean cosechar = false;
        while (fin) {
            dia++;
            System.out.println("<------------------ Dia: " + dia + " ------------------>");
            if (diascosecha <= 0) {
                System.out.println("No hay cosechas");
            } else {
                System.out.println("Faltan " + diascosecha + " para que esten listas las cosechas!");
            }
            System.out.println("""
                               Que desa hacer
                               1.- Plantar Cosechas
                               2.- Cosechar las cosechas
                               3.- Conseguir animales
                               4.- Vender Cosas
                               5.- Dormir
                               6.- Adios mundo""");
            int opc = vini.nextInt();
            switch (opc) {
                case 1:
                    if (diascosecha <= 0) {
                        System.out.println("Cuantas plantas va a cosechar?");
                        plantas = vini.nextInt();
                        System.out.println("PLANTANDO COSECHAS...");
                        System.out.println("Las cosechas tardan 5 dias en estar");
                        diascosecha = 5;
                    } else {
                        System.out.println("Aun no puede plantar");
                    }
                    break;

                case 2:
                    if (cosechar) {
                        System.out.println("Plantas cosechadas!");
                        granja.addVegetales(plantas);
                        cosechar = false;
                    } else {
                        System.out.println("Aun no has plantado cosechas o no estan listas las cosechas");
                    }
                    break;

                case 3:
                    System.out.println("Cantidad de dinero actual: " + granja.dinero);
                    if (granja.dinero >= 150) {
                        System.out.println("Que animales desa?\n"
                                + "1.- Conejos -> 150 monets\n"
                                + "2.- Vacas -> 350 monets");
                        int animal = vini.nextInt();
                        if (animal == 1) {
                            System.out.println("Cuantos Conejos Desea?");
                            int cantAni = vini.nextInt();
                            int total = 150 * cantAni;
                            if (total <= granja.dinero) {
                                System.out.println("Conejos Comprados $$$");
                                granja.dinero -= total;
                                for (int i = 0; i < cantAni; i++) {
                                    System.out.println("Ingrese el nombre de su nuevo conejo: ");
                                    String nombre = rm.nextLine();
                                    Conejo conejo = new Conejo(nombre, 170);
                                    granja.addConejos(conejo);
                                    System.out.println(nombre + " Ha sido enviada a la granja!");
                                }
                            } else {
                                System.out.println("Dinero insuficiente");
                            }
                        } else if (animal == 2 && granja.dinero >= 350) {
                            System.out.println("Cuantas Vacas Desea?");
                            int cantAni = vini.nextInt();
                            int total = 350 * cantAni;
                            if (total <= granja.dinero) {
                                System.out.println("Vacas Compradas $$$");
                                granja.dinero -= total;
                                for (int i = 0; i < cantAni; i++) {
                                    System.out.println("Ingrese el nombre de su nueva vaca: ");
                                    String nombre = rm.nextLine();
                                    Vaca vaca = new Vaca(nombre, 400);
                                    granja.addVaca(vaca);
                                    System.out.println(nombre + " Ha sido enviada a la granja!");
                                }
                            } else {
                                System.out.println("Dinero insuficiente");
                            }
                        } else {
                            System.out.println("Dinero insuficiente");
                        }
                    } else {
                        System.out.println("Dinero insuficiente para realizar una compra");
                    }
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.dinero + " monets");

                    break;
                case 4:
                    System.out.println("Que deseas vender?");
                    granja.printGranja();
                    System.out.println("""
                                       Seleccione
                                       1.- Vegetales
                                       2.- Conejos
                                       3.- Vacas""");
                    int opcAni = vini.nextInt();
                    switch (opcAni) {
                        case 1:
                            System.out.println("Ingrese la cantidad a vender");
                            int cantVend = vini.nextInt();
                            if (cantVend <= granja.vegetales.size()) {
                                for (int i = 0; i < cantVend; i++) {
                                    granja.vegetales.remove(0);
                                }
                                granja.dinero += (cantVend * 100);
                            } else {
                                System.out.println("NO TIENES NADA QUE VENDER AQUI");
                            }
                            break;

                        case 2:
                            granja.printConejos();
                            System.out.println("Ingrese la cantidad a vender");
                            int cantVende = vini.nextInt();
                            if (cantVende <= granja.conejos.size()) {
                                for (int i = 0; i < cantVende; i++) {
                                    System.out.println("Bye Bye "+granja.conejos.get(0).getNombre());
                                    granja.conejos.remove(0);
                                }
                                System.out.println("Se han vendido "+cantVende+" conejos");
                                granja.dinero += (cantVende * 170);
                            } else {
                                System.out.println("NO TIENES NADA QUE VENDER AQUI");
                            }
                            break;

                        case 3:
                            granja.printVacas();
                            System.out.println("Ingrese la cantidad a vender");
                            int cantVender = vini.nextInt();
                            if (cantVender <= granja.conejos.size()) {
                                for (int i = 0; i < cantVender; i++) {
                                    System.out.println("Bye Bye "+granja.vacas.get(0).getNombre());
                                    granja.vacas.remove(0);
                                }
                                System.out.println("Se han vendido "+cantVender+" vacas");
                                granja.dinero += (cantVender * 400);
                            } else {
                                System.out.println("NO TIENES NADA QUE VENDER AQUI");
                            }
                            break;
                    }
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.dinero);
                    break;
                case 5:
                    System.out.println("Zzz Zzz Zzz");
                    break;
                case 6:
                    System.out.println("En el partido Holanda vrs Argentina tu apostaste 100,000 Monets que Argentina iba a perder pero claro Messi no fallo el penal"
                            + " y no tuvieste otra solucion que pegarte un tiro :(");
                    fin = false;
                    break;
            }
            diascosecha--;
            if (diascosecha == 0) {
                cosechar = true;
            }

            System.out.println("<------------------ Fin del Dia ------------------>");
        }
    }

}

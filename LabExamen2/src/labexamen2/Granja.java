package labexamen2;

import java.util.ArrayList;

public class Granja {

    public String nombre;
    public ArrayList<Vaca> vacas = new ArrayList<>();
    public ArrayList<Vegetal> vegetales = new ArrayList<>();
    public ArrayList<Conejo> conejos = new ArrayList<>();
    public int dinero;

    public Granja() {
    }

    public Granja(String nombre) {
        this.nombre = nombre;
        this.vacas = new ArrayList<>();
        this.conejos = new ArrayList<>();
        this.vegetales = new ArrayList<>();
        this.dinero = 500;
    }

    public void addVegetales(int plantas) {
        for (int i = 0; i < plantas; i++) {
            Vegetal vege = new Vegetal();
            vegetales.add(vege);
        }
    }

    public void addVaca(Vaca vaca) {
        vacas.add(vaca);
    }

    public void addConejos(Conejo conejo) {
        conejos.add(conejo);
    }

    public void printGranja() {
        System.out.println("---------- ANALISIS DE GRANJA ----------");
        System.out.println("Tienes " + vegetales.size() + " Vegetales");
        System.out.println("Tienes " + vacas.size() + " Vacas");
        System.out.println("Tienes " + conejos.size() + " Conejo\n"
                + "Tienes " + this.dinero + " Monets");
        System.out.println("----------------------------------------");
    }
    public void printConejos(){
        System.out.println("La cantidad de conejos es: "+conejos.size());
        System.out.println("Y sus nombres son");
        for (Conejo conejo : conejos) {
            System.out.println("- "+conejo.getNombre());
        }
    }
    public void printVacas(){
        System.out.println("La cantidad de vacas es: "+vacas.size());
        System.out.println("Y sus nombres son");
        for (Vaca vaca : vacas) {
            System.out.println("- "+vaca.getNombre());
        }
    }
}

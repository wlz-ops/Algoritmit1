
import java.util.Random;
public class Main
{
    
    public static int[] randomArray(){ //Muodostaa 10 satunnaisen kokonaisluvun taulukon 
        int[] array;
        Random r = new Random();
        array = new int[10];
        
        for(int i=0; i<10; i++){
            int random = r.nextInt(100)+1;
            array[i]=random;
        }
        return array;
    }
    
    public static int[] valintaLajittelu(int[] taulukko){ //lajittelee parametrina annetun taulukon käyttäen valintalajittelua(Selection Sort)
       
       for (int askel = 0; askel < 10 -1; askel++) {
           int min = askel;
           
           for (int i = askel + 1; i < 10; i++) {

                if (taulukko[i] < taulukko[min]) {
                	min = i;
                }
            }
       
    int temp = taulukko[askel];
    taulukko[askel] = taulukko[min];
    taulukko[min] = temp;
       }
    return taulukko; 
    }
    
    public static int[] lisaysLajittelu(int[] taulukko){//lajittelee parametrina annetun taulukon käyttäen lisäys lajittelua(Insertion Sort
        
        for (int askel = 1; askel < 10; askel++) {
            int key = taulukko[askel];
            int j = askel - 1;


            while (j >= 0 && key < taulukko[j]) {
                taulukko[j + 1] = taulukko[j];
                --j;
            }

        taulukko[j + 1] = key;
        }
        return taulukko;
    }
   
    
	public static void main(String[] args) {
		int[] taulu1;
		int[] taulu2;
		int[] lajiteltu1;
		int[] lajiteltu2;
		taulu1=randomArray();
		taulu2=randomArray();
		
		System.out.println("Taulukko 1 aluksi:");
		for(int j=0;j<10;j++){
		    System.out.print(" " +taulu1[j]);
		}
		
		System.out.println("\nTaulukko 2 aluksi:");
			for(int j=0;j<10;j++){
		    		System.out.print(" " +taulu2[j]);
		}
		
		lajiteltu1 = valintaLajittelu(taulu1);
		System.out.println("\n\nTaulukko 1 lajiteltuna käyttäen valintalajittelua:");
			for(int j=0;j<10;j++){
		    		System.out.print(" " +lajiteltu1[j]);
		}
		
		lajiteltu2 = lisaysLajittelu(taulu2);
			System.out.println("\n\nTaulukko 2 lajiteltuna käyttäen lisäys lajittelua:");
			for(int j=0;j<10;j++){
		    		System.out.print(" " +lajiteltu2[j]);
		}
	}
}

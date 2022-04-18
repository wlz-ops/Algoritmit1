
import java.util.Arrays;


public class Hajautus {

    /**
     * @param args the command line arguments
     * @return 
     */
    public static int[] luoTaulukko(){
        int[] taulukko = {0,0,0,0,0,0,0,0,0,0};
        return taulukko;
    }
    
    public static int hajautus(int avain){
        int s = 10;
        int indeksi = avain % s;
        return indeksi;
    }
    
    public static void lisaa(int avain, int[] taulu){
        int i = hajautus(avain);
        int laskuri=0;
        while (taulu[i] != 0 && taulu[i] != -1){
            i++;
            i = i % 10; //taulukko "kiertää kulman ympäri"
            laskuri++;
            if(laskuri > 10){
                break;
            }
        }
        if(laskuri<=10)
            taulu[i]=avain;
        else
            System.out.println("Taulukko täysi");
    }
    
    public static int etsi(int avain, int[] taulu){
        int indeksi = hajautus(avain);
        int laskuri=0;
        while (taulu[indeksi] != 0 || taulu[indeksi] != -1){
            if(taulu[indeksi] == avain){
                System.out.println("numero "+ avain +" löytyy indeksistä " +indeksi);
                return indeksi;}
            ++indeksi;
            indeksi = indeksi % 10; //taulukko "kiertää kulman ympäri"
            laskuri++;
            if(laskuri > 10){
                break;
            }
        }
        System.out.println("numeroa "+ avain +" ei löydy taulukosta");
        return -1;
    }
    
    public static void poisto(int avain, int[] taulu){
        int i = etsi(avain, taulu);
        if (i==-1)
            return;
        while (avain != taulu[i]){
            ++i;
            i %= 10; //"kiertää taulukon kulman ympäri"
        }
        if(taulu[i] == avain){
            System.out.println("Poistetaan numero "+ avain +" indeksistä " + i);
            taulu[i]=-1;
        }
        
    }
    public static void main(String[] args) {
      int[] taulukko = luoTaulukko(); 
      System.out.println("Taulukko alussa: \n" + Arrays.toString(taulukko));
      lisaa(4,taulukko);
      System.out.println("Taulukko 1. lisäyksen (numero 4) jälkeen: \n" + Arrays.toString(taulukko));
      lisaa(4,taulukko);
      System.out.println("Taulukko 2. lisäyksen (numero 4) jälkeen: \n" + Arrays.toString(taulukko));
      lisaa(21,taulukko);
      lisaa(21,taulukko);
      lisaa(21,taulukko);
      lisaa(21,taulukko);
      lisaa(21,taulukko);
      System.out.println("Taulukko 7. lisäyksen (numerot 4,4,21,21,21,21,21) \njälkeen: \n" + Arrays.toString(taulukko));
      lisaa(9,taulukko);
      lisaa(9,taulukko);
      lisaa(9,taulukko);
      System.out.println("Taulukko 10. lisäyksen (numerot 4,4,21,21,21,21,21,9,9,9) \njälkeen: \n" + Arrays.toString(taulukko));
      lisaa(8,taulukko);
      System.out.println("Taulukko 11. lisäyksen (numerot 4,4,21,21,21,21,21,9,9,9,8) \njälkeen: \n" + Arrays.toString(taulukko));
      etsi(21, taulukko);
      etsi(9, taulukko);
      etsi(1, taulukko);
      etsi(10000, taulukko);
      poisto(21, taulukko);
      System.out.println("Taulukko poiston jälkeen: \n" + Arrays.toString(taulukko));
      poisto(1, taulukko); //Koetetaan poistaa luku jota ei ole pitäisi tulostua "numeroa 1 ei löydy taulukosta"
      poisto(9, taulukko);
      System.out.println("Taulukko poiston jälkeen: \n" + Arrays.toString(taulukko));
      etsi(9, taulukko);
      lisaa(8,taulukko);
      System.out.println("Taulukko numeron 8 lisäyksen jälkeen: \n" + Arrays.toString(taulukko));
      etsi(4, taulukko);
      lisaa(12,taulukko);
      System.out.println("Taulukko numeron 12 lisäyksen jälkeen: \n" + Arrays.toString(taulukko));
    }
    
}

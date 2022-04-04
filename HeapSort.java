package com.mycompany.algoritmit2ohjlm1;
import java.util.Random;
import java.util.*;

public class HeapSort {

     public static int[] randomArray(){ //Muodostaa 10 satunnaisen kokonaisluvun taulukon
        int[] array;
        Random r = new Random();
        array = new int[11];
        for(int i=0; i<11; i++){
            int random = r.nextInt(100)+1; //numerot välillä 1-100
            array[i]=random; //sijoittaa satunnaisluvun taulukkoon.
        }
        return array; //palauttaa muodotetun taulukon,johon voi tulla kuitenkin samoja numeroita
    }
     public void teeKeko (int a[]){
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            korjaaKeko(a, n, i);
        }
     }
    public void kekolajittelu(int a[]) { 
      int n = a.length; //muutuja n = taulukon koko.
      teeKeko(a);
      for (int i = n - 1; i >= 0; i--) { // Kekolajittelu:
        int temp = a[0];
        a[0] = a[i];
        a[i] = temp;
        korjaaKeko(a, i, 0);   
      }
    }
    
    void korjaaKeko(int arr[], int n, int i) { //haetaan vanhemman ja lapsi solmujen kesken suurin luku
      int suurinLuku = i; //vanhempi/juurisolmu
      int v = 2 * i + 1;//vasen lapsi
      int o = 2 * i + 2;//oikea lapsi
      if (v < n && arr[v] > arr[suurinLuku]){//Tarkistetaan onko vasen > vanhempi
        suurinLuku = v;
      }
      if (o < n && arr[o] > arr[suurinLuku]){//Tarkistetaan onko oikea > vanhempi
        suurinLuku = o;
      }
      if (suurinLuku != i) { //Jos suurin alkio ei ole juurisolmu, vaihdetaan paikat i:n kanssa
        int swap = arr[i];
        arr[i] = arr[suurinLuku];
        arr[suurinLuku] = swap;
        korjaaKeko(arr, n, suurinLuku); //ajetaan korjaaKeko funktio
      }
    }
    
    public static void main(String[] args) {
        int[] taulu1=randomArray();
        HeapSort keko = new HeapSort();
        System.out.println("Taulukko aluksi: \t" + Arrays.toString(taulu1)); //alkuperäisen taulukon tulostus
        keko.kekolajittelu(taulu1);  //kekolajittelu taulukolle taulu1
        System.out.println("Taulukko lajiteltuna: \t" + Arrays.toString(taulu1)); //kekolajitellun taulukon tulostus
    }
    
}


import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrs_p
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int partition = prueba();
        JOptionPane.showMessageDialog(null, "El valor detectado fue " + partition);
        long ini;
        long fin;
        long total = 0;

        
        String resp = JOptionPane.showInputDialog("¿Desea empezar? s/n");
        
        while(resp.equals("s") || resp.equals("S")) {
            //System.out.println("¿De qué tamaño será el arreglo?");
            int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el tamaño del arreglo"));
            //int size = s.nextInt();
            int[] arr = new int[size];
            
            for(int i = 0; i < size; i++) {
                arr[i] = (int)(Math.random() * 100 + 1 );
            }
            
            imprimir(arr);
            System.out.println("");
            
            if(size < partition) {
                //System.out.println("Debido al tamaño del arreglo (" + size + " elementos), se utiliza el método Insertion Sort");
                JOptionPane.showMessageDialog(null, "Debido al tamaño del arreglo (" + size + " elementos), se usará el método Insertion Sort");
                ini = System.nanoTime();
                insertionSort(arr);
                fin = System.nanoTime();
                total = fin - ini;
                imprimir(arr);
                System.out.println("");
            } else if(size > partition) {
                //System.out.println("Debido al tamaño del arreglo (" + size + " elementos), se utiliza el método Quick Sort");
                JOptionPane.showMessageDialog(null, "Debido al tamaño del arreglo (" + size + " elementos), se usará el método Quick Sort");
                quickSort ob = new quickSort();
                ini = System.nanoTime();
                ob.sort(arr, 0, arr.length -1);
                fin = System.nanoTime();
                total = fin - ini;
                imprimir(arr);
                System.out.println("");
            }
            
            //System.out.println("Duró un tiempo de " + total + " nanosegundos");
            JOptionPane.showMessageDialog(null, "Duró un tiempo de " + total + " nanosegundos");
            
            /*System.out.println("¿Desea continuar? s/n");
            resp = s.nextLine();*/
            
            resp = JOptionPane.showInputDialog("¿Desea continuar? s/n");
        }
        
    }
    
    public static int pruebaSort(int size) {
        long iniin;
        long iniquick;
        long finin;
        long finquick;
        long totalquick;
        long totalin;
        
        int[] prueba = new int[size];
        
        for(int i = 0; i < prueba.length; i++) {
            prueba[i] = (int)(Math.random() * 100 +1);
        }
        
        quickSort p = new quickSort();
        iniquick = System.nanoTime();
        p.sort(prueba, 0, prueba.length-1);
        finquick = System.nanoTime();
        totalquick = finquick - iniquick;
        
        iniin = System.nanoTime();
        insertionSort(prueba);
        finin = System.nanoTime();
        totalin = finin - iniin;
        
        if((totalin/totalquick == 2)) {
            return size;
        } else {
            return pruebaSort(size+1);
        }
        
    }
    
    public static int prueba() {
         return pruebaSort(10);
    }
    
    public static void insertionSort(int[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacío");
        } else {
            for (int i=1; i<arr.length; ++i) {
                int n = arr[i];
                int j = i-1;
                while (j>=0 && arr[j] > n) {
                    arr[j+1] = arr[j];
                    j = j-1;
                }
                
                arr[j+1] = n;
            }
        }
    }
    
    public static void imprimir(int[] arr) {
        for(int g : arr) {
            System.out.print("[" + g + "]");
        }
        System.out.println("");
    }
}

class quickSort {
    private int[] numbers;
    private int number;
    
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {

            if (arr[j] <= pivot)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
       
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);

            
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

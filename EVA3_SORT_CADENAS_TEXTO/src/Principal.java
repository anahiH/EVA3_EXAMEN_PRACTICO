
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
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el tamaño del arreglo"));
        String[] arr = new String[size];
        
        for(int i = 0; i < size; i++) {
            arr[i] = JOptionPane.showInputDialog("Inserte el siguiente string");
        }
        
        imprimir(arr);
        
        String resp = JOptionPane.showInputDialog("¿Qué método desea usar?").toLowerCase();
        boolean b = true;
        while(b == true) { 
            switch(resp) {
                case "insertion sort":
                    insertionSort(arr);
                    imprimir(arr);
                    b = false;
                    break;
                case "selection sort":
                    selectionSort(arr);
                    imprimir(arr);
                    b = false;
                    break;
                case "bubble sort":
                    bubbleSort(arr);
                    imprimir(arr);
                    b = false;
                    break;
                case "quick sort":
                    quickSort ob = new quickSort();
                    ob.sort(arr, 0, arr.length-1);
                    imprimir(arr);
                    b = false;
                    break;
                default :
                    System.out.println("Lo que ha ingresado no es válido, intente otra vez.");
                    b = true;
            }
        }
    }
    
    public static void imprimir(String[] arr) {
        for(String g : arr) {
            System.out.print("["+g+"]");
        }
        System.out.println("");
    }
    
    public static void insertionSort(String[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacío");
        } else {
            for (int i=1; i<arr.length; ++i) {
                String n = arr[i];
                int j = i-1;
                while (j>=0 && arr[j].compareTo(n) > 0) {
                    arr[j+1] = arr[j];
                    j = j-1;
                }
                
                arr[j+1] = n;
            }
        }
       }
    
    public static void selectionSort(String[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacio");
        } else {
            int n;
            int i;
            int o;
            String placeholder;
            for (o = 0; o < arr.length - 1; o++) {
                n = o;
                for(i = o+1; i < arr.length; i++) {
                    if(arr[i].compareTo(arr[n]) < 0) {
                        n = i;
                    }
                }
                placeholder = arr[n];
                arr[n] = arr[o];
                arr[o] = placeholder;
            }
        }
    }
    
    public static void bubbleSort(String[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacío");
        } else {
            for(int i = 0; i < arr.length - 1; i++) {
                for(int j = 0; j < arr.length - 1; j++) {
                    if(arr[j].compareTo(arr[j + 1]) > 0) {
                        String temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
    }
    
}

class quickSort {
    /*private int[] numbers;
    private int number;*/
    
    int partition(String arr[], int low, int high)
    {
        String pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {

            if (arr[j].compareTo(pivot) <= 0)
            {
                i++;
 
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
       
        String temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    void sort(String arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);

            
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

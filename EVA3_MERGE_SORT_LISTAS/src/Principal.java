
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
        Principal list = new Principal();
        int size = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos elementos tendrá la lista?"));
        
        for(int i = 0; i < size; i++) {
            list.push((int)(Math.random() * 100 + 1));
        }
        
        list.print(ini);
        nodo n = null;
        n = list.mergeSort(ini);
        list.print(n);
    }
    
    static nodo ini;
 
    static class nodo {
 
        int num;
        nodo sig, prev;
 
        nodo(int d) {
            num = d;
            sig = null;
            prev = null;
        }
    }
 
    void print(nodo n) {
        nodo temp = n;
        while (n != null) {
            System.out.print(n.num + " ");
            temp = n;
            n = n.sig;
        }
        System.out.println("");
    }
 
    nodo split(nodo ini) {
        nodo fast = ini, slow = ini;
        while (fast.sig != null && fast.sig.sig != null) {
            fast = fast.sig.sig;
            slow = slow.sig;
        }
        nodo temp = slow.sig;
        slow.sig = null;
        return temp;
    }
 
    nodo mergeSort(nodo n) {
        if (n == null || n.sig == null) {
            return n;
        }
        nodo dos = split(n);
 
        n = mergeSort(n);
        dos = mergeSort(dos);
 
        return merge(n, dos);
    }
 
    nodo merge(nodo uno, nodo dos) {
        if (uno == null) {
            return dos;
        }
 
        if (dos == null) {
            return uno;
        }
 
        if (uno.num < dos.num) {
            uno.sig = merge(uno.sig, dos);
            uno.sig.prev = uno;
            uno.prev = null;
            return uno;
        } else {
            dos.sig = merge(uno, dos.sig);
            dos.sig.prev = dos;
            dos.prev = null;
            return dos;
        }
    }
    
    void push(int num) {
        nodo n = new nodo(num);  
        
        if(ini == null){
            ini = n;
            return;
        }
         
        n.sig = ini;
        ini.prev = n;
        n.prev = null;
        ini = n;
    }
}

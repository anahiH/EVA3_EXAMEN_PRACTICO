
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
        
        list.imprimir();
        list.quickSort(list.ini);
        list.imprimir();
    }
    
    nodo ini;
    static class nodo {
        private int num;
        private nodo sig;
        private nodo prev;
        
        nodo(int d) {
            num = d;
            sig = null;
            prev = null;
        }
    }
    
    nodo fin(nodo n) {
        while(n.sig != null) {
            n = n.sig;
        }
        return n;
    }
    
    nodo partition(nodo low, nodo high) {
        int pivote = high.num;
        
        nodo i = low.prev;
        
        for(nodo j = low; j != high; j=j.sig){
            if(j.num <= pivote) {
                i = (i==null) ? low : i.sig;
                //swap(i, j);
                /*int posI = findPos(i.num);
                int posJ = findPos(j.num);
                recorrerNodo(i, posJ);
                recorrerNodo(j, posI);*/
                int temp = i.num;
                i.num = j.num;
                j.num = temp;
            }
        }
        
        i = (i == null) ? low:i.sig;
        //swap(i, high);
        /*int posI = findPos(i.num);
        int posJ = findPos(high.num);
        recorrerNodo(i, posJ);
        recorrerNodo(high, posI);*/
        int temp = i.num;
        i.num = high.num;
        high.num = temp;
        return i;
    }
    
    void quickSorting(nodo low, nodo high) {
        if(high!=null && low!=high && low!=high.sig){
            nodo temp = partition(low,high);
            quickSorting(low,temp.prev);
            quickSorting(temp.sig,high);
        }
    }
    
    public void quickSort(nodo n) {
        nodo c = fin(n);
        quickSorting(n, c);
    }
    
    void push(int num) {
        nodo n = new nodo(num);
        if(ini == null) { 
            ini = n;
            return;
        }
        
        n.sig = ini;
        ini.prev = n;
        n.prev = null;
        ini = n;
    }
    
    public void recorrerNodo(nodo n, int num) {
        nodo ant = null;
        nodo temp = ini;
        if(num == 0) {
                n.sig = ini;
                ini.prev = n;
                ini = n;
            } else {
                nodo nTemp1 = ini;
                for(int i = 0; i < (num-1); i++) {
                    nTemp1 = nTemp1.sig;
                }
                n.sig = nTemp1.sig;
                n.prev = nTemp1;
                nTemp1.sig = n;
                n.sig.prev = n;
            }
    }
    
    public nodo swapPairs(nodo head) {
    if(head == null || head.sig == null)   
        return head;
 
    nodo h = new nodo(0);
    h.sig = head;
    nodo p = h;
 
    while(p.sig != null && p.sig.sig != null){
        //use t1 to track first node
        nodo t1 = p;
        p = p.sig;
        t1.sig = p.sig;
 
        //use t2 to track next node of the pair
        nodo t2 = p.sig.sig;
        p.sig.sig = p;
        p.sig = t2;
    }
 
    return h.sig;
}
    
    void swap(nodo a, nodo b) {
    if (a == b)
        return;

    if (a.sig == b) { // right next to each other
        a.sig = b.sig;
        b.prev = a.prev;

        if (a.sig != null) {
            a.sig.prev = a;
        }

        if (b.prev != null) {
            b.prev.sig = b;
        }
        
        if (a.prev != null) {
            a.prev.sig = a;
        }
        
        if (b.sig != null) {
            b.sig.prev = b;
        }


        b.sig = a;
        a.prev = b;
    } else {
        nodo p = b.prev;
        nodo n = b.sig;

        b.prev = a.prev;
        b.sig = a.sig;

        a.prev = p;
        a.sig = n;

        if (b.sig != null) {
            b.sig.prev = b;
        }
        if (b.prev != null) {
            b.prev.sig = b;
        }

        if (a.sig != null) {
            a.sig.prev = a;
        }
        if (a.prev != null) {
            a.prev.sig = a;
        }

    }
}
    
    public int findPos(int num) {
            nodo temp = ini;
            int cont = 0;
            while(temp.num != num) {
                temp = temp.sig;
                cont++;
            }
            return cont;
        }
    
    public void imprimir() {
            nodo nTemp = ini;
            if(ini == null) {
                System.out.println("La lista está vacia");
            } else {
                while(nTemp != null) {
                System.out.print(nTemp.num + " - ");
                nTemp = nTemp.sig;
               }
                System.out.println("");
            }

        }
}

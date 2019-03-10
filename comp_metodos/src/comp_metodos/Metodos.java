/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp_metodos;


import java.util.Arrays;

/**
 *
 * @author T-Gamer
 */
public class Metodos {
        
    
    public static void bubbleSort(int ar[]){

       for (int i = 0; i < ar.length; i++){
  
           for (int j = 0; j < (ar.length-1); j++){
               if (ar[j] > ar[j+1]){
                 int aux = ar[j+1];
                 ar[j+1] = ar[j];
                 ar[j] = aux;
               }
           }           
       }        
    }
    public static void insertSort(int ar[]){
        for (int i = 0; i < ar.length; i++){
            int aux = ar[i];
            for (int j = i-1; ((j >=0) && (ar[j] > aux)); j--){
                ar[j+1] = ar[j];
                ar[j] = aux;
            }
        }
    }
    private int[] qtt;
    
    
    public void sort(int ar[]) {
 
        this.qtt = ar;
        quickSort(0, ar.length - 1);
    }
 
    private void quickSort(int menor, int maior) {
         
        int i = menor;
        int j = maior;
        // calculando numero pivo 
        int pivo = qtt[menor+(maior-menor)/2];
        // Dividindo em dois vetores
        while (i <= j) {
             
            while (qtt[i] < pivo) {
                i++;
            }
            while (qtt[j] > pivo) {
                j--;
            }
            if (i <= j) {
                int aux = qtt[i];
                qtt[i] = qtt[j];
                qtt[j] = aux;
                i++;
                j--;
            }
        }
        if (menor < j)
            quickSort(menor, j);
        if (i < maior)
            quickSort(i, maior);
    }
    
    
    public void radixSort(int vector[]){
		for(int digit = 0; digit < 30; digit ++){
			int power = (int) Math.pow(10, digit+1);
			
			int z[][] = new int[vector.length][10];
			int n[] = new int[10];

			for(int i = 0; i < vector.length; i ++){
				int num = vector[i];
				z[n[(num%power)/(power/10)]][(num%power)/(power/10)] = num;
				n[(num%power)/(power/10)]++;
				
			}
			int c = 0;
			for(int i = 0; i < 10; i ++){
				
				for(int j = 0; j < vector.length; j ++){
					if(j < n[i]){
						vector[c] = z[j][i];
						c++;
					}else{break;}
				}
			}
			
		}
	}
    
    
    public void shellSort(int[] nums) {
    int h = 1;
    int n = nums.length;
    
    while(h < n) {
            h = h * 3 + 1;
    }
    
    h = h / 3;
    int c, j;
    
    while (h > 0) {
        for (int i = h; i < n; i++) {
            c = nums[i];
            j = i;
            while (j >= h && nums[j - h] > c) {
                nums[j] = nums[j - h];
                j = j - h;
            }
            nums[j] = c;
        }
        h = h / 2;
    }
}
    
    public void SelectionSort(int vetor[]) {
    for (int indice = 0; indice < vetor.length; ++indice) {
        int indiceMenor = indice;
        for (int indiceSeguinte = indice+1; indiceSeguinte < vetor.length; ++indiceSeguinte) {
            if (vetor[indiceSeguinte] < vetor[indiceMenor]) {
                indiceMenor = indiceSeguinte;
            }
        }
        int aux = vetor[indice];
        vetor[indice] = vetor[indiceMenor];
        vetor[indiceMenor] = aux;
    }
}
  public void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q-1);
            int[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    public void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        

    }
    
  public  void cocktailSort(int a[])
    {
        boolean swapped = true;
        int start = 0;
        int end = a.length;
 
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
 
          
            start = start + 1;
        }
    }
    
}

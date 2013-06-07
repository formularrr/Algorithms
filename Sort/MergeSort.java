package Sort;

import java.util.Random;

public class MergeSort {
	
	private static int[] aux;
	
	public static void sort(int[] a , int lo , int hi){
		System.out.println("sort "+lo+" "+hi);
		
		if(lo>=hi)
			return;
		
		int mid = (lo + hi)/2;
		
		sort( a, lo, mid);
		sort( a, mid+1, hi);
		merge( a, lo, mid, hi);
	}
	
	public static void merge(int[] a, int lo, int mid, int hi){
		
		System.out.println("merge "+a[lo]+" "+a[hi]);
		
		aux = new int[a.length];
		
		for(int i=lo; i<=hi ; i++){
			aux[i] = a[i];
			
		}
		
		int i = lo ;
		int j = mid+1;
		
		for(int k=lo ; k<=hi ;k++){
			
			
			if(i>mid)
				a[k] = aux[j++];
			
			else if(j>hi)
				a[k] = aux[i++];
			
			else if(aux[i] > aux [j])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
			

			
				          
		}
		
		for(int k = 0 ;k<a.length;k++)
			System.out.print(a[k] + " ");
		System.out.println();
	}

	

}

package Sort;

public class MergeBU {
	private static int[] aux;
	
	public static void sort(int[] a){
		for(int i=1; i<a.length ; i*=2){
			for(int j=0 ; j<a.length-i ; j+=i+i){
				merge(a, j, j+i-1,Math.min(a.length-1, j+i+i-1));
			}
		}
	}
	
public static void merge(int[] a, int lo, int mid, int hi){
		
		System.out.println("merge "+lo+" "+hi);
		
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

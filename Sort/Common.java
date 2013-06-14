package Sort;

public class Common {
	public static void exch(int[] a, int i, int j){
		
		int temp = a[i];
		a[i] = a[j];
		a[j] =temp;
	}
	
	public static void print(int[] a, int lo, int hi){
		
		for(int i=lo; i<=hi; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		
	}
	
public static void print(int[] a){
		
		for(int i : a)
			System.out.print(i + " ");
		
		System.out.println();
		
	}
}

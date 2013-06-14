package Sort;

public class QuickSort {
	
	public static void sort(int[] a, int lo, int hi){
		
		if(lo>=hi)
			return;
		int j = partition(a, lo, hi);
		
		
		System.out.println("partition:"+j+" no:" + a[j]);
		
		System.out.println("left:"+a[lo]+" "+a[j]);
		sort(a, lo, j-1);
		Common.print(a);
		
		System.out.println("right:"+a[j]+" "+a[hi]);
		sort(a, j+1, hi);
		
		Common.print(a);

	}
	
	public static int partition(int[] a, int lo, int hi){
		
		int key = a[lo];
		
		System.out.println("key:"+key+" lo:"+lo+" hi:"+hi);
		
		int i = lo;
		int j = hi+1;
		
		while(i < j){
			
			while(a[++i] < key && i < hi);
			
			while(a[--j] > key && j > lo);
			
			
			if(i>=j)
				break;
			System.out.println("i:"+i+" j:"+j);
			
			Common.exch(a, i, j);
			Common.print(a);
		}
		Common.exch(a, lo, j);
		Common.print(a);
		return j;
	}

}

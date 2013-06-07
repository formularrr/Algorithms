package Sort;

import java.util.Random;

public class SelectSort {

	public static void sort(int[] a){
		
		for(int i=0 ; i<a.length ; i++)
			System.out.print(a[i]+" ");
		System.out.print("\n");
		
		for(int i=0 ; i<a.length ;i++){
			
			int pos = i;
			
			for(int j=i+1 ; j<a.length ;j++){
				if(a[j] < a[pos])
					pos = j;
			}
		
			int t = a[pos];
			a[pos] = a[i];
			a[i] = t;
			
			System.out.println(i+":");
			for(int k=0 ; k<=i ; k++)
				System.out.print(a[k]+" ");
			System.out.print("\n");
		}
	}
	

	public static void main(String[] args){
		int[] num = new int[10];
		
		Random r = new Random();
		
		for(int i = 0 ; i<num.length ; i++)
			num[i]=r.nextInt(100);
		
		sort(num);
	}
}

package Sort;

import java.util.Random;

public class ShellSort {
	
	public static void sort(int[] a){
		int N =a.length;
		int n = 1;
		
		while(n < N/3)
			n= 3*n + 1;
		
		while(n >= 1){
			//System.out.println("间隔为"+n);
			
			for(int i=n;i<N;i++){
				
				//System.out.println("第"+i+"未排序:");
				//for(int k=0 ; k<N ; k++)
					//System.out.print(a[k]+" ");
				//System.out.print("\n");
				
				for(int j = i ; j>n-1 ; j-=n){
					if(a[j] < a[j-n]){
						int t=a[j];
						a[j]=a[j-n];
						a[j-n]=t;
					}
				}
				
				//System.out.println("第"+i+"已排序:");
				//for(int k=0 ; k<N ; k++)
					//System.out.print(a[k]+" ");
				//System.out.print("\n");
			}
			
			
			n = n/3;
		}
	}
	
	public static void main(String[] args){
		int[] num = new int[10];
		
		Random r = new Random();
		
		for(int i = 0 ; i<num.length ; i++)
			num[i]=r.nextInt(100);
		
		for(int i=0 ; i<num.length ; i++)
			System.out.print(num[i]+" ");
		
		System.out.print("\n");
		sort(num);
	}

}

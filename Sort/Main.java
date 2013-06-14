package Sort;

import java.util.Random;

public class Main {
	public static void main(String[] args){
		int[] num = new int[10];
		
		Random r = new Random(27);
		
		for(int i = 0 ; i<num.length ; i++){
			num[i]=r.nextInt(20);
		
			System.out.print(num[i]+" ");
		}
		System.out.println();
		QuickSort.sort(num,0,num.length-1);
		
		for(int i = 0 ; i<num.length ; i++){
		
			System.out.print(num[i]+" ");
		}
	}
}

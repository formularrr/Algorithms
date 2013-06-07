package Sort;

import java.util.Random;

public class InsertSort {

	public static void sort(int[] obj){
		for(int i=0 ; i<obj.length ; i++)
			System.out.print(obj[i]+" ");
		System.out.print("\n");
		
		for(int i = 1 ; i < obj.length ; i++){
			
			int key = obj[i];
			
			for(int j = i-1 ; j >= 0 ; j--){
				if(obj[j] > key){
					int t = obj[j+1];
					obj[j+1] = obj[j];
					obj[j]=t;
				}	
			}
			
			//System.out.println(i+":");
			//for(int k=0 ; k<=i ; k++)
				//System.out.print(obj[k]+" ");
			//System.out.print("\n");
		}
		
		//for(int i=0 ; i<obj.length ; i++)
			//System.out.print(obj[i]+" ");
	}

	
	public static void main(String[] args){
		int[] num = new int[10];
		
		Random r = new Random();
		
		for(int i = 0 ; i<num.length ; i++)
			num[i]=r.nextInt(100);
		
		sort(num);
	}
	
}

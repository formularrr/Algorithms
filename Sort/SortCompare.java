package Sort;

import java.util.Random;

public class SortCompare {

	public static double time(String type , int[] a){
		long start = System.currentTimeMillis();
		
		if(type.equals("SelectSort"))
			SelectSort.sort(a);
		
		else if(type.equals("InsertSort"))
			InsertSort.sort(a);
		
		else if(type.equals("ShellSort"))
			ShellSort.sort(a);
		
		long end = System.currentTimeMillis();
		
		return end-start;
	}
	
	public static void main(String[] args){
		int[] num = new int[1000];
		
		Random r = new Random();
		
		for(int i = 0 ; i<num.length ; i++)
			num[i]=num.length-i;;
		
		double timeForSelect = time("SelectSort" , num);
		double timeForInsert = time("InsertSort" , num);
		//double timeForShell = time("ShellSort" , num);
		
		System.out.println();
		System.out.printf("SelectSort is %.1f times %.1f faster than InsertSort" , timeForInsert,timeForSelect);
	}
}

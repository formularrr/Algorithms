package Sort;

import java.util.Arrays;

public class MaxPQ {
	int[] pq;
	int N;
	
	public MaxPQ(int[] a){
		pq = new int[a.length+1];
		N = 0;
	}
	
	public MaxPQ(int size){
		pq = new int[size+1];
		N = size;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return this.N;
	}

	public void insert(int key){
		pq[++N] = key;
		swim(N);
		print();
	}
	
	public void swim(int k){
		while(pq[k] > pq[k/2] && k/2>=1){
			Common.exch(pq, k, k/2);
			k/=2;
		}
	}
	
	public void sink(int k){
		
		while(2*k <= N){
			int j = 2*k;
			if(pq[j] < pq[j+1])
				j++;
			if(pq[k]>=pq[j])
				break;
			Common.exch(pq,k,j);
			k=j;
			
		}
	}
	public int delMax(){
		int key = pq[1];
		pq[1] = pq[N--];
		pq[N+1] = 0;
		sink(1);
		return key;
	}
	
public  void print(){
		
		for(int i : pq)
			System.out.print(i + " ");
		
		System.out.println();
		
	}
}

package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FixedCapacityStackOfStrings implements Iterable{

	/**
	 * @param args
	 */
	private String[] a;
	private int N;
	
	//-------------------------basic methods--------------------
	public FixedCapacityStackOfStrings(String[] src, int cap){
		a = Arrays.copyOf(src, cap);
		N = a.length;
	}
	
	public FixedCapacityStackOfStrings(int cap){
		a = new String[cap];
		N = 0;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isFull(){
		return N == a.length;
	}
	
	public void push(String item){
		if(!this.isFull()){
			a[N++]=item;
			//System.out.println("push:"+item);
		}
	}
	
	public String pop(){
		if(!this.isEmpty()){
			String str=a[--N];
			//System.out.println("pop:"+str);
			return str;
		}
		
		return "Stack is empty!";
	}
	
	public void resize(){
		a = Arrays.copyOf(a, a.length*2);
	}
	
	//get the top without pop
	public String peek(){
		
		if(!this.isEmpty()){
			String str=a[--N];
			System.out.println(str);
			this.push(str);
			return str;
		}
		
		return "Stack is empty!";

	}


	public boolean isOperator(String s){
		
		if( s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		
		return false;
	}
	
	//+,-,*,/
	public int operate(int a , int b , String op){
		
		if(op.equals("+"))
			return a+b;
		
		else if(op.equals("-"))
			return a-b;
		
		else if(op.equals("*"))
			return a*b;
		
		return a/b;
	}
	
	//check the brackets is matched or not
	public boolean isMatched(String str){
		
		String[] s=str.split(" ");
		
		Map<String,String> map= new HashMap<String,String>();
		
		map.put(")","(");
		map.put("}","{");
		map.put("]","[");
		
		for(String item : s){
			System.out.println("handle "+item);
			if(item.equals("(") || item.equals("[") ||item.equals("{"))
				this.push(item);
			
			else if(item.equals(")") || item.equals("]") || item.equals("}") )
				if(!this.pop().equals(map.get(item)))
					return false;	
		}
		
		if(this.size()!=0)
			return false;
		
		return true;
	}
	

	//add the left brackets,input 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ),output ((1+2)*((3-4)*(5-6)))
	public String complement(String str){
		String[] item=str.split(" ");
		
		FixedCapacityStackOfStrings op = new FixedCapacityStackOfStrings(200);
		FixedCapacityStackOfStrings no = new FixedCapacityStackOfStrings(200);
		FixedCapacityStackOfStrings temp = new FixedCapacityStackOfStrings(200);
		
		for(String s : item){
			
			if(isOperator(s))
				op.push(s);
			
			else if(s.equals(")")){
				temp.push(s);
				temp.push(no.pop());
				temp.push(op.pop());
				temp.push(no.pop());

				String tp="(";
				
				for(int i=0;!temp.isEmpty();i++)
					tp+=temp.pop();
				
				System.out.println("tp:"+tp);
				no.push(tp);
			}
			
			else
				no.push(s);
		}
		
		return no.pop();
		
	}
	
	//infix to postfix
	public String infixToPostfix(String str){
		String[] item = str.split(" ");
		String rs = "";
		
		FixedCapacityStackOfStrings op = new FixedCapacityStackOfStrings(200);
		FixedCapacityStackOfStrings no = new FixedCapacityStackOfStrings(200);
		
		for(String s : item){
			
			if(s.equals("("))
				;
			else if( isOperator(s))
				op.push(s);
			else if(s.equals(")")){
				
				rs=op.pop()+no.pop()+no.pop();
				no.push(rs);
			}
			else
				no.push(s);
		}
		
		rs="";
		for(int i = 0 ; !no.isEmpty() ; i++)
			rs=no.pop() ;
		
		return this.reverse(rs);
	}
	
	//String reverse
	public String reverse(String s){
		
		String str="";
		
		for(int i=s.length()-1 ; i>=0; i--){
			str+=s.charAt(i);
		}
		
		return str;
	}
	
	public int evaluatePostfix(String str){
		String[] item = str.split(" ");
	
		FixedCapacityStackOfStrings no = new FixedCapacityStackOfStrings(200);
		
		for(String s : item){
			
			if( isOperator(s) ){
				int a=Integer.parseInt(no.pop());
				int b=Integer.parseInt(no.pop());
				no.push(String.valueOf(operate(a,b,s)));
			}
			
			else no.push(s);
		}
		
		return Integer.parseInt(no.pop());
	}
	
	//copy stack
	public static FixedCapacityStackOfStrings copy(FixedCapacityStackOfStrings original){
		
		FixedCapacityStackOfStrings destination = new FixedCapacityStackOfStrings(original.size()); 
		Iterator<String> iter = original.iterator();
		for(; iter.hasNext();){
			destination.push(iter.next());
		}
		
		return destination;
		
	}
	
	//iterator
	@Override
	public Iterator<String> iterator() {
		
		// TODO Auto-generated method stub
		
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<String>{
		
		private FixedCapacityStackOfStrings st;
		
		public StackIterator(){
			this.st = new FixedCapacityStackOfStrings(a,N);
		}
		
		public boolean hasNext(){
			return !st.isEmpty();
		}
		
		public void remove(){};
		
		public String next(){
			return st.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1 2 + 3 4 - 5 6 - * *";
		String[] item = str.split(" ");
		FixedCapacityStackOfStrings pt = new FixedCapacityStackOfStrings(item,item.length);
		
		
		FixedCapacityStackOfStrings temp=copy(pt);

		while(!temp.isEmpty())
			System.out.print(temp.pop()+" ");
	
		}

	
}

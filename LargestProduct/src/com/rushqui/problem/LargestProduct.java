package com.rushqui.problem;

public class LargestProduct {
	
	private Integer digits[];
	private String arr[];
	private Integer v=0;
	private Integer n=0;
	private Integer k=0;
	private Integer multiply=1;
	private String stringNumber;
	private Integer product[];
	private Integer bigger=0;
	private Integer z=0;
	
	public void largestProduct(Long number,Integer K) {
		k=K;
		stringNumber=String.valueOf(number);
		arr=stringNumber.split("");
		digits=new Integer[arr.length]; 
	    for(int i=0;i<=arr.length-1;i++) {
	    	digits[i]=Integer.valueOf(arr[i]);
	    }
	    
	    while(v<=arr.length && v+k<=arr.length) {
	    	for(int j=0;j<=k-1;j++) {
	    		System.out.println(digits[n]);
	    		multiply*=digits[n];
	    		n++;
	  
	    	}
	    	product=new Integer[arr.length];
	    	product[v]=multiply;
	    	if(product[v]>bigger) {
	    		bigger=product[v];
	    		z=v;
	    	}
	    	System.out.println(product[v]);
	    	multiply=1;
	    	v++;
	    	n=v;
	    }
	    System.out.println("Producto mayor de k digitos encontrado:"+" "+bigger);
	    if(bigger>0) {
	    	System.out.println("Digitos consecutivos:");
		    for(int r=z;r<=(z+k)-1;r++) {
		    	 System.out.println(digits[r]);
	    }
	   }
		
	}
	
	public static void main(String[] args){
		
		LargestProduct problem =new LargestProduct();
		problem.largestProduct(3675356291L,5); 	//el primer parametro corresponde al numero que se desea analizar 
												//el segundo corresponde a k
	}

}




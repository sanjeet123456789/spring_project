package com.pal.sanjeet.pal;
import java.util.Scanner;

public class Replacetoz {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String Pal=sc.nextLine();
		StringBuffer pal_build=new StringBuffer(Pal);
//		System.out.println(pal_build.charAt(2));
		
		for(int i=0;i<pal_build.length();i++) {
			char xs=pal_build.charAt(i);
			if( xs == 'a'||xs=='e'|| xs=='o'||xs=='u'||xs=='i') {
				pal_build.setCharAt(i, 'z');
//				
				
			}
		}
		System.out.println(pal_build);
		
		
		
	}

	

}

package com.pal.sanjeet.pal;

public class Sanjeet {
	public static void main(String[] args) {
		
		String str="sanjeetpalisfuckisng gorgous;";
		String find_value="is";
		int firstvalue=-1;
		int secondvalue=-1;
		String pal="";
		for(int i=0;i<str.length();i++) {
			secondvalue=firstvalue;
			firstvalue=str.indexOf(find_value,i);
		
			if(firstvalue!=-1 & firstvalue!=secondvalue) {
				System.out.println(firstvalue);
				
//				pal=pal.concat();
				
				char st_prev=str.charAt(firstvalue - 1);
				char st_next=str.charAt(firstvalue + find_value.length());
//				System.out.println(st_prev +""+ st_next);
				
				pal+=st_prev;
				pal+=st_next;	
			}
			
		}
		
		System.out.println(pal);
		
		
		
		
	}
}

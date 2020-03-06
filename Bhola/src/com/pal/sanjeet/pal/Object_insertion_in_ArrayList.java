package com.pal.sanjeet.pal;
import java.util.*;
import java.io.*;

public class Object_insertion_in_ArrayList {
	
	String uid;
	String name;
	String course;
	
	public Object_insertion_in_ArrayList() {
		this.uid=uid;
		this.name=name;
		this.course=course;
	}
	public static void main(String[] args) {
		ArrayList<Object> pal=new ArrayList<>();
		
		boolean flag=true;
		while(flag==true) {
			System.out.println("Do you want to insert student detail yes/no?");
			Scanner sc=new Scanner(System.in);
			String option=sc.nextLine();
			if(option.equals("yes")) {
				System.out.println("Please enter uid");
				String uid=sc.nextLine();
				System.out.println("please enter name");
				String name=sc.nextLine();
				System.out.println("please enter course");
				String course=sc.nextLine();
				Object_insertion_in_ArrayList obj=new Object_insertion_in_ArrayList();
				pal.add(obj);			
			}else {
				flag=false;
				break;
			}

			
		}
		
		for(int i=0;i<pal.size();i++) {
			System.out.println(pal.get(i));
		}
		
		
		
	}

}

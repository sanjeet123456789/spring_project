package com.pal.sanjeet.weather;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;







public class Weather_Call {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter latitute");
		int latitude=sc.nextInt();
		System.out.println("Enter longitute");
		int longitude=sc.nextInt();
		Weather_Call weather=new Weather_Call();
		weather.Action(latitude,longitude);
		
	}
	public String Action(int latitude,int longitude) {
		Client client=ClientBuilder.newClient();
		StringBuffer sb=new StringBuffer();
		sb.append("https://samples.openweathermap.org/data/2.5/weather?appid=c4863b2a15059bcebc19a8e97733a4a0&lat=");
		sb.append(latitude);
		sb.append("&lon=");
		sb.append(longitude);
		System.out.println(sb.toString());
		WebTarget target=client.target(sb.toString());
		System.out.println(target.request().get(String.class));
		return target.request().get(String.class);
	}
}

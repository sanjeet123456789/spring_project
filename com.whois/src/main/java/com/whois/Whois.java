package com.whois;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.whois.WhoisClient;

public class Whois {
	private static Pattern pattern;
	private Matcher matcher;
	
	private static final String WHOIS_SERVER_PATTERN="who is Server:\\s(.*)";
	static {
		pattern =Pattern.compile(WHOIS_SERVER_PATTERN);
		
	
	
	}
	
	public static void main(String[] args) {
		Whois object=new Whois();
		System.out.println(object.getWhois("sitesking.com"));
		System.out.println("done");
	}

	private String getWhois(String string) {
		StringBuilder result=new StringBuilder("");
		WhoisClient whois=new WhoisClient();
		try {
			whois.connect(WhoisClient.DEFAULT_HOST);
			String Whois_rs=whois.query("="+string);
			result.append(Whois_rs);
			whois.disconnect();
			//gettthe server
			String whois_server_url=getWhois_server(Whois_rs);
			if(!whois_server_url.equals("")) {
				String whois_rs2=querywhois_server(string,whois_server_url);
				result.append(whois_rs2);
			}
		}catch(Exception e) {
			System.out.println("error");
		}
	
	return result.toString();
	}
	private String querywhois_server(String domain_name,String whois_server) {
		String result="";
		WhoisClient whoisclient=new WhoisClient();
		try {
			whoisclient.connect(whois_server);
			result=whoisclient.query(domain_name);
			whoisclient.disconnect();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	private String getWhois_server(String who_is) {
		String result="";
		matcher =pattern.matcher(who_is);
		while(matcher.find()) {
			result=matcher.group(1);
		}
		return result;
		
	}
}

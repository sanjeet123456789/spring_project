package com.pal.sanjeet.commandlinevalue;

import java.io.FileOutputStream;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;





@SpringBootApplication
public class SpringCommandLineValueApplication {

	public static void main(String[] args) {
		CommandLineValues values = new CommandLineValues();
		CmdLineParser parser = new CmdLineParser(values);
		try {
			parser.parseArgument(args);
			
			String f_name=values.first_name;
			String l_name=values.last_name;
			int phone=values.phone_number;
			double income=values.income;
			System.out.println(""+f_name+""+l_name+""+phone+""+income);
			Document document=new Document();
			PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("/home/sanjeet/Downloads/pal.pdf"));
			String commandvalue=""+f_name+""+l_name+""+phone+""+income;
			document.open();
			document.add(new Paragraph(commandvalue));
			document.close();
			writer.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
			
		
	}
	
	public static class CommandLineValues {

		@Option(name = "-first_name", aliases = {"-f","-fname"}, required = false, usage = "Specifies your first name.")
		public String first_name= null;


		@Option(name = "-last_name", aliases = {"-l", "-ln", "-lname"}, required = false,  metaVar = "specified your last name.",
				usage = "Specifies a path for the input file.")
		public String last_name = null;


		@Option(name = "-phone_number", aliases = {"-p", "-pn", "-pnumber"}, required = false, metaVar = "your phone number please..",
				usage = "Specifies a path for the output PDF.")
		public int phone_number = 0;


		@Option(name = "-income", aliases = {"-i","-income"}, required = false, usage = "tell me about your income.")
		public double income = 0.0;


	}
}

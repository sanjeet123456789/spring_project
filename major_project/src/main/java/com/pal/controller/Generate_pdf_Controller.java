package com.pal.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.config.Pdfdemos;



@Controller
@RequestMapping("/admin/generate_pdf")
public class Generate_pdf_Controller {
	

//	@GetMapping("/online")
//	public String generating_pdf(Model theModel) {
//		System.out.println("hello");
//		CustomerServiceImpl pal=new CustomerServiceImpl();
//		Pdfdemos pal1=new Pdfdemos();
//		PdfWriter xx=pal1.generate_pdf();
//		return "redirect:/";
//	}
	
	@GetMapping(value="/online",produces=MediaType.APPLICATION_PDF_VALUE)
	@ResponseBody//this is important as the return thpr byte[]
	public byte[] generating_pdf(javax.servlet.http.HttpServletResponse response) throws IOException{//exceptionhandling
		System.out.println("hello");//logging
		//re generate new file if needed (thread-safety!..)
		//..and dump the content as byte[] reposnse
//		java.io.OutputStream outstr=response.getOutputStream();
//		response.sendRedirect("/admin/subject_t/listSubject");
		
		Pdfdemos pal2=new Pdfdemos();
		pal2.generate_pdf();
		return Files.readAllBytes(Paths.get("d:\\sanjeet8.pdf"));
	}
	


}

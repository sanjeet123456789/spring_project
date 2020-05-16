package com.pal.sanjeet.spring.searchandfilter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	/* search*/
	
	/*@RequestMapping("/search")	
	public String searchProduct(Model model,@Param("keyword") String keyword){
		//String keyword="sdaf";
		List<Product> listProduct=service.listSearch(keyword);
		System.out.println("keyword="+keyword);
		model.addAttribute("listProducts", listProduct);
		model.addAttribute("keyword",keyword);
		return "index";	


	}*/



	/*search and filter*/

	/*@RequestMapping("/")
	public String viewHomePage(Model model) {
		return viewPage(model, 1, "name", "asc");
	}*/
	/* search and filter */
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		String keyword=null;
		return viewPage(model, 1, "name", "asc",keyword);
	}
	@RequestMapping("/page/{pageNum}")
	public String viewPage(Model model, 
			@PathVariable(name = "pageNum") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword")String keyword) {
		
		Page<Product> page = service.listAll(currentPage, sortField, sortDir,keyword);
		
		List<Product> listProducts = page.getContent();
		
		model.addAttribute("currentPage", currentPage);		
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword",keyword);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProducts", listProducts);
		String reverseSortDir=sortDir.equals("asc")?"desc":"asc";
		model.addAttribute("reverseSortDir",reverseSortDir);
		
		return "index";
	}	
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}

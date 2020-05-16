package com.pal.sanjeet.spring.searchandfilter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	/* search*/
	/*public List<Product> listSearch(String keyword){
		if(keyword != null){
			return repo.findAll(keyword);
		}
		return repo.findAll();

	}*/
	/* searchAnd Pagination*/

	public Page<Product> listAll(int currentPage, String sortField, String sortDir,String keyword) {
		
		/*Pageable pageable = PageRequest.of(currentPage - 1, 5, 
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
									  : Sort.by(sortField).descending()
		);*/

		Sort sort=Sort.by(sortField);
		sort=sortDir.equals("asc") ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		Pageable pageable=PageRequest.of(currentPage - 1,6,sort);

		if(keyword!=null){
			return repo.findAll(keyword,pageable);
		}
		
		return repo.findAll(pageable);
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}

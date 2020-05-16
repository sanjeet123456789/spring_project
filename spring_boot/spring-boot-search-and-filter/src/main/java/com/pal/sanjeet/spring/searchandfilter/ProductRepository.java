package com.pal.sanjeet.spring.searchandfilter;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;

//public interface ProductRepository extends JpaRepository<Product, Long> {
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	/* search*/
	
	/*public List<Product> findAll();


	@Query("from Product p WHERE p.name LIKE %?1%"+
		" OR CONCAT(p.brand,p.madein,p.price) LIKE %?1%")
	public List<Product> findAll(String keyword);
	*/




	/* filter */
	@Query("from Product p WHERE p.name LIKE %?1%"+
		" OR CONCAT(p.brand,' ',p.madein,' ',p.price) LIKE %?1%")
	public Page<Product> findAll(String keyword,Pageable pageable);
	


}

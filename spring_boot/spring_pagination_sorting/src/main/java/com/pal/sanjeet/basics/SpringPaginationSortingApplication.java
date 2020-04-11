package com.pal.sanjeet.basics;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class SpringPaginationSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPaginationSortingApplication.class, args);
	}



	@Bean
	public CommandLineRunner init(StudentRepository repository) {
		return args->{
			repository.save(new Student(null, "sanjeet", "bca", 1996));
			repository.save(new Student(null, "pal", "bca", 1996));
			repository.save(new Student(null, "amit", "bca", 1996));
			repository.save(new Student(null, "sagar", "bca", 1996));
			repository.save(new Student(null, "sachin", "bca", 1996));
			repository.save(new Student(null, "deeraj", "bca", 1996));
			repository.save(new Student(null, "rahul", "bca", 1996));
		
		};
		
	}

}
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Student{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String course;
	private int admissionyear;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getAdmissionyear() {
		return admissionyear;
	}
	public void setAdmissionyear(int admissionyear) {
		this.admissionyear = admissionyear;
	}
	public Student(Long id, String name, String course, int admissionyear) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.admissionyear = admissionyear;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", admissionyear=" + admissionyear + "]";
	}
	
	
	
}
interface StudentRepository extends JpaRepository<Student,Long>{
	
	@Query("select s from student s where name like %?1%")
	Page<Student> findByName(String name,Pageable pageable);
	
}

@RequiredArgsConstructor
@RestController
class studentController{
	
	private final StudentRepository repository;
	
	public studentController(StudentRepository repository) {
		this.repository = repository;
	}
	
	
	
	
	@GetMapping("/student")
	public Page<Student> findAll(@RequestParam Optional<String> name,
			@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> SortBy
			
			){
		return repository.findByName(name.orElse("_"),
				PageRequest.of(page.orElse(0), 5, Sort.Direction.DESC,SortBy.orElse("id")));
//				new PageRequest(page.orElse(0),5,Sort.by("id"))); ---depcreated
//		Sort.Direction.ASC
//		,SortBy.orElse("id")
//		Sort.Direction.DESC,"createdAt"
	}
	
}




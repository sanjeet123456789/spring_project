package com.pal.sanjeet.basics;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}
	
	@Bean
	RouterFunction<ServerResponse> routes(ReservationHandler handler){
		return RouterFunctions.route(RequestPredicates.GET("/reservation/{id}"),handler::byId);
	}
}
@Component
class ReservationHandler {
	private final ReservationRepository reservationrepository;
	
	public ReservationHandler(ReservationRepository reservationrepository) {
		super();
		this.reservationrepository = reservationrepository;
	}

	 Mono<ServerResponse> byId(ServerRequest request) {
		// TODO Auto-generated method stub
		 
		 String id=request.pathVariable("id");
		Mono<Reservation> byIdResults=this.reservationrepository.findById(id);
		
		return ServerResponse.ok().body(byIdResults,Reservation.class);
	}
	
}
//@Configuration
//class Reservationconfiguration{
//	@Bean ReservationRestController reservationRestController(ReservationRepository reservationRepository) {
//		return new ReservationRestController(reservationRepository);
//	}
//	@Bean ReservationRepository reservationRepository(MongoDatabase db) {
//		return new ReservationRepository(db);
//	}
//	
//	@Bean MongoDatabase mongodatabase() {
//		return null;
//	}
//}
@RestController
class ReservationRestController{
	private final ReservationRepository reservationRepository;
	public ReservationRestController(ReservationRepository reservationRepository) {
		this.reservationRepository=reservationRepository;
	}
	
//	@GetMapping("/reservation")
//	Flux<Reservation> all(){
//		return this.reservationRepository.findAll();
//	}
}
/*
@ Repository
class ReservationRepository{
//	public ReservationRepository(MongoDatabase db) {
//	}
	private final ReactiveMongoTemplate template;
	
	public ReservationRepository(ReactiveMongoTemplate template) {
	super();
	this.template = template;
}

	public Flux<Reservation> findAll(){
		return this.template.findAll(Reservation.class);
	}
	
}*/
class Initilizer implements ApplicationRunner{
	private final ReservationRepository repo;
	
	public Initilizer(ReservationRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Flux.just("S","T","U","V").map(name->new Reservation(null,name)).flatMap(r->this.repo.save(r))
		.subscribe(r->System.out.println("reservation : "+r.toString()));
//		Flux.just("S","T","U","V").map(name->new Reservation(null,name)).subscribe(r->this.repo.save(r));
		
	}
	
}

interface ReservationRepository extends ReactiveMongoRepository<Reservation,String>{
	//custom search
	Flux<Reservation> findByReservationName(String rn);
}

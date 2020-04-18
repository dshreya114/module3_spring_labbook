package org.cap.controller;

import java.util.List;
import org.cap.dto.TraineeDto;
import org.cap.entities.Trainee;
import org.cap.exceptions.TraineeNotFoundException;
import org.cap.service.ITraineeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
	public class TraineetRestController {

		private static Logger Log= LoggerFactory.getLogger(TraineetRestController.class);
		
	    @Autowired
	    private ITraineeService service;

		@GetMapping("/trainees/find/{id}")
	    public ResponseEntity<Trainee> getProduct(@PathVariable("id") int id) {
			Trainee trainee = service.findById(id);
	        ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, HttpStatus.OK);
	        return response;
	    }

	    @PostMapping("/trainees/add")
	    public ResponseEntity<Trainee> addProductt(@RequestBody TraineeDto dto) {
	    	Trainee trainee = convert(dto);
	       trainee = service.update(trainee);
	        ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, HttpStatus.OK);
	        return response;
	    }

	        Trainee convert(TraineeDto dto) {
	         Trainee trainee = new  Trainee();
	         trainee.setTraineeName(dto.getTraineeName());
	         trainee.setTraineeDomain(dto.getTraineeDomain());;
	         trainee.setTraineeLocation(dto.getTraineeLocation());
	         return trainee;
	    }


	        @GetMapping("/trainees")
		    public ResponseEntity<List<Trainee>> fetchAll() {
		        List<Trainee> trainees = service.fetchAll();
		        ResponseEntity<List<Trainee>> response = new ResponseEntity<>(trainees, HttpStatus.OK);
		        return response;
		    }

	    @DeleteMapping("/products/delete/{id}")
	    public ResponseEntity<Boolean>deleteProduct(@PathVariable("id") int id){
	       boolean result= service.remove(id);
	       ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
	       return response;
	    }

	    @PutMapping("/products/update/{id}")
	    public ResponseEntity<Trainee>updateProduct(@RequestBody TraineeDto dto ,@PathVariable("id") int id){
	    	Trainee  trainee=convert(dto);
	        trainee.setTraineeId(id);
	        trainee = service.update(trainee);
	        ResponseEntity<Trainee>response=new ResponseEntity<>(trainee,HttpStatus.OK);
	        return response;
	    }
	    
	    @ExceptionHandler(TraineeNotFoundException.class)
		public ResponseEntity<String> handleProductNotFound(TraineeNotFoundException exception) {
	        Log.error("handling exception", exception);
	        String exceptionMsg=exception.getMessage();
	        ResponseEntity<String> response = new ResponseEntity<>(exceptionMsg,HttpStatus.NOT_FOUND);
	        return response;
	   }

	    @ExceptionHandler(Throwable.class)
	      public ResponseEntity<String> handleAllExceptions(Throwable exception)
	      {
	    	Log.error("Handling all exceptions",exception);
	    	String msg = "Something went wrong";
	    	ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	    	return response;
	      }
	}


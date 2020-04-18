package org.cap.service;

import java.util.List;
import java.util.Map;

import org.cap.entities.Trainee;
import org.cap.entities.User;

public interface ITraineeService {
	
	Trainee findById(int id);
	Trainee update(Trainee trainee);
	List<Trainee> fetchAll();
	boolean remove(int id);
	
}

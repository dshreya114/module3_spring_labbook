package org.cap.dao;

import java.util.List;
import java.util.Map;

import org.cap.entities.Trainee;
import org.cap.entities.User;

public interface ITraineeDao {

	Trainee findById(int id);
	Trainee update(Trainee trainee);
	boolean remove(int id);
	List<Trainee> fetchAll();
}

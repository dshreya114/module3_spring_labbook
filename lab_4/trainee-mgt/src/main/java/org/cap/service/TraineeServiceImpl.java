package org.cap.service;

import java.util.List;
import javax.transaction.Transactional;
import org.cap.dao.ITraineeDao;
import org.cap.entities.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TraineeServiceImpl implements ITraineeService {
	private ITraineeDao traineeDao;

	public ITraineeDao getTraineeDao() {
		return traineeDao;
	}
	
	@Autowired
	public void setTraineeDao(ITraineeDao traineeDao) {
		this.traineeDao = traineeDao;
	}
		
	
	@Override
	public Trainee findById(int id)
	{
		return traineeDao.findById(id);
	}

	@Override
	public Trainee update(Trainee trainee) {
     	return traineeDao.update(trainee);
	}
	
	@Override
	public List<Trainee> fetchAll() {
      return traineeDao.fetchAll();
	}

	@Override
	public boolean remove(int id) {
		return traineeDao.remove(id);
	}

}

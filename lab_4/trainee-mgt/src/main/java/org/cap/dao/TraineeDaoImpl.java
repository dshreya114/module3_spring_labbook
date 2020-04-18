package org.cap.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.cap.entities.Trainee;
import org.cap.exceptions.TraineeNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class TraineeDaoImpl implements ITraineeDao {
	
	
	private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
	
	@Override
	public Trainee findById(int id) {
		Trainee trainee = entityManager.find(Trainee.class, id);
     if(trainee == null)
     {
    	throw new TraineeNotFoundException("Trainee not found for this id : "+id); 
     }
		return trainee;
	}


	@Override
	public List<Trainee> fetchAll() {
		    String jql = "from Trainee";
	        TypedQuery<Trainee> query = entityManager.createQuery(jql, Trainee.class);
	        List<Trainee> store = query.getResultList();
		return store;
	}
	

	@Override
	public Trainee update(Trainee trainee) {
		return getEntityManager().merge(trainee);
	}

	@Override
	public boolean remove(int id) {
		 Trainee trainee = findById(id);
		 if(trainee == null)
	     {
	    	throw new TraineeNotFoundException("Trainee not found for this id : "+id); 
	     }
		 else
		 getEntityManager().remove(trainee);
		 return true;
	}
}

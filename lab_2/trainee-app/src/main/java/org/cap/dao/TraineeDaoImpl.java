package org.cap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import org.cap.entities.Trainee;
import org.cap.entities.User;
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
    
	 private Map<Integer,Trainee>store=new HashMap<>();
	 private Map<Integer,User> userStore = new HashMap<>();
	
	public TraineeDaoImpl() {
			
		User user1=new User(1,"abcd");
		userStore.put(user1.getId(), user1);
	}
	
	
	 @Override
	public Trainee add(Trainee trainee) {
		 trainee = getEntityManager().merge(trainee);
	        return trainee;
	}

	@Override
	public void delete(int traineeId) {
		entityManager.remove(traineeId);
		
	}

	@Override
	public Trainee modify(Trainee trainee) {
		return null;
	}

	@Override
	public Trainee retrieve(int traineeId) {
		Trainee trainee= entityManager.find(Trainee.class, traineeId);
		return trainee;
	}
	@Override
	public List<Trainee> fetchall() {
		    String jql = "from Trainee";
	        TypedQuery<Trainee> query = entityManager.createQuery(jql, Trainee.class);
	        List<Trainee> store = query.getResultList();
		return store;
	}
	
	@Override
    public boolean credentialsCorrect(int id, String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        User user1 = userStore.get(id);
        if (user1 == null) {
            return false;
        }
        return user1.getPassword().equals(password);
		
    }


	@Override
	public User findId(int id) {
		User user1=userStore.get(id);
		return user1;
	}
}

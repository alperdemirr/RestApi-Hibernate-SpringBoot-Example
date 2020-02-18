package com.bookstore.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.bookstore.entity.User;

@Repository
public class UserRepoImpl implements UserRepository {


    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<User> findAll() {
		List<User> users  = entityManager.createQuery("select u from User u",User.class).getResultList();
		return users;
	}

	@Override
	public User findUserByUserName(String userName,String password) {
		User user  = entityManager.createQuery("from User  where username= :userName AND password= :password",User.class).
				setParameter("userName", userName).setParameter("password", password).getSingleResult();

		return user;
	}
	@Override
	public User findById(int Id) {
		User user  = entityManager.createQuery("from User  where id= :id",User.class).
				setParameter("id", Id).getSingleResult();
		return user;
	}

	@Override
	public int deleteUserById(int id) {	
		return entityManager.createQuery("delete from user id= :id",User.class).setParameter("id", id).executeUpdate();
	}

	@Override
	public int saveUser(User user) {
		if (user.getId() > 0) { // update
		try {
			return entityManager
				     .createQuery("UPDATE User SET name=:name, surname=:surname,username=:username,password=:password where id=:id")
				     .setParameter("name",user.getName())
				     .setParameter("surname",user.getSurname())
				     .setParameter("username",user.getUsername())
				     .setParameter("password",user.getPassword())
				     .setParameter("id", user.getId())
				     .executeUpdate();
		} catch (Exception e) {
			return 0;
		}

			
		} else {
			return entityManager.createNativeQuery("INSERT INTO User(name,surname,username,password) "
					+ "VALUES(?,?,?,?)").
					setParameter(1, user.getName()).
					setParameter(2, user.getSurname()).
					setParameter(3, user.getUsername()).
					setParameter(4, user.getPassword()).
					executeUpdate();
		}
	}

	@Override
	public int deleteUser(int id) {
		
		return entityManager.createNativeQuery("Delete From User where id=:id").setParameter("id", id).executeUpdate();
	}


}

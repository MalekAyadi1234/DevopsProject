package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.entities.User;

import java.util.List;

public interface IUserService {

	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);
}

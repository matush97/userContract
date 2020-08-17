package sk.stuba.fei.zadanie3.functionality;

import org.springframework.stereotype.Service;
import sk.stuba.fei.zadanie3.user.Adress;
import sk.stuba.fei.zadanie3.user.User;

import java.util.List;
import java.util.Optional;


public interface SchemeUserService {
    void addUser(User user);
    void editUser(int id, String newName, String newSurName, String newEmail, Adress newPermanentAdress, Adress newCorrespondenceAddress);
    List<User> print();
    Optional<User> findUserById(int id);
    List<User> getUsers();
    void editUserById(int id, User user);

}

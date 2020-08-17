package sk.stuba.fei.zadanie3.functionality;

import org.springframework.stereotype.Service;
import sk.stuba.fei.zadanie3.user.Adress;
import sk.stuba.fei.zadanie3.user.User;

import java.util.*;

@Service
public class SchemeUser implements SchemeUserService {
    private  List<User> users = new LinkedList<>();

    //konstruktor
//    public SchemeUser() {
//        this.users = new LinkedList<>();
//    }

    //  pridavanie usera
    public void addUser(User user){
        users.add(user);
    }
    // Úprava existujúceho používateľa
    public void editUser(int id, String newName, String newSurName, String newEmail, Adress newPermanentAdress,Adress newCorrespondenceAddress){
        for (User user: users) {
            if (user.getID() == id){
                user.setName(newName);
                user.setSurname(newSurName);
                user.setEmail(newEmail);
                user.setPermanentAddress(newPermanentAdress);
                user.setCorrespondenceAddress(newCorrespondenceAddress);
                System.out.println(user);
            }
        }
    }
    //Úprava existujúceho používateľa podla ID
    public void editUserById(int id, User user){
        for (User user1:users){
            if (user1.getID() == id){
                user1.setName(user.getName());
                user1.setSurname(user.getSurname());
                user1.setPersonalNumber(user.getPersonalNumber());
                user1.setEmail(user.getEmail());
                user1.setPermanentAddress(user.getPermanentAddress());
            }
        }
    }

    //  metoda na vyprintovanie kazdeho pouzivatela
    public List<User> print(){
//        for (User user: users) {
//            System.out.println(user);
//        }
        return users;
    }

    // Metoda na najdenie uzivatela podla ID
    public Optional<User> findUserById(int id){
        return users.stream()
                .filter(user -> user.getID() == id).findFirst();
    }

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Scheme{" +
                "users=" + users +
                '}';
    }
}

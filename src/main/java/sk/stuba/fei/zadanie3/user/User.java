package sk.stuba.fei.zadanie3.user;


import sk.stuba.fei.zadanie3.contract.Contract;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class User {
    private int ID; //unikátny číselný identifikátor
    @NotEmpty
    @Size(min = 1)
    private String name;
    @NotEmpty
    @Size(min = 1)
    private String surname;
    @NotEmpty
    @Size(min = 1)
    private String personalNumber; //rodne cislo
    @NotNull
    @Email
    private String email;
    //---------------------------------------------------//
    @Valid
    private Adress permanentAddress; //adresa trvalého pobytu
    private Adress correspondenceAddress; // TODO korešpondenčná adresa
    private boolean sameCorrespodenceAddress;
    private List<Contract> catalogContract = new LinkedList<>(); //TODO zoznam zmlúv (zmluvy uzatvorené používateľom)
    //---------------------------------------------------//

    public User(int ID) {
        setID(ID);
        setName(name);
        setSurname(surname);
        setPersonalNumber(personalNumber);
        setEmail(email);
        setPermanentAddress(permanentAddress);
        setCorrespondenceAddress(correspondenceAddress); //ak nebude vyplnene toto dame tam permanentAddress
    }
    public User() {
        setID(ID);
        setName(name);
        setSurname(surname);
        setPersonalNumber(personalNumber);
        setEmail(email);
        setPermanentAddress(permanentAddress);
        setCorrespondenceAddress(correspondenceAddress); //ak nebude vyplnene toto dame tam permanentAddress

    }

    public User(int ID, String name, String surname, String personalNumber, String email, Adress permanentAddress, Adress correspondenceAddress) {
        setID(ID);
        setName(name);
        setSurname(surname);
        setPersonalNumber(personalNumber);
        setEmail(email);
        setPermanentAddress(permanentAddress);
        setCorrespondenceAddress(correspondenceAddress); //ak nebude vyplnene toto dame tam permanentAddress
    }

    public User(int ID, String name, String surname, String personalNumber, String email, Adress permanentAddress) {
        this(ID,name,surname,personalNumber,email,permanentAddress,permanentAddress);
        // TODO pouzil som this aby som nemal zbytocne duplicitny kod
    }

    //Založenie poistnej zmluvy používateľovi
//    public void addContractToUser(int idContract){
//        catalogContract.add(idContract);
//    }
    public void addContract(Contract contract){
        for(Contract myContract : catalogContract){
            if(myContract.getId() == contract.getId()){
                throw new IllegalArgumentException("Invalid contract ID - contract with this ID already exists");
            }
        }
        catalogContract.add(contract);
    }

    //
    //TODO GETTRE A SETTRE PRE TRIEDU USER
    public int getID() { return ID; }
    public void setID(int ID) {
//        if (ID < 0){
//            throw new IllegalArgumentException("ID must be positive number");
//        }
        this.ID = ID;
    }

    public String getName() { return name; }
    public void setName(String name) {
//        if (name == null|| name.trim().isEmpty()){
//            throw new IllegalArgumentException("It miss name");
//        }
        this.name = name;
    }

    public String getSurname() { return surname; }
    public void setSurname(String surname) {
//        if (surname == null || surname.trim().isEmpty()){
//            throw new IllegalArgumentException("It miss surname");
//        }
        this.surname = surname;
    }

    public String getPersonalNumber() { return personalNumber; }
    public void setPersonalNumber(String personalNumber) {
//        if (personalNumber == null){
//            throw new IllegalArgumentException("It miss personalNumber");
//        }
        this.personalNumber = personalNumber;
    }
    @Email
    @NotEmpty
    public String getEmail() { return email; }
    public void setEmail(String email) {
//        if (email == null || email.trim().isEmpty()){
//            throw new IllegalArgumentException("It miss email");
//        }
        this.email = email;
    }

    @NotNull
    public Adress getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(Adress permanentAddress) {
//        if (permanentAddress == null){
//            throw new IllegalArgumentException("permanent adress is null");
//        }
        this.permanentAddress = permanentAddress;
    }

    public Adress getCorrespondenceAddress() { return correspondenceAddress; }
    public void setCorrespondenceAddress(Adress correspondenceAddress) {
//        if (correspondenceAddress == null){
//            throw new IllegalArgumentException("correspondence adress is null");
//        }
        this.correspondenceAddress = correspondenceAddress;
    }

    public List<Contract> getCatalogContract() {
        return catalogContract;
    }

    public void setCatalogContract(List<Contract> catalogContract) {
        this.catalogContract = catalogContract;
    }

    public boolean isSameCorrespodenceAddress() {
        return sameCorrespodenceAddress;
    }

    public void setSameCorrespodenceAddress(boolean sameCorrespodenceAddress) {
        if (permanentAddress != correspondenceAddress){
            return;
        }
        this.sameCorrespodenceAddress = sameCorrespodenceAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", email='" + email + '\'' +
                ", permanentAddress=" + permanentAddress +
                ", correspondenceAddress=" + correspondenceAddress +
                '}';
    }
}

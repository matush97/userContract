package sk.stuba.fei.zadanie3.functionality;

import org.springframework.stereotype.Service;
import sk.stuba.fei.zadanie3.contract.Contract;
import sk.stuba.fei.zadanie3.user.User;

import java.util.*;

@Service
public class SchemeContract implements SchemeContractService {
    private List<Contract> contracts= new LinkedList<>();
    private List<User> users= new LinkedList<>();
    private Map<User,Contract> category;

    public void addContract(Contract contract){
        contracts.add(contract);
    }


    //Založenie poistnej zmluvy používateľovi
    public void creatingInsurenceUser(int idContract,int idUser){
        for (User user: users) {
            if (user.getID() == idUser ){
                for (Contract contract: contracts) {
                    if (contract.getId() == idContract){
                        category.put(user,contract);
                    }
                }
            }
        }
    }

    //Vylistovanie všetkých poistných zmlúv
    public List<Contract> printContracts(){
//        for (Contract contract: contracts) {
//            System.out.println(contract);
//        }
        return contracts;
    }

    //Úprava existujúcej zmluvy
    public void editContract(int id,String newEndDate,int newAmaunt,int newMonthlyPayment){
        for (Contract contract: contracts) {
            if(contract.getId() == id){
                contract.setEndDate(newEndDate);
                contract.setAmaunt(newAmaunt);
                contract.setMonthlyPayment(newMonthlyPayment);
            }
        }
    }
    //Úprava existujúcej zmluvy podla ID
    public void editContractById(int id,Contract contract){
        for (Contract contract1: contracts) {
            if(contract1.getId() == id){
                contract1.setDate(contract.getDate());
                contract1.setStartDate(contract.getStartDate());
                contract1.setEndDate(contract.getEndDate());
                contract1.setAmaunt(contract.getAmaunt());
                contract1.setMonthlyPayment(contract.getMonthlyPayment());
            }
        }
    }
    // Metoda na najdenie zmluvy podla ID
    public Optional<Contract> findContractByid(int id){
        return contracts.stream()
                .filter(contract -> contract.getId() == id).findFirst();
    }
    //Gettre a Settre
    public List<Contract> getContracts() {
        return contracts;
    }
    }


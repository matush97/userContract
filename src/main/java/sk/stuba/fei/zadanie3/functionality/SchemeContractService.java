package sk.stuba.fei.zadanie3.functionality;

import sk.stuba.fei.zadanie3.contract.Contract;

import java.util.List;
import java.util.Optional;

public interface SchemeContractService {
    void addContract(Contract contract);
    void creatingInsurenceUser(int idContract,int idUser);
    List<Contract> printContracts();
    void editContract(int id,String newEndDate,int newAmaunt,int newMonthlyPayment);
    List<Contract> getContracts();
    Optional<Contract> findContractByid(int id);
    void editContractById(int id,Contract contract);
}

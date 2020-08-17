package sk.stuba.fei.zadanie3;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import sk.stuba.fei.zadanie3.contract.Contract;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.HouseApartmentInsurance;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.HouseholdInsurance;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.TypeProperty;
import sk.stuba.fei.zadanie3.functionality.SchemeContract;
import sk.stuba.fei.zadanie3.functionality.SchemeUser;
import sk.stuba.fei.zadanie3.user.Adress;
import sk.stuba.fei.zadanie3.user.User;

@Slf4j
@Controller
@SpringBootApplication
public class Zadanie3Application implements CommandLineRunner {

    private final SchemeUser schemeUser;
    private final SchemeContract schemeContract;

    public Zadanie3Application(SchemeUser schemeUser, SchemeContract schemeContract) {
        this.schemeUser = schemeUser;
        this.schemeContract = schemeContract;
    }

    public static void main(String[] args) {
        SpringApplication.run(Zadanie3Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //Person n.1
        Adress adress = new Adress("08501","Bardejov","Mlyny","55");
        User user = new User(1,"Matúš","Hudák","976365","hudym97@gmail.com",adress);
        schemeUser.addUser(user);

        //Person n.2
        User user1 = new User(2,"Peter","Sokol","58648","peters92@gmail.com",adress);
        schemeUser.addUser(user1);

        //Contract
        Adress adress1 = new Adress("25896","Bratislava","Komenskeho","222");
        Contract contract = new HouseApartmentInsurance(1,"22.2.1997",user,"22.2.1997","16.8.2300",20000,20, TypeProperty.FLAT,adress1,200,200);
        Contract contract1 = new HouseholdInsurance(2,"5.5.2015",user,"5.5.2015","15.6.2090",500000,5,TypeProperty.HOUSE_WOOD,adress1,500,60);
        schemeContract.addContract(contract);
        schemeContract.addContract(contract1);

    }

}

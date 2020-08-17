package sk.stuba.fei.zadanie3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.zadanie3.contract.Contract;
import sk.stuba.fei.zadanie3.contract.lifeInsurence.AccidentInsurance;
import sk.stuba.fei.zadanie3.contract.lifeInsurence.TravelInsurence;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.HouseApartmentInsurance;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.HouseholdInsurance;
import sk.stuba.fei.zadanie3.contract.nonlifesurence.TypeProperty;
import sk.stuba.fei.zadanie3.functionality.SchemeContractService;
import sk.stuba.fei.zadanie3.functionality.SchemeUserService;
import sk.stuba.fei.zadanie3.user.User;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private final SchemeContractService schemeContractService;
    private final SchemeUserService schemeUserService;
    @Autowired
    public ContractController(SchemeContractService schemeContractService, SchemeUserService schemeUserService) {
        this.schemeContractService = schemeContractService;
        this.schemeUserService = schemeUserService;
    }

    @GetMapping("/")
    public String findAllContracts(Model model){
        model.addAttribute("schemeContract",schemeContractService.printContracts());
        return "contract/allContracts";
    }


    //TODO pridanie zmluvy pre house a  apartmant
    @GetMapping("/add/addHouseApartman/{id}")
    public String addHouseApartman(@PathVariable int id, Model model){
        HouseApartmentInsurance contract= new HouseApartmentInsurance();
        contract.setId(schemeContractService.getContracts().size()+1);


        model.addAttribute("houseApartmantInsurance",contract);
        model.addAttribute("typeProperties", TypeProperty.values());
        return "contract/add/addHouseApartman";
    }

    @PostMapping("/add/addHouseApartman/{id}")
    public String addHouseApartman(@PathVariable int id, @ModelAttribute @Valid HouseApartmentInsurance houseApartmentInsurance, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "contract/addHouseApartman";
        }
        User user = new User();
        user.setID(id);
        houseApartmentInsurance.setUser(user);
        //schemeContractService.creatingInsurenceUser(houseApartmentInsurance.getId(),id);
        Optional<User> userById = schemeUserService.findUserById(id);
        if(userById.isPresent()){
            User user1 = userById.get();
            user1.addContract(houseApartmentInsurance);
            schemeContractService.addContract(houseApartmentInsurance);
            model.addAttribute("user",user1);
        }
        return "/user/one";
    }
    //change pre house a apartman
    @GetMapping("/change/{id}")
    public String changeHouseApartman(@PathVariable int id,Model model){
        Optional<Contract> contract = schemeContractService.findContractByid(id);
        if(contract.isPresent()){
            Contract contract1 = contract.get();
            model.addAttribute("HouseApartmentInsurance",(HouseApartmentInsurance)contract1);
            model.addAttribute("typeProperties1", TypeProperty.values());
        }
        return "/contract/change/changeHouseApartman";
    }

    @PostMapping("/change/changeHouseApartman/{id}")
    public String changeToDatabseHouseApartman(@PathVariable int id,@ModelAttribute HouseApartmentInsurance houseApartmentInsurance){
        schemeContractService.editContractById(id,houseApartmentInsurance);
        //return "index";
        return  "redirect:/";
    }

    //detaily zmluvy
    @GetMapping("one/{id}")
    public String detailsContractHouseApartman(@PathVariable int id, Model model){
        Optional<Contract> contract = schemeContractService.findContractByid(id);
        if(contract.isPresent()){
            Contract contract1 = contract.get();
            model.addAttribute("houseApartmanOne",(HouseApartmentInsurance)contract1);

        }
        return "/contract/one/oneHouseApartman";
    }


    //TODO pridanie zmluvy pre Poistenie domácnosti
    @GetMapping("/add/addHouseholdInsurance/{id}")
    public String addHouseholdInsurance(@PathVariable int id, Model model){
        HouseholdInsurance contract = new HouseholdInsurance();
        contract.setId(schemeContractService.getContracts().size()+1);
        model.addAttribute("householdInsurance",contract);
        model.addAttribute("typeProperties", TypeProperty.values());
        return "contract/add/addHouseholdInsurance";
    }
    @PostMapping("/add/addHouseholdInsurance/{id}")
    public String addHouseholdInsurance(@PathVariable int id, @ModelAttribute HouseholdInsurance householdInsurance,Model model){
        User user = new User();
        user.setID(id);
        householdInsurance.setUser(user);
        Optional<User> userById = schemeUserService.findUserById(id);
        if(userById.isPresent()){
            User user1 = userById.get();
            user1.addContract(householdInsurance);
            schemeContractService.addContract(householdInsurance);
            model.addAttribute("user",user1);
        }
        return "/user/one";

    }

    //detaily zmluvy
//    @GetMapping("one/oneHouseholdInsurance/{id}")
//    public String detailsContractHouseHold(@PathVariable int id, Model model) {
//        Optional<Contract> contract = schemeContractService.findContractByid(id);
//        if (contract.isPresent()) {
//            Contract contract1 = contract.get();
//            model.addAttribute("oneHouseHold", (HouseholdInsurance) contract1);
//
//        }
//        return "/contract/one/oneHouseholdInsurance";
//    }
    //change pre Poistenie domácnosti
//    @GetMapping("/change/{id}")
//    public String changeHouseHoldInsurence(@PathVariable int id,Model model){
//        Optional<Contract> contract = schemeContractService.findContractByid(id);
//        if(contract.isPresent()){
//            Contract contract1 = contract.get();
//            model.addAttribute("HouseholdInsurance",(HouseholdInsurance)contract1);
//            model.addAttribute("typeProperties1", TypeProperty.values());
//        }
//        return "/contract/change/changeHouseHoldInsurence";
//    }
//
//    @PostMapping("/change/changeHouseHoldInsurence/{id}")
//    public String changeToDatabseHouseHoldInsurence(@PathVariable int id,@ModelAttribute HouseholdInsurance householdInsurance){
//        schemeContractService.editContractById(id,householdInsurance);
//        return "index";
//    }

    //TODO pridanie zmluvy zivotne AccidentInsurance
    @GetMapping("/add/addAccidentInsurance/{id}")
    public String addAccidentInsurance(@PathVariable int id, Model model){
        AccidentInsurance contract = new AccidentInsurance();
        contract.setId(schemeContractService.getContracts().size()+1);
        model.addAttribute("accidentInsurance",contract);
        model.addAttribute("typeProperties", TypeProperty.values());
        return "contract/add/addAccidentInsurance";
    }
    @PostMapping("/add/addAccidentInsurance/{id}")
    public String addAccidentInsuranceToDatabase(@PathVariable int id, @ModelAttribute AccidentInsurance accidentInsurance,Model model){
        User user = new User();
        user.setID(id);
        accidentInsurance.setUser(user);
        Optional<User> userById = schemeUserService.findUserById(id);
        if(userById.isPresent()){
            User user1 = userById.get();
            user1.addContract(accidentInsurance);
            schemeContractService.addContract(accidentInsurance);
            model.addAttribute("user",user1);
        }
        return "/user/one";

    }

    //TODO pridanie zmluvy zivotne TravelInsurance
    @GetMapping("/add/addTravelInsurence/{id}")
    public String addTravelInsurence(@PathVariable int id, Model model){
        TravelInsurence contract = new TravelInsurence();
        contract.setId(schemeContractService.getContracts().size()+1);
        model.addAttribute("travelInsurence",contract);
        model.addAttribute("typeProperties", TypeProperty.values());
        return "contract/add/addTravelInsurence";
    }
    @PostMapping("/add/addTravelInsurence/{id}")
    public String addTravelInsurenceToDatabase(@PathVariable int id, @ModelAttribute AccidentInsurance accidentInsurance,Model model){
        User user = new User();
        user.setID(id);
        accidentInsurance.setUser(user);
        Optional<User> userById = schemeUserService.findUserById(id);
        if(userById.isPresent()){
            User user1 = userById.get();
            user1.addContract(accidentInsurance);
            schemeContractService.addContract(accidentInsurance);
            model.addAttribute("user",user1);
        }
        return "/user/one";

    }
}

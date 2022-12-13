package com.example.bank;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
public class controller {

    ArrayList<customers> cust = new ArrayList<>();
    @GetMapping("/customers")
    public ArrayList<customers> getCust(){
        return cust;
    }
    @PostMapping("/add")
    public ApiResbonse addCust(@RequestBody customers C){

        cust.add(C);
        return new ApiResbonse("Customer added");
    }
    @PutMapping("/update/{index}")
    public ApiResbonse updateCust(@PathVariable int index,@RequestBody customers C){
        cust.set(index,C);
        return new ApiResbonse("Customer updatede");
    }
    @DeleteMapping("/{index}")
    public String delateCust(@PathVariable int index){

        cust.remove(index);
        return "Customer deleted";
    }
    @PutMapping("/deposit/{amount}/{ID}")
    public ApiResbonse depositMony(@PathVariable int amount ,@PathVariable int ID){
        cust.get(ID).setBalance( cust.get(ID).getBalance() + amount);
        return new ApiResbonse("Deposit successful");
    }
    @PutMapping("/witdraw/{amount}/{ID}")
    public ApiResbonse witdrawMony(@PathVariable int amount ,@PathVariable int ID){
        cust.get(ID).setBalance( cust.get(ID).getBalance() - amount);
        return new ApiResbonse("witdraw successful");
    }



}

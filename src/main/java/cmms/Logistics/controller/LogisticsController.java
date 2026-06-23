package cmms.Logistics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Logistics")
public class LogisticsController {



    @GetMapping("/checking")
    public String Checkings(){
        return "Input Checking for the Logistics GetMapping";
    }


}

package sg.edu.nus.iss.day12_workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.edu.nus.iss.day12_workshop.model.Image;
import sg.edu.nus.iss.day12_workshop.service.RandomNumService;

    // random number generator controller

    //we are not returning a json, so just use controller
    @Controller
    //@RequestMapping(path="/api")
    //can comment out because we only have one class, but the url will change with this removed.
    //becomes localhost:8080/home instead of localhost:8080/api/home.
    //in a real setting this must be present
    public class RNGController{

        //injecting service class dependency
        @Autowired
        RandomNumService service;

        @GetMapping("/home") //this implies we need to create home.html because we are returning home as a string
        public String landingPage(){
            return "home";

        }

        @GetMapping("/get") //we wrote the html as get hence change
        public String generateRanNumbers(Model model, HttpServletRequest request){
            
            //integer parseint because the incoming value is a string
            int number = Integer.parseInt(request.getParameter("number"));

            System.out.println("input no is: " + number);

            //check condition number range between 1 to 30 only
            if (number <1 || number > 30){

                String errorMessage = "Invalid Number: " + number;
                model.addAttribute("errorMessage", errorMessage);
                //model.addAttribute("errorMessage","Invalid number");
                return "home";
            }

            //calling service method to generate random numbers
            List<Integer> randomNumbers = service.generateRanNumbers(number);

            //populate image objects and create list of Image objects
            List<Image> imageList = new ArrayList<Image>();

            for(int randomNumber : randomNumbers){
                imageList.add(new Image(Integer.toString(randomNumber), "/images/"+Integer.toString(randomNumber)+".png"));
            }
            System.out.println("image list :" + imageList);
    
            model.addAttribute(imageList);

            return "display";

        }


    }
    


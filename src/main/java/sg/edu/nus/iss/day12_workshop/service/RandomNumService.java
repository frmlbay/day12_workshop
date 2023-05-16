package sg.edu.nus.iss.day12_workshop.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

//to tell the (?) to create beans for this class
@Service
public class RandomNumService {

        public List<Integer> generateRanNumbers(int number) {

            return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList());
    
        }


}

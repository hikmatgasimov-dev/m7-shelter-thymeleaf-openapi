package lv.bootcamp.shelter.controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lv.bootcamp.shelter.service.AnimalService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AnimalPageController {
    private  final  AnimalService animalService;

    @GetMapping("/")
    public  String index(){
        return "index";
    }
    @GetMapping("/animals")
    public  String listAnimals(Model model){
        model.addAttribute("animals",animalService.findAll());
        return "animals";
    }
}

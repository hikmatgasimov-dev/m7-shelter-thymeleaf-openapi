package lv.bootcamp.shelter.controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lv.bootcamp.shelter.service.AnimalService;
import org.springframework.stereotype.Controller;
import lv.bootcamp.shelter.form.AnimalForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/animals/new")
    public  String newAnimalForm(Model model){
        model.addAttribute("form",new AnimalForm(null,null,null,null,null,null));
        return "animals-new";
    }

    @PostMapping("/animals")
    public  String createAnimal(@ModelAttribute("form") AnimalForm form){
       animalService.createFromForm(form);
       return "redirect:/animals";
    }

}

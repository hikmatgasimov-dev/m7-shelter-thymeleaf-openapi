package lv.bootcamp.shelter.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lv.bootcamp.shelter.service.AnimalService;
import org.springframework.stereotype.Controller;
import lv.bootcamp.shelter.form.AnimalForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AnimalPageController {
    private final AnimalService animalService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/animals")
    public String listAnimals(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return "animals";
    }

    @GetMapping("/animals/new")
    public String newAnimalForm(Model model) {
        model.addAttribute("form", new AnimalForm(null, null, null, null, null, null));
        return "animals-new";
    }

    @PostMapping("/animals")
    public String createAnimal(@Valid @ModelAttribute("form") AnimalForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "animals-new";
        }
        animalService.createFromForm(form);
        redirectAttributes.addFlashAttribute("message", form.name() + " was added to the shelter.");
        return "redirect:/animals";
    }
    @GetMapping("/login")
    public String login() {

        return "login";
    }
    @GetMapping("/animals/{id}/edit")
    public  String editAnimalForm(@PathVariable Long id,Model model,RedirectAttributes redirectAttribute){

        return animalService.findById(id)
                .map(animal->{
                    model.addAttribute("form",new AnimalForm(animal.name(),animal.type(),animal.breed(),animal.age(), animal.description(),animal.imageUrl()));
                    model.addAttribute("animalId",id);
                    return  "animals-edit";
                })
                .orElseGet(()->{
                           redirectAttribute.addFlashAttribute("error","Animal not found");
                    return  "redirect:/animals";

                });
    }
    @PostMapping("/animals/{id}/edit")
    public  String updateAnimal(@PathVariable Long id,@Valid @ModelAttribute("form") AnimalForm form,
                                BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes){


        if(bindingResult.hasErrors()){
            model.addAttribute("animalId",id);
            return "animals-edit";
        }
        if(animalService.update(id,form).isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Animal not found.");
                    }
        else{
            redirectAttributes.addFlashAttribute("message", form.name() + " was updated.");
        }
        return  "redirect:/animals";
    }

}

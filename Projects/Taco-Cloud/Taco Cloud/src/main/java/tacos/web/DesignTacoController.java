package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.IngredientRepository;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,Errors result, @ModelAttribute TacoOrder tacoOrder){

        if(result.hasErrors()){
            return "design";
        }

        tacoOrder.addTaco(taco);
//        model.addAttribute("tacoOrder", new TacoOrder());
        log.info("Processing Taco: {}", taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

//    private Iterable<Ingredient> filterByType(
//            List<Ingredient> ingredients, Type type) {
//        return ingredients
//                .stream()
//                .filter(x -> x.getType().equals(type))
//                .collect(Collectors.toList());
//    }
}
package tacos.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import tacos.TacoOrder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import tacos.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepo;
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    @GetMapping("/current")
    public String orderForm(@ModelAttribute("tacoOrder") TacoOrder tacoOrder){
//        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors result,
                               SessionStatus sessionStatus) {
        if(result.hasErrors()){
            return "orderForm";
        }
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}

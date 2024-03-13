package pl.mirekgab.productionorder.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Controller
public class ProductionOrderController {

    private final ProductionOrderRepository repository;
    private final InputResourceRepository inputResourceRepository;


    public ProductionOrderController(ProductionOrderRepository repository, InputResourceRepository inputResourceRepository) {
        this.repository = repository;
        this.inputResourceRepository = inputResourceRepository;
    }


    @GetMapping("/orders")
    public String orders(Model model) {
        List<ProductionOrder> allOrders = repository.findAll();
        model.addAttribute("orders", allOrders);
        return "orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String order(Model model, @PathVariable Long id) {
        ProductionOrder productionOrder = repository.findById(id).get();
        model.addAttribute("productionOrder", productionOrder);
        return "order";
    }

    @GetMapping("/orders/add")
    public String addOrder(Model model) {
        model.addAttribute("productionOrder", new ProductionOrder());
        return "order";
    }

    @GetMapping("/orders/details/{id}")
    public String showOrder(Model model, @PathVariable Long id) {
        ProductionOrder productionOrder = repository.findById(id).get();
        model.addAttribute("productionOrder", productionOrder);
        return "orderDetails";
    }

    @PostMapping("/orders/save")
    public String orderUpdate(ProductionOrder productionOrder) {
        repository.save(productionOrder);
        return "redirect:/orders";
    }

    @GetMapping("/orders/details/{orderId}/delete/{materialId}")
    public String deleteMaterialFromOrder(@PathVariable Long orderId, @PathVariable Long materialId) {
        ProductionOrder order = repository.findById(orderId).get();
        Set<InputResource> setInputResources = order.getInputResources();
        InputResource inputResource1 = setInputResources
                .stream()
                .filter(inputResource -> inputResource.getMaterial().getId()==materialId)
                .findFirst()
                .get();

        inputResourceRepository.delete(inputResource1);

        return "redirect:/orders/details/"+orderId;
    }


}

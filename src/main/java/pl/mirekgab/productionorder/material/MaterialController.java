package pl.mirekgab.productionorder.material;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mirekgab.productionorder.measureunit.MeasureUnit;
import pl.mirekgab.productionorder.measureunit.MeasureUnitRepository;

import java.util.List;

@Controller
public class MaterialController {
    private final MaterialRepository repository;
    private final MeasureUnitRepository measureUnitRepository;

    public MaterialController(MaterialRepository repository, MeasureUnitRepository measureUnitRepository) {
        this.repository = repository;
        this.measureUnitRepository = measureUnitRepository;
    }

    @GetMapping("/materials")
    public String materials(Model model) {
        model.addAttribute("materials", repository.findAll());
        return "/material/materials";
    }

    @GetMapping("/materials/add")
    public String addMaterial(Model model) {
        model.addAttribute("material", new Material());
        return "/material/material";
    }

    @GetMapping("/materials/edit/{id}")
    public String editMaterial(Model model, @PathVariable Long id) {
        Material material = repository.findById(id).get();
        model.addAttribute("material", material);

        List<MeasureUnit> measureUnitList = measureUnitRepository.findAll();
        model.addAttribute("measureUnitList", measureUnitList);
        return "/material/material";
    }

    @PostMapping("/materials/save")
    public String save(Material material) {
        repository.save(material);
        return "redirect:/materials";
    }
}

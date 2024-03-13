package pl.mirekgab.productionorder.measureunit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MeasureUnitController {
    private final MeasureUnitRepository repository;

    public MeasureUnitController(MeasureUnitRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/measure-units")
    public String measureUnitsList(Model model) {
        model.addAttribute("measureUnits", repository.findAll());
        return "/measure_unit/measure_units";
    }

    @GetMapping("/measure-units/add")
    public String add(Model model) {
        model.addAttribute("measureUnit", new MeasureUnit());
        return "/measure_unit/measure_unit";
    }

    @PostMapping("/measure-units/save")
    public String save(Model model, MeasureUnit measureUnit) {
        repository.save(measureUnit);
        return "redirect:/measure-units";
    }
}

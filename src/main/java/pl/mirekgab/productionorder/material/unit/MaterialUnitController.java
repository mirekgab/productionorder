package pl.mirekgab.productionorder.material.unit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mirekgab.productionorder.material.Material;
import pl.mirekgab.productionorder.material.MaterialRepository;
import pl.mirekgab.productionorder.measureunit.MeasureUnitRepository;

import java.util.Optional;
import java.util.Set;

@Controller
public class MaterialUnitController {
    private final MaterialUnitRepository materialUnitRepository;
    private final MaterialRepository materialRepository;
    private final MeasureUnitRepository measureUnitRepository;

    public MaterialUnitController(MaterialUnitRepository materialUnitRepository, MaterialRepository materialRepository, MeasureUnitRepository measureUnitRepository) {
        this.materialUnitRepository = materialUnitRepository;
        this.materialRepository = materialRepository;
        this.measureUnitRepository = measureUnitRepository;
    }

    @GetMapping("/materials/{materialId}/units/")
    public String materialUnitsList(@PathVariable Long materialId, Model model) {
        model.addAttribute("material", materialRepository.findById(materialId).get());
        Set<MaterialUnit> materialUnitList = materialUnitRepository.findAllByMaterialId(materialId);
        model.addAttribute("materialUnitList", materialUnitList);
        return "/material/unit/list";
    }

    @GetMapping("/materials/units/{materialUnitId}/edit")
    public String editMaterialUnit(@PathVariable Long materialUnitId, Model model) {

        MaterialUnit materialUnit = materialUnitRepository.findById(materialUnitId).get();

        MaterialUnitMapper mapper = new MaterialUnitMapper();
        MaterialUnitDto materialUnitDto = mapper.mapToDto(materialUnit);

        model.addAttribute("materialUnit", materialUnitDto);
        return "/material/unit/edit";
    }

    @PostMapping("/materials/units/save")
    public String saveMaterialUnit(MaterialUnitDto dto) {
        MaterialUnit materialUnit = materialUnitRepository.findById(dto.getMaterialUnitId()).get();
        materialUnit.setFactor(dto.getFactor());
        materialUnitRepository.save(materialUnit);
        return "redirect:/materials/"+materialUnit.getId()+"/units/";
    }

    @PostMapping("/materials/units/create")
    public String createMaterialUnit(MaterialUnitDto dto) {
        MaterialUnit materialUnit = new MaterialUnit();
        materialUnit.setFactor(dto.getFactor());
        materialUnit.setMaterial(materialRepository.findById(dto.getMaterialId()).get());
        materialUnit.setMeasureUnit(measureUnitRepository.findById(dto.getMeasureUnitId()).get());
        materialUnitRepository.save(materialUnit);
        return "redirect:/materials/"+dto.getMaterialId()+"/units/";
    }

    @GetMapping("/materials/{materialId}/unit/add")
    public String newMaterialUnit(Model model, @PathVariable Long materialId) {

        Material material = materialRepository.findById(materialId).get();

        MaterialUnitDto dto = new MaterialUnitDto();
        dto.setMaterial(material);
        model.addAttribute("materialUnit", dto);
        model.addAttribute("measureUnitList", measureUnitRepository.findAll());
        return "/material/unit/add";
    }

    @GetMapping("/materials/units/{materialUnitId}/delete")
    public String deleteMaterialUnit(@PathVariable Long materialUnitId) {

        MaterialUnit materialUnit = materialUnitRepository.findById(materialUnitId).get();

        materialUnitRepository.deleteById(materialUnitId);

        return "redirect:/materials/"+materialUnit.getMaterial().getId()+"/units/";
    }
}

package pl.mirekgab.productionorder.material.unit;

public class MaterialUnitMapper {

    public MaterialUnitDto mapToDto(MaterialUnit materialUnit) {
        MaterialUnitDto dto = new MaterialUnitDto();

        dto.setMaterialId(materialUnit.getMaterial().getId());
        dto.setMaterialName(materialUnit.getMaterial().getName());
        dto.setMaterialBaseMeasureUnitId(materialUnit.getMaterial().getBaseMeasureUnit().getId());
        dto.setMaterialBaseMeasureUnitName(materialUnit.getMaterial().getBaseMeasureUnit().getName());

        dto.setMaterialUnitId(materialUnit.getId());
        dto.setUnitName(materialUnit.getMeasureUnit().getName());
        dto.setFactor(materialUnit.getFactor());
        dto.setMeasureUnitId(materialUnit.getMeasureUnit().getId());

        return dto;
    }

}

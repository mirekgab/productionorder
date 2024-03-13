package pl.mirekgab.productionorder.material.unit;

import pl.mirekgab.productionorder.material.Material;

public class MaterialUnitDto {
    private Long materialUnitId;
    private Long materialId;
    private String materialName;
    private Long materialBaseMeasureUnitId;
    private String materialBaseMeasureUnitName;
    private Long measureUnitId;
    private String unitName;
    private double factor;

    public Long getMaterialUnitId() {
        return materialUnitId;
    }

    public void setMaterialUnitId(Long materialUnitId) {
        this.materialUnitId = materialUnitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public Long getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(Long measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Long getMaterialBaseMeasureUnitId() {
        return materialBaseMeasureUnitId;
    }

    public void setMaterialBaseMeasureUnitId(Long materialBaseMeasureUnitId) {
        this.materialBaseMeasureUnitId = materialBaseMeasureUnitId;
    }

    public String getMaterialBaseMeasureUnitName() {
        return materialBaseMeasureUnitName;
    }

    public void setMaterialBaseMeasureUnitName(String materialBaseMeasureUnitName) {
        this.materialBaseMeasureUnitName = materialBaseMeasureUnitName;
    }

    public void setMaterial(Material material) {
        this.materialId = material.getId();
        this.materialName = material.getName();
        this.materialBaseMeasureUnitId = material.getBaseMeasureUnit().getId();
        this.materialBaseMeasureUnitName = material.getBaseMeasureUnit().getName();
    }
}

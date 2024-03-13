package pl.mirekgab.productionorder.material;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pl.mirekgab.productionorder.measureunit.MeasureUnit;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "base_measure_unit_id")
    private MeasureUnit baseMeasureUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasureUnit getBaseMeasureUnit() {
        return baseMeasureUnit;
    }

    public void setBaseMeasureUnit(MeasureUnit baseMeasureUnit) {
        this.baseMeasureUnit = baseMeasureUnit;
    }
}

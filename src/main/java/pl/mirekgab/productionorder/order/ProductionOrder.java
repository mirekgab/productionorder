package pl.mirekgab.productionorder.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SortComparator;
import pl.mirekgab.productionorder.material.Material;
import pl.mirekgab.productionorder.product.Product;

import java.util.Set;

@Entity
public class ProductionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String number;

    @OneToMany(mappedBy = "productionOrder")
    @SortComparator(InputResourceComparator.class)
    private Set<InputResource> inputResources;


    @OneToMany(mappedBy = "productionOrder")
    @SortComparator(OutputResourceComparator.class)
    public Set<OutputResource> outputResources;

    public Set<InputResource> getInputResources() {
        return inputResources;
    }

    public void setInputResources(Set<InputResource> inputResources) {
        this.inputResources = inputResources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<OutputResource> getOutputResources() {
        return outputResources;
    }

    public void setOutputResources(Set<OutputResource> outputResources) {
        this.outputResources = outputResources;
    }
}

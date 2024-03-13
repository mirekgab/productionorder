package pl.mirekgab.productionorder.material.unit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MaterialUnitRepository extends JpaRepository<MaterialUnit, Long> {
    Set<MaterialUnit> findAllByMaterialId(Long materialId);
}

package pl.mirekgab.productionorder.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InputResourceRepository extends JpaRepository<InputResource, Long> {
    InputResource findByProductionOrderIdAndMaterialId(Long orderId, Long materialId);
}

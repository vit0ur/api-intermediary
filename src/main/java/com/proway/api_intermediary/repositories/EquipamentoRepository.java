package com.proway.api_intermediary.repositories;

import com.proway.api_intermediary.models.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByTipo(String tipo);

    List<Equipamento> findByStatusAndMarca(String status, String marca);
}
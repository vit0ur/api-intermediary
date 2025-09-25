package com.proway.api_intermediary.services;

import com.proway.api_intermediary.dtos.EquipamentoCreateDTO;
import com.proway.api_intermediary.dtos.EquipamentoResponseDTO;
import com.proway.api_intermediary.exceptions.ResourceNotFoundException;
import com.proway.api_intermediary.models.Equipamento;
import com.proway.api_intermediary.repositories.EquipamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public Equipamento toEntity(EquipamentoCreateDTO dto) {
        Equipamento e = new Equipamento();
        e.setNome(dto.getNome());
        e.setTipo(dto.getTipo());
        e.setMarca(dto.getMarca());
        e.setModelo(dto.getModelo());
        e.setNumeroSerie(dto.getNumeroSerie());
        e.setStatus(dto.getStatus());
        return e;
    }

    public EquipamentoResponseDTO toDto(Equipamento e) {
        EquipamentoResponseDTO dto = new EquipamentoResponseDTO();
        dto.setNome(e.getNome());
        dto.setTipo(e.getTipo());
        dto.setMarca(e.getMarca());
        dto.setModelo(e.getModelo());
        dto.setNumeroSerie(e.getNumeroSerie());
        dto.setStatus(e.getStatus());
        return dto;
    }

    public EquipamentoResponseDTO create(EquipamentoCreateDTO dto) {
        Equipamento equipamento = toEntity(dto);
        return toDto(repository.save(equipamento));
    }

    public List<EquipamentoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public EquipamentoResponseDTO findById(Long id) {
        Equipamento equipamento = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado"));
        return toDto(equipamento);
    }

    public List<EquipamentoResponseDTO> buscarPorTipo(String tipo) {
        List<Equipamento> listaEquipamento = repository.findByTipo(tipo);

        if (listaEquipamento.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum equipamento encontrado com o tipo: " + tipo);
        }

        return listaEquipamento.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<EquipamentoResponseDTO> buscarStatusByMarca(String status, String marca) {
        List<Equipamento> listaEquipamento = repository.findByStatusAndMarca(status, marca);

        if (listaEquipamento.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum equipamento encontrado com status '" + status + "' e marca '" + marca + "'");
        }

        return listaEquipamento.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
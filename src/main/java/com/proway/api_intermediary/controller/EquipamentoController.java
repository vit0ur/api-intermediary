package com.proway.api_intermediary.controller;

import org.springframework.web.bind.annotation.*;
import com.proway.api_intermediary.dtos.*;
import com.proway.api_intermediary.services.EquipamentoService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public EquipamentoResponseDTO create(@Valid @RequestBody EquipamentoCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<EquipamentoResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EquipamentoResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<EquipamentoResponseDTO> buscarPorTipo(@PathVariable String tipo) {
        return service.buscarPorTipo(tipo);
    }

    @GetMapping("/status-marca")
    public List<EquipamentoResponseDTO> buscarStatusByMarca(@RequestParam String status, @RequestParam String marca) {
        return service.buscarStatusByMarca(status, marca);
    }
}
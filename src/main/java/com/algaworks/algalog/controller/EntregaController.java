package com.algaworks.algalog.controller;

import com.algaworks.algalog.dto.DestinatarioDTO;
import com.algaworks.algalog.dto.EntregaDTO;
import com.algaworks.algalog.mapper.EntregaMapper;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.input.EntregaInput;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.FinalizacaoEntregaService;
import com.algaworks.algalog.service.SolicitacaoEntregaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EntregaMapper entregaMapper;

    @Autowired
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entrega) {
        Entrega novaEntrega = entregaMapper.toEntity(entrega);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDTO> listar() {
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDTO entregaDTO = entregaMapper.toModel(entrega);
                    return ResponseEntity.ok(entregaDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }
}

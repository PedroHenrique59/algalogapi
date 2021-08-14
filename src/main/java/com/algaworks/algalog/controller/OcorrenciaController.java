package com.algaworks.algalog.controller;

import com.algaworks.algalog.dto.OcorrenciaDTO;
import com.algaworks.algalog.mapper.OcorrenciaMapper;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.model.input.OcorrenciaInput;
import com.algaworks.algalog.service.BuscaEntregaService;
import com.algaworks.algalog.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;

    @Autowired
    private OcorrenciaMapper ocorrenciaMapper;

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
        return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toCollectModel(entrega.getOcorrencias());
    }

}

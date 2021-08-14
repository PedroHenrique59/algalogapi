package com.algaworks.algalog.mapper;

import com.algaworks.algalog.dto.OcorrenciaDTO;
import com.algaworks.algalog.model.Ocorrencia;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OcorrenciaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollectModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream().map(ocorrencia -> toModel(ocorrencia)).collect(Collectors.toList());
    }

}

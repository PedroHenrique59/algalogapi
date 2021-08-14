package com.algaworks.algalog.mapper;

import com.algaworks.algalog.dto.EntregaDTO;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.input.EntregaInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaMapper {

    @Autowired
    private ModelMapper mapper;

    public EntregaDTO toModel(Entrega entrega){
        return mapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionModel(List<Entrega> entregas){
        return entregas.stream().map(entrega -> toModel(entrega)).collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return mapper.map(entregaInput, Entrega.class);
    }
}

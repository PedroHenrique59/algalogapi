package com.algaworks.algalog.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaInput {

    @Valid
    @NotNull
    private ClienteIdInput clienteIdInput;

    @Valid
    @NotNull
    private DestinatarioInput destinatarioInput;

    @NotNull
    private BigDecimal taxa;

}

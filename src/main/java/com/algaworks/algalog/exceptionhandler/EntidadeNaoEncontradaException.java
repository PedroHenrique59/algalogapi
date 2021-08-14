package com.algaworks.algalog.exceptionhandler;

import com.algaworks.algalog.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }


}

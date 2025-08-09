package com.foro.fororquidea.dto;

public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        Long autorId,
        Long cursoId) {
}

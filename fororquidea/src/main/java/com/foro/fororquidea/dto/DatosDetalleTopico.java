package com.foro.fororquidea.dto;

import com.foro.fororquidea.entity.Topico;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        java.time.LocalDateTime fechaCreacion,
        String status,
        String nombreAutor,
        String nombreCurso) {

    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().name(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

}

package com.foro.fororquidea.dto;

import com.foro.fororquidea.entity.Topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String nombreCurso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso().getNombre());
    }
}
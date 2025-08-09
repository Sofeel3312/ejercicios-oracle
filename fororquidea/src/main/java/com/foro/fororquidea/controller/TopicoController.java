package com.foro.fororquidea.controller;

import com.foro.fororquidea.dto.DatosDetalleTopico;
import com.foro.fororquidea.dto.DatosListadoTopico;
import com.foro.fororquidea.service.TopicoService;
import com.foro.fororquidea.dto.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public DatosDetalleTopico registrarTopico(@RequestBody DatosRegistroTopico datos) {
        return topicoService.crearTopico(datos);
    }

    @GetMapping
    public List<DatosListadoTopico> listarTopicos() {
        return topicoService.listarTopicos();
    }

    @GetMapping("/{id}")
    public DatosDetalleTopico obtenerTopico(@PathVariable Long id) {
        return topicoService.obtenerTopicoPorId(id);
    }


}

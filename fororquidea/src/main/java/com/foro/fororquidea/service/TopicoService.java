package com.foro.fororquidea.service;

import com.foro.fororquidea.dto.DatosDetalleTopico;
import com.foro.fororquidea.dto.DatosListadoTopico;
import com.foro.fororquidea.dto.DatosRegistroTopico;
import com.foro.fororquidea.entity.Curso;
import com.foro.fororquidea.entity.Topico;
import com.foro.fororquidea.entity.Usuario;
import com.foro.fororquidea.repository.CursoRepository;
import com.foro.fororquidea.repository.TopicoRepository;
import com.foro.fororquidea.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosDetalleTopico crearTopico(DatosRegistroTopico datos) {
        Usuario autor = usuarioRepository.findById(datos.autorId()).orElseThrow();
        Curso curso = cursoRepository.findById(datos.cursoId()).orElseThrow();

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);

        Topico topicoGuardado = topicoRepository.save(topico);

        return new DatosDetalleTopico(
                topicoGuardado.getId(),
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getFechaCreacion(),
                topicoGuardado.getStatus().name(),
                autor.getNombre(),
                curso.getNombre()
        );
    }

    public List<DatosListadoTopico> listarTopicos() {
        return topicoRepository.findAll().stream()
                .map(DatosListadoTopico::new)
                .toList();
    }

    public DatosDetalleTopico obtenerTopicoPorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        return new DatosDetalleTopico(topico);
    }


}

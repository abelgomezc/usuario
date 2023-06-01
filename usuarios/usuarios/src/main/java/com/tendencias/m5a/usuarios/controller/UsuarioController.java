
package com.tendencias.m5a.usuarios.controller;


import com.tendencias.m5a.usuarios.model.Usuario;
import com.tendencias.m5a.usuarios.servicio.UsuarioServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abel Gomez
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/nuevoUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/EdiarUusario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setClave(u.getClave());
                usuario.setEstado(u.getEstado());
                usuario.setEmail(u.getEmail());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> elimiarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

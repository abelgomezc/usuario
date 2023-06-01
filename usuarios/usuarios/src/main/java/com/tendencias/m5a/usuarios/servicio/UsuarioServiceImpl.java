/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.m5a.usuarios.servicio;


import com.tendencias.m5a.usuarios.model.Usuario;
import com.tendencias.m5a.usuarios.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements GenericService<Usuario, Integer> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.m5a.usuarios.repositorio;


import com.tendencias.m5a.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Abel Gomez
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
        @Query(value = "Select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    public Usuario buscarUsuario(String nombre);
}

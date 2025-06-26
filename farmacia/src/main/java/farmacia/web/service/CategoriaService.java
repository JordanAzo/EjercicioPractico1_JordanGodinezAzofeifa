/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package farmacia.web.service;

import farmacia.web.domain.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getCategorias();
    void guardar(Categoria categoria);
    void eliminar(Long id);
    Categoria buscarPorId(Long id);
}
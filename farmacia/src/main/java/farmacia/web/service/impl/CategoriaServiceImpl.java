/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package farmacia.web.service.impl;

import farmacia.web.dao.CategoriaDao;
import farmacia.web.domain.Categoria;
import farmacia.web.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final  CategoriaDao categoriaDao;

    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Override
    public List<Categoria> getCategorias() {
    return categoriaDao.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        categoriaDao.deleteById(id);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        Optional<Categoria> optional = categoriaDao.findById(id);
        return optional.orElse(null);
    }
}

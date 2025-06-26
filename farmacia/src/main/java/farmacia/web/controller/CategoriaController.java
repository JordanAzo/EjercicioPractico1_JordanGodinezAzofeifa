/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package farmacia.web.controller;

import farmacia.web.domain.Categoria;
import farmacia.web.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {
    
    private final CategoriaService categoriaService;
    
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("totalCategorias", categoriaService.getCategorias().size());
        model.addAttribute("categoria", new Categoria());
        return "index";
    }
    
    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/";
    }
    
    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminar(id);
        return "redirect:/";
    }
    
    @GetMapping("/categorias/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("totalCategorias", categoriaService.getCategorias().size());
        return "index";
    }
}
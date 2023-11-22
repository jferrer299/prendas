package com.desarrolo.proyectojoseph.controladores;


import com.desarrolo.proyectojoseph.entidades.ContadorVisitas;
import com.desarrolo.proyectojoseph.entidades.Prenda;
import com.desarrolo.proyectojoseph.entidades.TipoPrenda;
import com.desarrolo.proyectojoseph.servicios.PrendaServicio;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
public class PrendaController {
  private List<Prenda> repositorio = new ArrayList<>();


  @GetMapping("/change-language")
  public String changeLanguage(@RequestParam("lang") String lang, HttpServletRequest request) {
    request.getSession().setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(lang));
    return "redirect:/";
  }

  @Autowired
  private PrendaServicio servicio;

  @GetMapping({"/", "prenda/list"})
  public String listado(Model model) {
    model.addAttribute("listaPrendas", servicio.findAll());
    TipoPrenda[] tiposPrenda = TipoPrenda.values();  // Obtiene los valores del enumerado
    model.addAttribute("tiposPrenda", tiposPrenda);
    return "list";
  }

  @GetMapping("/prenda/new")
  public String nuevaPrendaForm(Model model) {
    model.addAttribute("prendaForm", new Prenda());
    return "form";
  }

  @PostMapping("/prenda/new/submit")
  public String nuevaPrendaSubmit(@Valid @ModelAttribute("prendaForm") Prenda nuevaPrenda,
                                    BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "form";
    } else {
      servicio.add(nuevaPrenda);
      return "redirect:/prenda/list";
    }

  }

  @GetMapping("/prenda/edit/{id}")
  public String editarPrendaForm(@PathVariable long id, Model model) {

    Prenda prenda = servicio.findById(id);
    if (prenda != null) {
      model.addAttribute("prendaForm", prenda);
      return "form";
    } else {
      return "redirect:/prenda/new";
    }
  }

  @PostMapping("/prenda/edit/submit")
  public String editarPrendaSubmit(@Valid @ModelAttribute("prendaForm") Prenda prenda,
                                     BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "form";
    } else {
      servicio.edit(prenda);
      return "redirect:/prenda/list";
    }
  }

  @GetMapping("/prenda/delete/{id}")
  public String borrarPrenda(@PathVariable("id") Long id, Model model) {

    Prenda prenda = servicio.findById(id);

    if (prenda != null)
      servicio.delete(prenda);

    return "redirect:/prenda/list";
  }
  @GetMapping("/logout")
  public String logout(){
    return "redirect:/prenda/list";
  }



}

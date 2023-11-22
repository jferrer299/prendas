package com.desarrolo.proyectojoseph.servicios;

import com.desarrolo.proyectojoseph.entidades.Prenda;

import com.desarrolo.proyectojoseph.entidades.TipoPrenda;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PrendaServicio {

  private List<Prenda> repositorio = new ArrayList<>();

  public Prenda add(Prenda e) {
    repositorio.add(e);
    return e;
  }

  public void addAll(List<Prenda> lista) {
    repositorio.addAll(lista);
  }

  public List<Prenda> findAll() {
    return repositorio;
  }

  public Prenda findById(long id) {
    Prenda result = null;
    boolean encontrado = false;
    int i = 0;
    while (!encontrado && i < repositorio.size()) {
      if (repositorio.get(i).getId() == id) {
        encontrado = true;
        result = repositorio.get(i);
      } else {
        i++;
      }
    }
    return result;
  }

  public Prenda edit(Prenda e) {
    boolean encontrado = false;
    int i = 0;
    while (!encontrado && i < repositorio.size()) {
      if (repositorio.get(i).getId() == e.getId()) {
        encontrado = true;
        repositorio.remove(i);
        repositorio.add(i, e);
      } else {
        i++;
      }
    }
    if (!encontrado)
      repositorio.add(e);

    return e;
  }

  public void delete(Prenda e) {
    repositorio.remove(e);
  }


}

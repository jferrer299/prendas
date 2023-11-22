package com.desarrolo.proyectojoseph.configuracion;

import com.desarrolo.proyectojoseph.entidades.Prenda;
import com.desarrolo.proyectojoseph.entidades.TipoPrenda;
import com.desarrolo.proyectojoseph.servicios.PrendaServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class InitDataConfig {
    @Autowired
    private PrendaServicio prendaServicio;

    @PostConstruct
    public void init() {
        prendaServicio.addAll(
                Arrays.asList(
                        Prenda.builder()
                                .id(1)
                                .marca("Lacoste")
                                .modelo("CMS5")
                                .precio("120")
                                .usando(true)
                                .tipo(TipoPrenda.CHANDAL)
                                .build(),
                        Prenda.builder()
                                .id(2)
                                .marca("NIKE")
                                .modelo("AIR MAX")
                                .precio("90")
                                .usando(true)
                                .tipo(TipoPrenda.CALZADO)
                                .build(),
                        Prenda.builder()
                                .id(3)
                                .marca("Lacoste")
                                .modelo("TSS5")
                                .precio("20")
                                .usando(true)
                                .tipo(TipoPrenda.CAMISETA)
                                .build()
                )
        );
    }

}

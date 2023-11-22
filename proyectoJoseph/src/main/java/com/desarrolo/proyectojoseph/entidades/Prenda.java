package com.desarrolo.proyectojoseph.entidades;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenda {

  @Min(value=0, message="{prenda.id.mayorquecero}")
  private long id;
  @NotEmpty
  private String marca;
  @NotBlank(message = "{prenda.modelo.novavacio}")
  private String modelo;
  @NotNull( message="{prenda.precio.novacio}")
  private String precio;
  private boolean usando;
  private TipoPrenda tipo;

}

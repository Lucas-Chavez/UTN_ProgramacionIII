package org.example.entidades;


import lombok.Builder;
import lombok.Data;
import org.example.entidades.enums.Estado;
import org.example.entidades.enums.FormaPago;
import org.example.entidades.enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

@Data
@Builder
public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Enum<Estado> estado;
    private Enum<TipoEnvio> tipoEnvio;
    private Enum<FormaPago> formaPago;
    private LocalDate fechaPedido;

    private HashSet<DetallePedido> detalles;
    private Cliente cliente;
}

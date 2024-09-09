package org.example;

import org.example.entidades.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Crear clientes
        Cliente cliente1 = Cliente.builder().id(1L).nombre("Juan").apellido("Pérez").telefono("123456789").email("juan.perez@example.com").fechaNacimiento(LocalDate.of(1990, 5, 10)).build();
        Cliente cliente2 = Cliente.builder().id(2L).nombre("María").apellido("Gómez").telefono("987654321").email("maria.gomez@example.com").fechaNacimiento(LocalDate.of(1985, 8, 15)).build();
        Cliente cliente3 = Cliente.builder().id(3L).nombre("Carlos").apellido("López").telefono("567890123").email("carlos.lopez@example.com").fechaNacimiento(LocalDate.of(1995, 11, 20)).build();

        // Crear unidades de medida
        UnidadMedida porciones8 = UnidadMedida.builder().id(1L).denominacion("8 Porciones").build();
        UnidadMedida porciones4 = UnidadMedida.builder().id(2L).denominacion("4 Porciones").build();
        UnidadMedida litro1 = UnidadMedida.builder().id(3L).denominacion("1 Litro").build();

        // Crear imágenes
        Imagenes imagen1 = Imagenes.builder().id(1L).nombre("Pizza grande Hawaiana").url("url_imagen1").build();
        Imagenes imagen2 = Imagenes.builder().id(2L).nombre("Pizza grande Napolitana").url("url_imagen2").build();
        Imagenes imagen3 = Imagenes.builder().id(3L).nombre("Pizza grande Muzza").url("url_imagen3").build();
        Imagenes imagen4 = Imagenes.builder().id(4L).nombre("Pizza chica Hawaiana").url("url_imagen4").build();
        Imagenes imagen5 = Imagenes.builder().id(5L).nombre("Pizza chica Napolitana").url("url_imagen5").build();
        Imagenes imagen6 = Imagenes.builder().id(6L).nombre("Pizza chica Muzza").url("url_imagen6").build();
        Imagenes imagen7 = Imagenes.builder().id(7L).nombre("Cerveza Andes").url("url_imagen7").build();
        Imagenes imagen8 = Imagenes.builder().id(8L).nombre("Cerveza Quilmes").url("url_imagen8").build();

        // Crear artículos y relacionarlos con sus unidades de medida e imágenes
        Articulo pizzaGrandeHawaiana = Articulo.builder().id(1L).denominacion("Pizza grande Hawaiana")
                .precioVenta(1200.0).precioCompra(800.0).stockActual(10).stockMaximo(50).tiempoEstimadoMinutos(20)
                .unidad(porciones8).imagen(imagen1).build();
        Articulo pizzaChicaHawaiana = Articulo.builder().id(2L).denominacion("Pizza chica Hawaiana")
                .precioVenta(800.0).precioCompra(500.0).stockActual(15).stockMaximo(30).tiempoEstimadoMinutos(15)
                .unidad(porciones4).imagen(imagen4).build();
        Articulo pizzaGrandeNapolitana = Articulo.builder().id(3L).denominacion("Pizza grande Napolitana")
                .precioVenta(1100.0).precioCompra(750.0).stockActual(12).stockMaximo(50).tiempoEstimadoMinutos(20)
                .unidad(porciones8).imagen(imagen2).build();
        Articulo pizzaChicaNapolitana = Articulo.builder().id(4L).denominacion("Pizza chica Napolitana")
                .precioVenta(750.0).precioCompra(500.0).stockActual(18).stockMaximo(30).tiempoEstimadoMinutos(15)
                .unidad(porciones4).imagen(imagen5).build();
        Articulo pizzaGrandeMuzza = Articulo.builder().id(5L).denominacion("Pizza grande Muzza")
                .precioVenta(1000.0).precioCompra(700.0).stockActual(20).stockMaximo(50).tiempoEstimadoMinutos(20)
                .unidad(porciones8).imagen(imagen3).build();
        Articulo pizzaChicaMuzza = Articulo.builder().id(6L).denominacion("Pizza chica Muzza")
                .precioVenta(700.0).precioCompra(450.0).stockActual(25).stockMaximo(30).tiempoEstimadoMinutos(15)
                .unidad(porciones4).imagen(imagen6).build();
        Articulo cervezaAndes = Articulo.builder().id(7L).denominacion("Cerveza Andes")
                .precioVenta(400.0).precioCompra(250.0).stockActual(50).stockMaximo(100).tiempoEstimadoMinutos(5)
                .unidad(litro1).imagen(imagen7).build();
        Articulo cervezaQuilmes = Articulo.builder().id(8L).denominacion("Cerveza Quilmes")
                .precioVenta(350.0).precioCompra(200.0).stockActual(60).stockMaximo(100).tiempoEstimadoMinutos(5)
                .unidad(litro1).imagen(imagen8).build();

        // Cliente 1 realiza un pedido de una Pizza grande Hawaiana y una cerveza Quilmes
        DetallePedido detalle1 = DetallePedido.builder().id(1L).cantidad(1)
                .subTotal(pizzaGrandeHawaiana.getPrecioVenta()).articulo(pizzaGrandeHawaiana).build();
        DetallePedido detalle2 = DetallePedido.builder().id(2L).cantidad(1)
                .subTotal(cervezaQuilmes.getPrecioVenta()).articulo(cervezaQuilmes).build();
        Pedido pedido1 = Pedido.builder().id(1L).horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                .total(detalle1.getSubTotal() + detalle2.getSubTotal()).estado(Pedido.Estado.PENDIENTE)
                .tipoEnvio(Pedido.TipoEnvio.DELIVERY).formaPago(Pedido.FormaPago.EFECTIVO).fechaPedido(LocalDate.now())
                .detalles(Set.of(detalle1, detalle2)).build();
        cliente1.getHace().add(pedido1);
        mostrarPedido(cliente1, pedido1);

        // Cliente 2 realiza la compra de 3 cervezas Quilmes y una Pizza chica Hawaiana
        DetallePedido detalle3 = DetallePedido.builder().id(3L).cantidad(3)
                .subTotal(cervezaQuilmes.getPrecioVenta() * 3).articulo(cervezaQuilmes).build();
        DetallePedido detalle4 = DetallePedido.builder().id(4L).cantidad(1)
                .subTotal(pizzaChicaHawaiana.getPrecioVenta()).articulo(pizzaChicaHawaiana).build();
        Pedido pedido2 = Pedido.builder().id(2L).horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                .total(detalle3.getSubTotal() + detalle4.getSubTotal()).estado(Pedido.Estado.PENDIENTE)
                .tipoEnvio(Pedido.TipoEnvio.RETIRO_EN_LOCAL).formaPago(Pedido.FormaPago.TARJETA_DEBITO).fechaPedido(LocalDate.now())
                .detalles(Set.of(detalle3, detalle4)).build();
        cliente2.getHace().add(pedido2);
        mostrarPedido(cliente2, pedido2);

        // Cliente 3 compra 1 Pizza grande Hawaiana, 1 Pizza chica Muzza, 1 grande Napolitana y 2 cervezas Andes
        DetallePedido detalle5 = DetallePedido.builder().id(5L).cantidad(1)
                .subTotal(pizzaGrandeHawaiana.getPrecioVenta()).articulo(pizzaGrandeHawaiana).build();
        DetallePedido detalle6 = DetallePedido.builder().id(6L).cantidad(1)
                .subTotal(pizzaChicaMuzza.getPrecioVenta()).articulo(pizzaChicaMuzza).build();
        DetallePedido detalle7 = DetallePedido.builder().id(7L).cantidad(1)
                .subTotal(pizzaGrandeNapolitana.getPrecioVenta()).articulo(pizzaGrandeHawaiana).build();
        DetallePedido detalle8 = DetallePedido.builder().id(8L).cantidad(2)
                .subTotal(cervezaAndes.getPrecioVenta() * 2).articulo(cervezaAndes).build();
        Pedido pedido3 = Pedido.builder().id(3L).horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                .total(detalle5.getSubTotal() + detalle6.getSubTotal() + detalle7.getSubTotal() + detalle8.getSubTotal()).estado(Pedido.Estado.PENDIENTE)
                .tipoEnvio(Pedido.TipoEnvio.ENVIO_A_DOMICILIO).formaPago(Pedido.FormaPago.TRANSFERENCIA_BANCARIA).fechaPedido(LocalDate.now())
                .detalles(Set.of(detalle5, detalle6, detalle7, detalle8))
                .build();
        cliente3.getHace().add(pedido3);
        mostrarPedido(cliente3, pedido3);

        // Cliente 1 realiza un segundo pedido de 1 Pizza chica Muzza y una cerveza Andes
        DetallePedido detalle9 = DetallePedido.builder().id(9L).cantidad(1)
                .subTotal(pizzaChicaMuzza.getPrecioVenta()).articulo(pizzaChicaMuzza).build();
        DetallePedido detalle10 = DetallePedido.builder().id(10L).cantidad(1)
                .subTotal(cervezaAndes.getPrecioVenta()).articulo(cervezaAndes).build();
        Pedido pedido4 = Pedido.builder().id(4L).horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                .total(detalle9.getSubTotal() + detalle10.getSubTotal()).estado(Pedido.Estado.PENDIENTE)
                .tipoEnvio(Pedido.TipoEnvio.RETIRO_EN_LOCAL).formaPago(Pedido.FormaPago.TARJETA_CREDITO).fechaPedido(LocalDate.now())
                .detalles(Set.of(detalle9, detalle10))
                .build();
        cliente1.getHace().add(pedido4);
        mostrarPedido(cliente1, pedido4);

        // Mostrar la cantidad de veces que el cliente 1 compró en el local
        System.out.printf("Cliente 1: %s %s ha realizado: %d pedidos.%n",
                cliente1.getNombre(),
                cliente1.getApellido(),
                cliente1.getHace().size());

        // Mostrar todos los artículos que comercializa el negocio
        Set<Articulo> articulos = Set.of(pizzaGrandeHawaiana, pizzaChicaHawaiana, pizzaGrandeNapolitana, pizzaChicaNapolitana, pizzaGrandeMuzza, pizzaChicaMuzza, cervezaAndes, cervezaQuilmes);
        System.out.println("\nArticulos En Venta");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.getDenominacion() + " - $" + articulo.getPrecioVenta());
        }
    }

    private static void mostrarPedido(Cliente cliente, Pedido pedido) {
        System.out.println("Pedido realizado por: " + cliente.getNombre() + " " + cliente.getApellido());
        for (DetallePedido detalle : pedido.getDetalles()) {
            System.out.println("Artículo: " + detalle.getArticulo().getDenominacion() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubTotal());
        }

        System.out.println("Total a pagar: $" + pedido.getTotal());
        System.out.println("Estado del pedido: " + pedido.getEstado());
        System.out.println("Forma de pago: " + pedido.getFormaPago());
        System.out.println("---------------------------------------------------");
    }
}

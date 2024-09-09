package org.example;

import org.example.entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            //Clientes
            Cliente cliente1 = new Cliente(1L, "Juan", "Perez", "123456789", "juan.perez@example.com", LocalDate.of(1990, 1, 1), new HashSet<>());
            Cliente cliente2 = new Cliente(2L, "Maria", "Lopez", "987654321", "maria.lopez@example.com", LocalDate.of(1985, 5, 10), new HashSet<>());
            Cliente cliente3 = new Cliente(3L, "Carlos", "Garcia", "456123789", "carlos.garcia@example.com", LocalDate.of(1980, 7, 15), new HashSet<>());

            //Unidades de medida
            UnidadMedida porciones8 = new UnidadMedida(1L, "8 Porciones");
            UnidadMedida porciones4 = new UnidadMedida(2L, "4 Porciones");
            UnidadMedida litro = new UnidadMedida(3L, "1 Litro");

            //Imágenes
            Imagenes imagen1 = new Imagenes(1L, "Pizza grande Hawaiana", "url_imagen1");
            Imagenes imagen2 = new Imagenes(2L, "Pizza grande Napolitana", "url_imagen2");
            Imagenes imagen3 = new Imagenes(3L, "Pizza grande Muzza", "url_imagen3");
            Imagenes imagen4 = new Imagenes(4L, "Pizza chica Hawaiana", "url_imagen4");
            Imagenes imagen5 = new Imagenes(5L, "Pizza chica Napolitana", "url_imagen5");
            Imagenes imagen6 = new Imagenes(6L, "Pizza chica Muzza", "url_imagen6");
            Imagenes imagen7 = new Imagenes(7L, "Cerveza Andes", "url_imagen7");
            Imagenes imagen8 = new Imagenes(8L, "Cerveza Quilmes", "url_imagen8");

            //Artículos
            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .id(1L)
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(1000.0)
                    .precioCompra(800.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(20)
                    .unidad(porciones8)
                    .imagen(imagen1)
                    .build();

            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .id(2L)
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(600.0)
                    .precioCompra(500.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(15)
                    .unidad(porciones4)
                    .imagen(imagen4)
                    .build();

            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .id(3L)
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(950.0)
                    .precioCompra(750.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(20)
                    .unidad(porciones8)
                    .imagen(imagen2)
                    .build();

            Articulo pizzaChicaNapolitana = Articulo.builder()
                    .id(4L)
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(550.0)
                    .precioCompra(450.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(15)
                    .unidad(porciones4)
                    .imagen(imagen5)
                    .build();

            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .id(5L)
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(900.0)
                    .precioCompra(700.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(20)
                    .unidad(porciones8)
                    .imagen(imagen3)
                    .build();

            Articulo pizzaChicaMuzza = Articulo.builder()
                    .id(6L)
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(500.0)
                    .precioCompra(400.0)
                    .stockMaximo(50)
                    .tiempoEstimadoMinutos(15)
                    .unidad(porciones4)
                    .imagen(imagen6)
                    .build();

            Articulo cervezaAndes = Articulo.builder()
                    .id(7L)
                    .denominacion("Cerveza Andes")
                    .precioVenta(300.0)
                    .precioCompra(200.0)
                    .stockMaximo(100)
                    .tiempoEstimadoMinutos(5)
                    .unidad(litro)
                    .imagen(imagen7)
                    .build();

            Articulo cervezaQuilmes = Articulo.builder()
                    .id(8L)
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(280.0)
                    .precioCompra(180.0)
                    .stockMaximo(100)
                    .tiempoEstimadoMinutos(5)
                    .unidad(litro)
                    .imagen(imagen8)
                    .build();

            //Pedido 1 de cliente1
            DetallePedido detalle1Pedido1 = DetallePedido.builder()
                    .id(1L)
                    .cantidad(1)
                    .subTotal(pizzaGrandeHawaiana.getPrecioVenta())
                    .articulo(pizzaGrandeHawaiana)
                    .build();

            DetallePedido detalle2Pedido1 = DetallePedido.builder()
                    .id(2L)
                    .cantidad(1)
                    .subTotal(cervezaQuilmes.getPrecioVenta())
                    .articulo(cervezaQuilmes)
                    .build();

            Set<DetallePedido> detallesPedido1 = new HashSet<>();
            detallesPedido1.add(detalle1Pedido1);
            detallesPedido1.add(detalle2Pedido1);

            Pedido pedido1Cliente1 = Pedido.builder()
                    .id(1L)
                    .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(25))
                    .total(detalle1Pedido1.getSubTotal() + detalle2Pedido1.getSubTotal())
                    .totalCosto((double) (pizzaGrandeHawaiana.getPrecioCompra() + cervezaQuilmes.getPrecioCompra()))
                    .FechaPedido(LocalDate.now())
                    .detalles(detallesPedido1)
                    .build();

            cliente1.getHace().add(pedido1Cliente1);

            //Mostrar pedido 1 del cliente1
            mostrarPedido(cliente1, pedido1Cliente1);

            //Pedido 1 de cliente2
            DetallePedido detalle1Pedido2 = DetallePedido.builder()
                    .id(3L)
                    .cantidad(3)
                    .subTotal(cervezaQuilmes.getPrecioVenta() * 3)
                    .articulo(cervezaQuilmes)
                    .build();

            DetallePedido detalle2Pedido2 = DetallePedido.builder()
                    .id(4L)
                    .cantidad(1)
                    .subTotal(pizzaChicaHawaiana.getPrecioVenta())
                    .articulo(pizzaChicaHawaiana)
                    .build();

            Set<DetallePedido> detallesPedido2 = new HashSet<>();
            detallesPedido2.add(detalle1Pedido2);
            detallesPedido2.add(detalle2Pedido2);

            Pedido pedido1Cliente2 = Pedido.builder()
                    .id(2L)
                    .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                    .total(detalle1Pedido2.getSubTotal() + detalle2Pedido2.getSubTotal())
                    .totalCosto((double) (cervezaQuilmes.getPrecioCompra() * 3 + pizzaChicaHawaiana.getPrecioCompra()))
                    .FechaPedido(LocalDate.now())
                    .detalles(detallesPedido2)
                    .build();

            cliente2.getHace().add(pedido1Cliente2);

            //Mostrar pedido 1 del cliente2
            mostrarPedido(cliente2, pedido1Cliente2);

            //Pedido 1 de cliente3
            DetallePedido detalle1Pedido3 = DetallePedido.builder()
                    .id(5L)
                    .cantidad(1)
                    .subTotal(pizzaGrandeHawaiana.getPrecioVenta())
                    .articulo(pizzaGrandeHawaiana)
                    .build();

            DetallePedido detalle2Pedido3 = DetallePedido.builder()
                    .id(6L)
                    .cantidad(1)
                    .subTotal(pizzaChicaMuzza.getPrecioVenta())
                    .articulo(pizzaChicaMuzza)
                    .build();

            DetallePedido detalle3Pedido3 = DetallePedido.builder()
                    .id(7L)
                    .cantidad(1)
                    .subTotal(pizzaGrandeNapolitana.getPrecioVenta())
                    .articulo(pizzaGrandeNapolitana)
                    .build();

            DetallePedido detalle4Pedido3 = DetallePedido.builder()
                    .id(8L)
                    .cantidad(2)
                    .subTotal(cervezaAndes.getPrecioVenta() * 2)
                    .articulo(cervezaAndes)
                    .build();

            Set<DetallePedido> detallesPedido3 = new HashSet<>();
            detallesPedido3.add(detalle1Pedido3);
            detallesPedido3.add(detalle2Pedido3);
            detallesPedido3.add(detalle3Pedido3);
            detallesPedido3.add(detalle4Pedido3);

            Pedido pedido1Cliente3 = Pedido.builder()
                    .id(3L)
                    .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(40))
                    .total(detalle1Pedido3.getSubTotal() + detalle2Pedido3.getSubTotal() + detalle3Pedido3.getSubTotal() + detalle4Pedido3.getSubTotal())
                    .totalCosto((double) (pizzaGrandeHawaiana.getPrecioCompra() + pizzaChicaMuzza.getPrecioCompra() + pizzaGrandeNapolitana.getPrecioCompra() + cervezaAndes.getPrecioCompra() * 2))
                    .FechaPedido(LocalDate.now())
                    .detalles(detallesPedido3)
                    .build();

            cliente3.getHace().add(pedido1Cliente3);

            //Mostrar pedido 1 del cliente3
            mostrarPedido(cliente3, pedido1Cliente3);

            //Pedido 2 de cliente1
            DetallePedido detalle1Pedido4 = DetallePedido.builder()
                    .id(9L)
                    .cantidad(1)
                    .subTotal(pizzaChicaMuzza.getPrecioVenta())
                    .articulo(pizzaChicaMuzza)
                    .build();

            DetallePedido detalle2Pedido4 = DetallePedido.builder()
                    .id(10L)
                    .cantidad(1)
                    .subTotal(cervezaAndes.getPrecioVenta())
                    .articulo(cervezaAndes)
                    .build();

            Set<DetallePedido> detallesPedido4 = new HashSet<>();
            detallesPedido4.add(detalle1Pedido4);
            detallesPedido4.add(detalle2Pedido4);

            Pedido pedido2Cliente1 = Pedido.builder()
                    .id(4L)
                    .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(25))
                    .total(detalle1Pedido4.getSubTotal() + detalle2Pedido4.getSubTotal())
                    .totalCosto((double) (pizzaChicaMuzza.getPrecioCompra() + cervezaAndes.getPrecioCompra()))
                    .FechaPedido(LocalDate.now().plusDays(1)) // Pedido en otro día
                    .detalles(detallesPedido4)
                    .build();

            cliente1.getHace().add(pedido2Cliente1);

            //Mostrar pedido 2 del cliente1
            mostrarPedido(cliente1, pedido2Cliente1);

            //Mostrar cantidad de compras del cliente1
            System.out.println("Cantidad de veces que el Cliente 1 compró en el local: " + cliente1.getHace().size());

            //Mostrar todos los artículos
            System.out.println("\nArtículos que comercializa el negocio: ");
            mostrarArticulo(pizzaGrandeHawaiana);
            mostrarArticulo(pizzaChicaHawaiana);
            mostrarArticulo(pizzaGrandeNapolitana);
            mostrarArticulo(pizzaChicaNapolitana);
            mostrarArticulo(pizzaGrandeMuzza);
            mostrarArticulo(pizzaChicaMuzza);
            mostrarArticulo(cervezaAndes);
            mostrarArticulo(cervezaQuilmes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarPedido(Cliente cliente, Pedido pedido) {
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Fecha del Pedido: " + pedido.getFechaPedido());
        System.out.println("Hora Estimada de Finalización: " + pedido.getHoraEstimadaFinalizacion());
        System.out.println("Detalles del Pedido:");
        for (DetallePedido detalle : pedido.getDetalles()) {
            System.out.println(String.format(" - Artículo: %s, Cantidad: %d, Subtotal: %.2f",
                    detalle.getArticulo().getDenominacion(), detalle.getCantidad(), detalle.getSubTotal()));
        }
        System.out.println("Total a pagar: " + pedido.getTotal());
        System.out.println();
    }

    public static void mostrarArticulo(Articulo articulo) {
        System.out.println(String.format("Artículo: %s, Precio de Venta: %.2f, Precio de Compra: %.2f, Unidad de Medida: %s, Imagen: %s",
                articulo.getDenominacion(), articulo.getPrecioVenta(), articulo.getPrecioCompra(),
                articulo.getUnidad().getDenominacion(), articulo.getImagen().getNombre()));
    }

}

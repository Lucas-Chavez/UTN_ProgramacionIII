package org.example;

import org.example.entidades.*;
import org.example.entidades.enums.Estado;
import org.example.entidades.enums.FormaPago;
import org.example.entidades.enums.TipoEnvio;
import org.example.repositorios.InMemoryRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Repositorios
        InMemoryRepository<Cliente> clienteRepo = new InMemoryRepository<>();
        InMemoryRepository<Articulo> articuloRepo = new InMemoryRepository<>();
        InMemoryRepository<Pedido> pedidoRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepo = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepo = new InMemoryRepository<>();

        // Crear clientes
        Cliente cliente1 = Cliente.builder().nombre("Juan").apellido("Pérez").telefono("123456789").email("juan.perez@mail.com").fechaNacimiento(LocalDate.of(1990, 1, 1)).hace(new HashSet<>()).build();
        Cliente cliente2 = Cliente.builder().nombre("Ana").apellido("Gómez").telefono("987654321").email("ana.gomez@mail.com").fechaNacimiento(LocalDate.of(1985, 5, 10)).hace(new HashSet<>()).build();
        Cliente cliente3 = Cliente.builder().nombre("Carlos").apellido("Martínez").telefono("111222333").email("carlos.martinez@mail.com").fechaNacimiento(LocalDate.of(1995, 7, 20)).hace(new HashSet<>()).build();

        // Guardar clientes en el repositorio
        clienteRepo.save(cliente1);
        clienteRepo.save(cliente2);
        clienteRepo.save(cliente3);

        // Crear unidades de medida
        UnidadMedida porciones8 = UnidadMedida.builder().denominacion("8 Porciones").articulos(new HashSet<>()).build();
        UnidadMedida porciones4 = UnidadMedida.builder().denominacion("4 Porciones").articulos(new HashSet<>()).build();
        UnidadMedida litro1 = UnidadMedida.builder().denominacion("1 Litro").articulos(new HashSet<>()).build();

        // Guardar unidades de medida en el repositorio
        unidadMedidaRepo.save(porciones8);
        unidadMedidaRepo.save(porciones4);
        unidadMedidaRepo.save(litro1);

        // Crear imágenes
        Imagen imagen1 = Imagen.builder().nombre("Pizza grande Hawaiana").url("img1.jpg").build();
        Imagen imagen2 = Imagen.builder().nombre("Pizza grande Napolitana").url("img2.jpg").build();
        Imagen imagen3 = Imagen.builder().nombre("Pizza grande Muzza").url("img3.jpg").build();
        Imagen imagen4 = Imagen.builder().nombre("Pizza chica Hawaiana").url("img4.jpg").build();
        Imagen imagen5 = Imagen.builder().nombre("Pizza chica Napolitana").url("img5.jpg").build();
        Imagen imagen6 = Imagen.builder().nombre("Pizza chica Muzza").url("img6.jpg").build();
        Imagen imagen7 = Imagen.builder().nombre("Cerveza Andes").url("img7.jpg").build();
        Imagen imagen8 = Imagen.builder().nombre("Cerveza Quilmes").url("img8.jpg").build();

        // Guardar imágenes en el repositorio
        imagenRepo.save(imagen1);
        imagenRepo.save(imagen2);
        imagenRepo.save(imagen3);
        imagenRepo.save(imagen4);
        imagenRepo.save(imagen5);
        imagenRepo.save(imagen6);
        imagenRepo.save(imagen7);
        imagenRepo.save(imagen8);

        // Crear artículos y relacionarlos con sus respectivas unidades de medida
        Articulo pizzaGrandeHawaiana = Articulo.builder().denominacion("Pizza grande Hawaiana").precioVenta(1500.0).stockActual(10).stockMaximo(20).tiempoEstimadoMinutos(20).unidad(porciones8).imagen(imagen1).detallePedidos(new HashSet<>()).build();
        Articulo pizzaChicaHawaiana = Articulo.builder().denominacion("Pizza chica Hawaiana").precioVenta(800.0).stockActual(15).stockMaximo(30).tiempoEstimadoMinutos(15).unidad(porciones4).imagen(imagen4).detallePedidos(new HashSet<>()).build();
        Articulo pizzaGrandeNapolitana = Articulo.builder().denominacion("Pizza grande Napolitana").precioVenta(1400.0).stockActual(8).stockMaximo(16).tiempoEstimadoMinutos(20).unidad(porciones8).imagen(imagen2).detallePedidos(new HashSet<>()).build();
        Articulo pizzaChicaNapolitana = Articulo.builder().denominacion("Pizza chica Napolitana").precioVenta(750.0).stockActual(12).stockMaximo(25).tiempoEstimadoMinutos(15).unidad(porciones4).imagen(imagen5).detallePedidos(new HashSet<>()).build();
        Articulo pizzaGrandeMuzza = Articulo.builder().denominacion("Pizza grande Muzza").precioVenta(1300.0).stockActual(10).stockMaximo(20).tiempoEstimadoMinutos(18).unidad(porciones8).imagen(imagen3).detallePedidos(new HashSet<>()).build();
        Articulo pizzaChicaMuzza = Articulo.builder().denominacion("Pizza chica Muzza").precioVenta(700.0).stockActual(14).stockMaximo(28).tiempoEstimadoMinutos(15).unidad(porciones4).imagen(imagen6).detallePedidos(new HashSet<>()).build();
        Articulo cervezaAndes = Articulo.builder().denominacion("Cerveza Andes").precioVenta(300.0).stockActual(20).stockMaximo(40).tiempoEstimadoMinutos(5).unidad(litro1).imagen(imagen7).detallePedidos(new HashSet<>()).build();
        Articulo cervezaQuilmes = Articulo.builder().denominacion("Cerveza Quilmes").precioVenta(250.0).stockActual(25).stockMaximo(50).tiempoEstimadoMinutos(5).unidad(litro1).imagen(imagen8).detallePedidos(new HashSet<>()).build();

        // Guardar artículos en el repositorio
        articuloRepo.save(pizzaGrandeHawaiana);
        articuloRepo.save(pizzaChicaHawaiana);
        articuloRepo.save(pizzaGrandeNapolitana);
        articuloRepo.save(pizzaChicaNapolitana);
        articuloRepo.save(pizzaGrandeMuzza);
        articuloRepo.save(pizzaChicaMuzza);
        articuloRepo.save(cervezaAndes);
        articuloRepo.save(cervezaQuilmes);

        // Crear y mostrar pedidos

        // Pedido 1: Cliente1 compra una Pizza grande Hawaiana y una Cerveza Quilmes
        HashSet<DetallePedido> detallesPedido1 = new HashSet<>();
        detallesPedido1.add(DetallePedido.builder().cantidad(1).subTotal(pizzaGrandeHawaiana.getPrecioVenta()).articulo(pizzaGrandeHawaiana).build());
        detallesPedido1.add(DetallePedido.builder().cantidad(1).subTotal(cervezaQuilmes.getPrecioVenta()).articulo(cervezaQuilmes).build());

        Pedido pedido1 = Pedido.builder()
                .cliente(cliente1)
                .detalles(detallesPedido1)
                .total(1750.0)
                .estado(Estado.proceso)
                .formaPago(FormaPago.efectivo)
                .tipoEnvio(TipoEnvio.enLocal)
                .fechaPedido(LocalDate.now())
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(25))
                .build();

        pedidoRepo.save(pedido1);
        cliente1.getHace().add(pedido1);
        mostrarPedido(pedido1);

        // Pedido 2: Cliente2 compra 3 Cervezas Quilmes y una Pizza chica Hawaiana
        HashSet<DetallePedido> detallesPedido2 = new HashSet<>();
        detallesPedido2.add(DetallePedido.builder().cantidad(3).subTotal(cervezaQuilmes.getPrecioVenta() * 3).articulo(cervezaQuilmes).build());
        detallesPedido2.add(DetallePedido.builder().cantidad(1).subTotal(pizzaChicaHawaiana.getPrecioVenta()).articulo(pizzaChicaHawaiana).build());

        Pedido pedido2 = Pedido.builder()
                .cliente(cliente2)
                .detalles(detallesPedido2)
                .total(1550.0)
                .estado(Estado.proceso)
                .formaPago(FormaPago.debito)
                .tipoEnvio(TipoEnvio.Delivery)
                .fechaPedido(LocalDate.now())
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(30))
                .build();

        pedidoRepo.save(pedido2);
        cliente2.getHace().add(pedido2);
        mostrarPedido(pedido2);

        // Pedido 3: Cliente3 compra 1 Pizza grande Hawaiana, 1 Pizza chica Muzza, 1 Pizza grande Napolitana, 2 Cervezas Andes
        HashSet<DetallePedido> detallesPedido3 = new HashSet<>();
        detallesPedido3.add(DetallePedido.builder().cantidad(1).subTotal(pizzaGrandeHawaiana.getPrecioVenta()).articulo(pizzaGrandeHawaiana).build());
        detallesPedido3.add(DetallePedido.builder().cantidad(1).subTotal(pizzaChicaMuzza.getPrecioVenta()).articulo(pizzaChicaMuzza).build());
        detallesPedido3.add(DetallePedido.builder().cantidad(1).subTotal(pizzaGrandeNapolitana.getPrecioVenta()).articulo(pizzaGrandeNapolitana).build());
        detallesPedido3.add(DetallePedido.builder().cantidad(2).subTotal(cervezaAndes.getPrecioVenta() * 2).articulo(cervezaAndes).build());

        Pedido pedido3 = Pedido.builder()
                .cliente(cliente3)
                .detalles(detallesPedido3)
                .total(3650.0)
                .estado(Estado.proceso)
                .formaPago(FormaPago.credito)
                .tipoEnvio(TipoEnvio.enLocal)
                .fechaPedido(LocalDate.now())
                .horaEstimadaFinalizacion(LocalTime.now().plusMinutes(35))
                .build();

        pedidoRepo.save(pedido3);
        cliente3.getHace().add(pedido3);
        mostrarPedido(pedido3);
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("Pedido:");
        System.out.println("Cliente: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido());
        System.out.println("Fecha: " + pedido.getFechaPedido());
        System.out.println("Hora estimada de finalización: " + pedido.getHoraEstimadaFinalizacion());
        System.out.println("Estado: " + pedido.getEstado());
        System.out.println("Forma de Pago: " + pedido.getFormaPago());
        System.out.println("Tipo de Envío: " + pedido.getTipoEnvio());
        System.out.println("Detalles:");
        for (DetallePedido detalle : pedido.getDetalles()) {
            System.out.println("- Artículo: " + detalle.getArticulo().getDenominacion() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubTotal());
        }
        System.out.println("Total: $" + pedido.getTotal());
        System.out.println("---------------");
    }
}

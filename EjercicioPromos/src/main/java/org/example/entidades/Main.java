package org.example.entidades;

import com.sun.source.tree.WhileLoopTree;
import org.example.repositorios.InMemoryRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Repositorios
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();
        InMemoryRepository<Articulo> articuloRepository = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepository = new InMemoryRepository<>();
        InMemoryRepository<Promocion> promoRepository = new InMemoryRepository<>();

        // Unidad de medida
        UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 Porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 Porciones").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();

        // Guardar unidades de medida
        unidadMedidaRepository.save(ochoPorciones);
        unidadMedidaRepository.save(cuatroPorciones);
        unidadMedidaRepository.save(litro);

        // Imagenes
        Imagen imagen1 = Imagen.builder().denominacion("Imagen grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().denominacion("Imagen grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().denominacion("Imagen grande Muzza").build();
        Imagen imagen4 = Imagen.builder().denominacion("Imagen chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().denominacion("Imagen chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().denominacion("Imagen chica Muzza").build();
        Imagen imagenCerveza1 = Imagen.builder().denominacion("Imagen Andes").build();
        Imagen imagenCerveza2 = Imagen.builder().denominacion("Imagen Quilmes").build();
        Imagen imaHappy1 = Imagen.builder().denominacion("Imagen Promo1 Happyhour").build();
        Imagen imaHappy2 = Imagen.builder().denominacion("Imagen Promo2 Happyhour").build();
        Imagen verano1 = Imagen.builder().denominacion("Imagen Promo1 Verano").build();
        Imagen verano2 = Imagen.builder().denominacion("Imagen Promo2 Verano").build();
        Imagen invierno1 = Imagen.builder().denominacion("Imagen Promo1 Invierno").build();
        Imagen invierno2 = Imagen.builder().denominacion("Imagen Promo2 Invierno").build();

        // Guardar imagenes
        imagenRepository.save(imagen1);
        imagenRepository.save(imagen2);
        imagenRepository.save(imagen3);
        imagenRepository.save(imagen4);
        imagenRepository.save(imagen5);
        imagenRepository.save(imagen6);
        imagenRepository.save(imagenCerveza1);
        imagenRepository.save(imagenCerveza2);
        imagenRepository.save(imaHappy1);
        imagenRepository.save(imaHappy2);
        imagenRepository.save(verano1);
        imagenRepository.save(verano2);
        imagenRepository.save(invierno1);
        imagenRepository.save(invierno2);


        // Articulos
        Articulo pizza1 = Articulo.builder()
                .denominacion("Pizza grande Hawaiana")
                .imagen(imagen1)
                .precioCompra(20.0)
                .precioVenta(35.0)
                .stockActual(40)
                .stockMaximo(50)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza2 = Articulo.builder()
                .denominacion("Pizza grande Napolitana")
                .imagen(imagen2)
                .precioCompra(16.0)
                .precioVenta(30.0)
                .stockActual(14)
                .stockMaximo(70)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza3 = Articulo.builder()
                .denominacion("Pizza grande Muzza")
                .imagen(imagen3)
                .precioCompra(18.0)
                .precioVenta(32.0)
                .stockActual(21)
                .stockMaximo(90)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizza4 = Articulo.builder()
                .denominacion("Pizza chica Hawaiana")
                .imagen(imagen4)
                .precioCompra(10.0)
                .precioVenta(21.0)
                .stockActual(9)
                .stockMaximo(70)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizza5 = Articulo.builder()
                .denominacion("Pizza chica Napolitana")
                .imagen(imagen1)
                .precioCompra(8.0)
                .precioVenta(16.0)
                .stockActual(23)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizza6 = Articulo.builder()
                .denominacion("Pizza chica Muzza")
                .imagen(imagen6)
                .precioCompra(9.0)
                .precioVenta(19.0)
                .stockActual(81)
                .stockMaximo(120)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo cerveza1 = Articulo.builder()
                .denominacion("Cerveza Andes")
                .imagen(imagenCerveza1)
                .precioCompra(2.5)
                .precioVenta(6.0)
                .stockActual(40)
                .stockMaximo(200)
                .unidadMedida(litro)
                .build();

        Articulo cerveza2 = Articulo.builder()
                .denominacion("Cerveza Quilmes")
                .imagen(imagenCerveza2)
                .precioCompra(3.0)
                .precioVenta(7.5)
                .stockActual(80)
                .stockMaximo(200)
                .unidadMedida(litro)
                .build();

        // Guardar Articulos
        articuloRepository.save(pizza1);
        articuloRepository.save(pizza2);
        articuloRepository.save(pizza3);
        articuloRepository.save(pizza4);
        articuloRepository.save(pizza5);
        articuloRepository.save(pizza6);
        articuloRepository.save(cerveza1);
        articuloRepository.save(cerveza2);

        // Promociones
        TipoPromocion promocionHappyHour = TipoPromocion.happyHour;
        double precioSinRedondear = (pizza1.getPrecioCompra() + pizza3.getPrecioCompra() + cerveza2.getPrecioCompra()) *0.8;
        double precioRedondeado = Math.round(precioSinRedondear * 100.0) / 100.0;
        Promocion promo1 = Promocion.builder()
                .denominacion("Happy hour")
                .articulos(new HashSet<>(Set.of(pizza1, pizza3, cerveza2)))
                .imagenesPromo(new HashSet<>(Set.of(imaHappy1, imaHappy2)))
                .fechaDesde(LocalDate.of(2024, 9, 10))
                .fechaHasta(LocalDate.of(2024,9,20))
                .horaDesde(LocalTime.of(18,30,0))
                .horaHasta(LocalTime.of(22,0,0))
                .tipoPromocion(promocionHappyHour)
                .descripcionDescuento("Promocion especial 1 (20% descuento)")
                .precioPromocional(precioRedondeado)
                .build();

        TipoPromocion promocionVverano = TipoPromocion.Verano;
        double precioSinRedondear2 = (pizza4.getPrecioCompra() + pizza2.getPrecioCompra() + cerveza2.getPrecioCompra() + cerveza1.getPrecioCompra()) *0.65;
        double precioRedondeado2 = Math.round(precioSinRedondear2 * 100.0) / 100.0;
        Promocion promo2 = Promocion.builder()
                .denominacion("Promocion de verano")
                .articulos(new HashSet<>(Set.of(pizza4, pizza2, cerveza2, cerveza1)))
                .imagenesPromo(new HashSet<>(Set.of(verano1, verano2)))
                .fechaDesde(LocalDate.of(2024, 11, 1))
                .fechaHasta(LocalDate.of(2024,2,28))
                .horaDesde(LocalTime.of(14,0,0))
                .horaHasta(LocalTime.of(20,30,0))
                .tipoPromocion(promocionVverano)
                .descripcionDescuento("Promocion especial 2 (35% descuento)")
                .precioPromocional(precioRedondeado2)
                .build();

        TipoPromocion promocionInvierno = TipoPromocion.Invierno;
        double precioSinRedondear3 = (pizza1.getPrecioCompra() + pizza6.getPrecioCompra() + cerveza2.getPrecioCompra()) *0.9;
        double precioRedondeado3 = Math.round(precioSinRedondear3 * 100.0) / 100.0;
        Promocion promo3 = Promocion.builder()
                .denominacion("Happy hour")
                .articulos(new HashSet<>(Set.of(pizza1, pizza6, cerveza2)))
                .imagenesPromo(new HashSet<>(Set.of(invierno1, invierno2)))
                .fechaDesde(LocalDate.of(2024, 5, 1))
                .fechaHasta(LocalDate.of(2024,7,10))
                .horaDesde(LocalTime.of(15,30,0))
                .horaHasta(LocalTime.of(19,0,0))
                .tipoPromocion(promocionInvierno)
                .descripcionDescuento("Promocion especial 3 (10% descuento)")
                .precioPromocional(precioRedondeado3)
                .build();

        // Guardar promociones
        promoRepository.save(promo1);
        promoRepository.save(promo2);
        promoRepository.save(promo3);

        Scanner leer = new Scanner(System.in);
        while (true){
            System.out.println();
            System.out.println("Elija una opcion: \n1- Todas las promos\n2- Todos los articulos\n3- Seleccionar promocion para ver\n4- Dia y horario promocion verano\n5- Mostrar promocion mas economica\n0- Salir");
            int opcion = leer.nextInt();
            System.out.println();

            switch (opcion){
                case 0:
                    break;

                case 1:
                    List<Promocion> promociones = promoRepository.findAll();
                    promociones.forEach(System.out::println);
                    break;

                case 2:
                    List<Articulo> articulos = articuloRepository.findAll();
                    articulos.forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Ingrese el id que desea buscar (1-3): ");
                    Long id = leer.nextLong();

                    Optional<Promocion> promoEncontrada = promoRepository.findById(id);
                    promoEncontrada.ifPresent(a -> System.out.println("Promocion" + id + ":  " + a));
                    break;

                case 4:
                    Optional<Promocion> promoVerano = promoRepository.findById(2L);

                    promoVerano.ifPresent(a -> System.out.println("Promocion de verano! " +
                            "\nDe: " +  a.getHoraDesde() + "hs a: " + a.getHoraHasta() + "hs" +
                            "\nDesde: " + a.getFechaDesde()  +
                            "\nHasta: " + a.getFechaHasta()));
                    break;

                case 5:
                    List<Promocion> allPromo = promoRepository.findAll();

                    Promocion menorPrecio = allPromo.get(0);

                    for (Promocion promo : allPromo){
                        if (promo.getPrecioPromocional() < menorPrecio.getPrecioPromocional()){
                            menorPrecio = promo;
                        }
                    }

                    System.out.println("La promo mas economica es: " + "\nDenominación: " + menorPrecio.getDenominacion() +
                            "\nPrecio: " + menorPrecio.getPrecioPromocional());
                    break;
            }
            if (opcion == 0){
                break;
            }

            System.out.println();
            System.out.println("Desea consultar algo mas? (s/n)");
            String salir = leer.next();

            if (salir.equalsIgnoreCase("n")){
                break;
            }

        }

    }
}
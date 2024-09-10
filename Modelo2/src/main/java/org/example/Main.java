package org.example;

import org.example.Repositorio.InMemoryRepository;
import org.example.Entidades.*;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Geronimo");

        //inicializo repositorios
        InMemoryRepository<Articulo> articuloRepo = new InMemoryRepository<>();
        InMemoryRepository<Promocion> promocionRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepo = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepo = new InMemoryRepository<>();


        //crear unidades de medida
        UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 Porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 Porciones").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("1 litro").build();

        //guardo lo creado
        unidadMedidaRepo.save(ochoPorciones);
        unidadMedidaRepo.save(cuatroPorciones);
        unidadMedidaRepo.save(litro);

        //crear imagenes
        Imagen imagen1 = Imagen.builder().denominacion("Pizza grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().denominacion("Pizza grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().denominacion("Pizza grande Muzza").build();
        Imagen imagen4 = Imagen.builder().denominacion("Pizza chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().denominacion("Pizza chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().denominacion("Pizza chica Muzza").build();
        Imagen imagen7 = Imagen.builder().denominacion("Carveza Andes").build();
        Imagen imagen8 = Imagen.builder().denominacion("Cerveza Quilmes").build();

        Imagen imahappy1 = Imagen.builder().denominacion("Imagen 1 Happy Hour").build();
        Imagen imahappy2 = Imagen.builder().denominacion("Imagen 2 Happy Hour").build();
        Imagen verano1 = Imagen.builder().denominacion("Imagen 1 Verano").build();
        Imagen verano2 = Imagen.builder().denominacion("Imagen 2 Verano").build();
        Imagen invierno1 = Imagen.builder().denominacion("Imagen 1 Invierno").build();
        Imagen invierno2 = Imagen.builder().denominacion("Imagen 2 Invierno").build();
        Imagen cerveza1 = Imagen.builder().denominacion("Cerveza Andes").build();
        Imagen cerveza2 = Imagen.builder().denominacion("Cerveza Quilmes").build();

        //crear articulos
        Articulo hawaianaGrande = Articulo.builder()
                .denominacion("Pizza Hawaiana Grande")
                .precioCompra(10.0)
                .precioVenta(20.0)
                .stockActual(30)
                .stockMaximo(50)
                .imagen(imagen1)
                .unidadMedida(ochoPorciones)
                .build();
        Articulo hawaianaChica = Articulo.builder()
                .denominacion("Pizza Hawaiana Chica")
                .precioCompra(8.0)
                .precioVenta(16.0)
                .stockActual(40)
                .stockMaximo(60)
                .imagen(imagen4)
                .unidadMedida(cuatroPorciones)
                .build();
        Articulo napolitanaGrande = Articulo.builder()
                .denominacion("Pizza Napolitana Grande")
                .precioCompra(9.0)
                .precioVenta(18.0)
                .stockActual(50)
                .stockMaximo(90)
                .imagen(imagen2)
                .unidadMedida(ochoPorciones)
                .build();
        Articulo napolitanaChica = Articulo.builder()
                .denominacion("Pizza Napolitana Chica")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(70)
                .stockMaximo(120)
                .imagen(imagen5)
                .unidadMedida(cuatroPorciones)
                .build();
        Articulo muzzaGrande = Articulo.builder()
                .denominacion("Pizza muzza Grande")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(80)
                .stockMaximo(120)
                .imagen(imagen3)
                .unidadMedida(ochoPorciones)
                .build();
        Articulo muzzaChica = Articulo.builder()
                .denominacion("Pizza muzza Chica")
                .precioCompra(7.0)
                .precioVenta(14.0)
                .stockActual(80)
                .stockMaximo(130)
                .imagen(imagen6)
                .unidadMedida(cuatroPorciones)
                .build();


        Articulo andes = Articulo.builder()
                .denominacion("Cerveza Andes")
                .precioCompra(5.0)
                .precioVenta(9.0)
                .stockActual(80)
                .stockMaximo(130)
                .imagen(cerveza1)
                .unidadMedida(litro)
                .build();

        Articulo quilmes = Articulo.builder()
                .denominacion("Cerveza Quilmes")
                .precioCompra(4.0)
                .precioVenta(8.0)
                .stockActual(60)
                .stockMaximo(100)
                .imagen(cerveza2)
                .unidadMedida(litro)
                .build();

        //guardo articulos
        articuloRepo.save(hawaianaGrande);
        articuloRepo.save(hawaianaChica);
        articuloRepo.save(napolitanaGrande);
        articuloRepo.save(napolitanaChica);
        articuloRepo.save(muzzaGrande);
        articuloRepo.save(muzzaChica);
        articuloRepo.save(andes);
        articuloRepo.save(quilmes);

        //creo promociones
        Promocion happyHour = Promocion.builder()
                .denominacion("Promocion Happy Hour")
                .articulos(new HashSet<>(Set.of(hawaianaGrande, muzzaGrande, quilmes)))
                .HoraDesde(LocalTime.of(19, 00, 0))
                .HoraHasta(LocalTime.of(21, 00, 0))
                .FechaDesde(LocalDate.of(2024, 9, 2))
                .FechaHasta(LocalDate.of(2024, 11, 2))
                .descripcionDescuento("20% de descuento realizando la compra entre las 19 y las 21 horas. Valida desde el 2 de Septiembre hasta el dia 2 de Noviembre")
                .precioPromocional((hawaianaGrande.getPrecioVenta() + muzzaGrande.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.8)
                .tipoPromocion(TipoPromocion.happyHour)
                .promoImagen(new HashSet<>(Set.of(imahappy1, imahappy2)))
                .build();


        Promocion verano = Promocion.builder()
                .denominacion("Promocion Verano 2025")
                .articulos(new HashSet<>(Set.of(hawaianaChica, napolitanaGrande, andes, quilmes)))
                .HoraDesde(LocalTime.of(19, 30, 0))
                .HoraHasta(LocalTime.of(21, 30, 0))
                .FechaDesde(LocalDate.of(2024, 12, 21))
                .FechaHasta(LocalDate.of(2025, 3, 20))
                .descripcionDescuento("15% de descuento en esta promocion valida en todo el verano 2024-2025 en pedidos realizados entre las 19:30 y las 21:30")
                .precioPromocional((hawaianaChica.getPrecioVenta() + napolitanaGrande.getPrecioVenta() + andes.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.85) //precio original de 51
                .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                .tipoPromocion(TipoPromocion.Verano)
                .build();

        Promocion invierno = Promocion.builder()
                .denominacion("Promocion Invierno 2025")
                .articulos(new HashSet<>(Set.of(hawaianaGrande, muzzaChica, quilmes)))
                .HoraDesde(LocalTime.of(19, 30, 0))
                .HoraHasta(LocalTime.of(21, 30, 0))
                .FechaDesde(LocalDate.of(2025, 6, 21))
                .FechaHasta(LocalDate.of(2025, 9, 20))
                .descripcionDescuento("Promocion valida en todo el invierno 2025 en pedidos realizados entre las 19:30 y las 21:30")
                .precioPromocional((hawaianaGrande.getPrecioVenta() + muzzaChica.getPrecioVenta() + quilmes.getPrecioVenta()) * 0.85) //precio original de 51
                .promoImagen(new HashSet<>(Set.of(verano1, verano2)))
                .tipoPromocion(TipoPromocion.Verano)
                .build();


        promocionRepo.save(happyHour);
        promocionRepo.save(verano);
        promocionRepo.save(invierno);

//

        //mostrar promociones
        System.out.println("----------Promociones-----------");
        for(Promocion promocion : promocionRepo.findAll()){
            System.out.println("Promocion " + promocion.getId() + " : " + promocion.getDenominacion());
        }

        //mostrar articulos
        System.out.println("----------Articulos-----------");

        for(Articulo articulo : articuloRepo.findAll()){
            System.out.println(articulo.getDenominacion());
        }

        //Mostrar cada promoción por separado y los artículos relacionados y el precio de venta.
        System.out.println("------Promociones con sus articulos y precio de venta------");
        System.out.println(happyHour.getDenominacion()+" que incluye " );
                for(Articulo articulo : happyHour.getArticulos()){
            System.out.print(articulo.getDenominacion()+", ");
        }
        System.out.println(" a un valor de $" + happyHour.getPrecioPromocional());
        System.out.println(verano.getDenominacion()+" que incluye ");
        for(Articulo articulo : verano.getArticulos()){
            System.out.print(articulo.getDenominacion() +", ");
        }
        System.out.println(" a un valor de $" + verano.getPrecioPromocional());
        System.out.println(invierno.getDenominacion()+" que incluye ");
        for(Articulo articulo : invierno.getArticulos()){
            System.out.print(articulo.getDenominacion()+", ");
        }
        System.out.println(" a un valor de $" + invierno.getPrecioPromocional());


        //mostrar horario y dias de la promocion verano
        System.out.println("---------Promocion Verano ------------");
        System.out.println("Fecha valida para la promocion: desde "+ verano.getFechaDesde() + " hasta "+ verano.getFechaHasta());
        System.out.println("entre las horas "+ verano.getHoraDesde() +" y las "+verano.getHoraHasta());

        //Mostrar cuál es la promoción más económica de las 3

        System.out.println("-------Promocion mas economica-------");

        Promocion promoEconomica = happyHour;
        if (verano.getPrecioPromocional() < promoEconomica.getPrecioPromocional()){
            promoEconomica = verano;
        } else if (invierno.getPrecioPromocional() < promoEconomica.getPrecioPromocional()){
            promoEconomica = invierno;
        }
        System.out.println("-------------------\nPROMO MÁS ECONÓMICA\n-------------------");
        System.out.println("La promocion mas economica es " + promoEconomica.getDenominacion() + " con un precio final de $" + promoEconomica.getPrecioPromocional());
    }


    }


package org.example;

import org.example.entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Crear y persistir categorías
            Categoria catElectronica = Categoria.builder()
                    .denominacion("Electrónica")
                    .build();

            Categoria catComputacion = Categoria.builder()
                    .denominacion("Computación")
                    .build();

            Categoria catAccesorios = Categoria.builder()
                    .denominacion("Accesorios")
                    .build();

            entityManager.persist(catElectronica);
            entityManager.persist(catComputacion);
            entityManager.persist(catAccesorios);

            // Crear y persistir artículos
            Articulo notebook = Articulo.builder()
                    .denominacion("Notebook HP")
                    .precio(250000)
                    .cantidad(10)
                    .build();

            Articulo mouse = Articulo.builder()
                    .denominacion("Mouse Gamer")
                    .precio(15000)
                    .cantidad(50)
                    .build();

            // Establecer relaciones entre artículos y categorías
            notebook.getCategorias().add(catElectronica);
            notebook.getCategorias().add(catComputacion);
            mouse.getCategorias().add(catComputacion);
            mouse.getCategorias().add(catAccesorios);

            catElectronica.getArticulos().add(notebook);
            catComputacion.getArticulos().add(notebook);
            catComputacion.getArticulos().add(mouse);
            catAccesorios.getArticulos().add(mouse);

            entityManager.persist(notebook);
            entityManager.persist(mouse);

            // Crear y persistir cliente con domicilio
            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("Belgrano")
                    .numero(789)
                    .build();

            Cliente cliente1 = Cliente.builder()
                    .nombre("Laura")
                    .apellido("González")
                    .dni(35789456)
                    .domicilio(domicilio1)
                    .build();

            domicilio1.setCliente(cliente1);

            entityManager.persist(cliente1);

            // Crear factura
            Factura factura1 = Factura.builder()
                    .numero(456)
                    .fecha("24/11/2024")
                    .cliente(cliente1)
                    .build();

            // Crear detalles de factura
            DetalleFactura detalle1 = DetalleFactura.builder()
                    .articulo(notebook)
                    .cantidad(1)
                    .subtotal(250000)
                    .factura(factura1)
                    .build();

            DetalleFactura detalle2 = DetalleFactura.builder()
                    .articulo(mouse)
                    .cantidad(2)
                    .subtotal(30000)
                    .factura(factura1)
                    .build();

            // Establecer relaciones
            notebook.getDetalle().add(detalle1);
            mouse.getDetalle().add(detalle2);
            factura1.getDetalle().add(detalle1);
            factura1.getDetalle().add(detalle2);
            factura1.setTotal(280000);

            entityManager.persist(factura1);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo grabar la Factura");
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
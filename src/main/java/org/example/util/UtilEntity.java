package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilEntity {

    // Fábrica de EntityManager creada una sola vez (singleton)
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // Método para crear la fábrica usando el nombre de la unidad de persistencia
    //El EntityManagerFactory es el que nos abre las puertas a la BD
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    // Método público para obtener un EntityManager desde cualquier parte del código
    //Nos permite hacer las operaciones con la BD
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}



/*
El EntityManagerFactory es una clase importante en el contexto de Java Persistence API
(JPA), que es una especificación para mapear objetos Java a una base de datos relacional.
EntityManagerFactory es responsable de crear instancias de EntityManager, el cual se
utiliza para interactuar con la base de datos en JPA. EntityManagerFactory configura la
conexión a la base de datos y EntityManager representa una “unidad de trabajo”,
realiza las operaciones de persistencia, como insertar, actualizar y eliminar datos.

Cuando trabajas con JPA, generalmente configuras un archivo de persistencia
(como el persistence.xml) que contiene información sobre cómo establecer la conexión con
la base de datos y cómo se deben gestionar las entidades. El archivo “persistent” es un
archivo de metadatos y debe estar ubicado en el directorio “META-INF” en la estructura
del archivo de la aplicación Java. “META-INF” es una convención utilizada en Java para
almacenar metadatos y recursos específicos de la aplicación.
 */
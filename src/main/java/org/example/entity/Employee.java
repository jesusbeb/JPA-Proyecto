package org.example.entity;

import jakarta.persistence.*;

/* Java Persistence API (JPA) es una especificacion estandar de Java que define
una interfaz para el manejo de la persistencia de datos en aplicaciones Java. Nos
ofrece un conjunto de anotaciones para interactuar con una BD.
- Sustituye sentencias SQL por codigo Java, porque hace una abstraccion a JDBC
- Podemos definir clases y metodos que actuan como los datos y operaciones
* */

//@Entity marca una clase JAva como una entidad que sera mapeada a una tabla en la BD
//@Table es la anotacion que usamos para indicar el nombre de la tabla en la BD
@Entity
@Table(name="employees")
public class Employee {

    //@Id Marca un atributo como la clave primaria de la entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincrementable
    private int id;
    //Si el nombre del campo en la BD es diferente al nombre en el atributo,
    //se especifica con la anotacion @Column
    @Column(name="first_name")
    private String firstName;
    @Column(name="pa_surname")
    private String paSurname;
    @Column(name = "ma_surname")
    private String maSurname;
    private String email;
    private Float salary;


    //Costructor vacio
    public Employee() {
    }

    //Constructor con todos sus atributos
    public Employee(int id, String firstName, String paSurname, String maSurname, String email, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.paSurname = paSurname;
        this.maSurname = maSurname;
        this.email = email;
        this.salary = salary;
    }


    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPaSurname() {
        return paSurname;
    }

    public void setPaSurname(String paSurname) {
        this.paSurname = paSurname;
    }

    public String getMaSurname() {
        return maSurname;
    }

    public void setMaSurname(String maSurname) {
        this.maSurname = maSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", paSurname='" + paSurname + '\'' +
                ", maSurname='" + maSurname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}


/*
JPA (Java Persistence API) y JDBC (Java Database Connectivity) son dos tecnologías
utilizadas en Java para interactuar con bases de datos. A continuación, te
explicaré las diferencias principales entre ambas:

Nivel de abstracción:
JDBC: Es una API de bajo nivel que proporciona un conjunto de clases e interfaces para
acceder a bases de datos directamente. Requiere escribir código manualmente para
establecer conexiones, enviar consultas SQL y manejar el procesamiento de resultados.
JPA: Es una API de alto nivel que proporciona una capa de abstracción adicional
sobre JDBC. Permite trabajar con objetos Java de manera transparente y mapearlos a
tablas en la base de datos. JPA se basa en el patrón de diseño ORM
(Object-Relational Mapping) para facilitar la persistencia y recuperación de objetos.

Mapeo objeto-relacional:
JDBC: No ofrece soporte nativo para el mapeo objeto-relacional. Los resultados de
las consultas se obtienen en forma de conjuntos de filas y columnas de la base de
datos, y el desarrollador debe procesar manualmente estos resultados y mapearlos a
objetos Java.
JPA: Proporciona un mecanismo de mapeo objeto-relacional automático. Utiliza
anotaciones o archivos XML para establecer relaciones entre las clases Java y las
tablas de la base de datos. Los objetos se pueden guardar, actualizar, eliminar y
consultar directamente sin la necesidad de escribir consultas SQL.

Productividad y mantenibilidad:
JDBC: Al ser una API de bajo nivel, el desarrollo con JDBC puede ser más tedioso y
propenso a errores. Requiere escribir una cantidad significativa de código
manualmente para realizar operaciones básicas en la base de datos. Además,
cualquier cambio en el esquema de la base de datos puede requerir modificaciones
en el código JDBC.
JPA: Al proporcionar una capa de abstracción más alta y un mapeo objeto-relacional
automático, JPA simplifica el desarrollo y mejora la productividad. Permite
escribir menos código y facilita el mantenimiento, ya que los cambios en el
esquema de la base de datos se pueden reflejar en las clases Java a través del mapeo.

Portabilidad:
JDBC: Al ser una API estándar de Java, JDBC es ampliamente compatible y se puede
utilizar con la mayoría de los sistemas de gestión de bases de datos (DBMS) disponibles.
JPA: JPA es una especificación de Java EE y, aunque se basa en JDBC, requiere un
proveedor de persistencia específico (como Hibernate o EclipseLink) para
interactuar con la base de datos. Aunque muchos proveedores son compatibles con
JPA, puede haber diferencias en las características y el rendimiento entre ellos.

En resumen, JPA proporciona una capa de abstracción más alta, un mapeo
objeto-relacional automático y una mayor productividad en comparación con JDBC.
Sin embargo, si se requiere un mayor control y rendimiento a nivel de base de
datos, JDBC puede ser más adecuado.


JPQL (Java Persistence Query Language)
Lenguaje de consultas orientado a objetos utilizado en JPS para realizar operaciones de
persistencia en bases de datos relacionales.
*/
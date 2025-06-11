package org.example;

import org.example.entity.Employee;
import org.example.util.UtilEntity;

import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creamos la unidad EntityManager
        //Guardamos en la lista employees, los resultados de la consulta SQL a la BD
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("-----Listando todos los empleados-----");
        //Imprimos el contenido de la lista employees
        employees.forEach(System.out::println);

    }
}

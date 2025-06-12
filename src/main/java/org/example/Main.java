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

        System.out.println("------Buscando por ID------");
        int employeeID = 3;
        Employee employee = em.find(Employee.class, employeeID);
        System.out.println("Empleado encontrado: " + employee);

        /* Comentamos el codigo
        System.out.println("------Creando un empleado------");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Diego");
        newEmployee.setPaSurname("Lechuga");
        newEmployee.setMaSurname("Pimentel");
        newEmployee.setEmail("diego@mail.com");
        newEmployee.setSalary(30000F);

        em.getTransaction().begin();
        em.persist(newEmployee);
        em.getTransaction().commit();
        System.out.println("Nuevo empleado creado: " +newEmployee);
        */

        /* Comentando el codigo
        System.out.println("-----ACTUALIZANDO EMPLEADO-----");
        int employeeUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeUpdateId);
        System.out.println("Empleado a modificar: " +employeeToUpdate);

        employeeToUpdate.setFirstName("Irving");
        employeeToUpdate.setPaSurname("Juarez");
        employeeToUpdate.setSalary((float)97000);

        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();

        System.out.println("Empleado actualizado: " +employeeToUpdate);
        */

        System.out.println("-----Eliminando empleado-----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado eliminado: " +employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();


    }
}

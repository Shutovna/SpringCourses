package com.example.sandbox.employee;

import com.example.sandbox.student.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastname(String lastname) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where e.lastName like :lastname", Employee.class);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }

    @Override
    public void delete(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);
        if(dbEmployee != null) {
            entityManager.remove(dbEmployee);
        }
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("delete from Employee ").executeUpdate();
    }
}

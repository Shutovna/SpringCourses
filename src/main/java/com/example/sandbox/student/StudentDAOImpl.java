package com.example.sandbox.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student st) {
        entityManager.persist(st);
    }

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s order by s.lastname asc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastname) {
        lastname = "%" + lastname + "%";
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s where s.lastname like :lastname order by s.lastname desc", Student.class);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(Student student) {
        Student persStudent = entityManager.find(Student.class, student.getId());
        if (persStudent != null) {
            entityManager.remove(persStudent);
        }
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("delete from Student ").executeUpdate();
    }


}

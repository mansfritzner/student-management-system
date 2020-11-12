package se.iths.service;

import se.iths.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    private static EntityManager entityManager;
   

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student deleteStudent(Long id){
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        return student;
    }


    public static List<Student> getByLastName(String name){
        return entityManager.createQuery("SELECT e FROM Student e WHERE e.lastname = \'"+ name + "\'", Student.class).getResultList();
    }



}

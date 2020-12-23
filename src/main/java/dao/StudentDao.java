package dao;

import entities.Student;
import javax.persistence.EntityManager;

public class StudentDao extends AbstractDao <Student, Long>{


    public StudentDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Student> entityClass() {
        return Student.class;
    }
}

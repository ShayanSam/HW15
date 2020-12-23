package dao;

import entities.Teacher;
import javax.persistence.EntityManager;

public class TeacherDao extends AbstractDao <Teacher, Long> {


    public TeacherDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Teacher> entityClass() {
        return Teacher.class;
    }
}

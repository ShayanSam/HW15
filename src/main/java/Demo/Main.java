package Demo;

import dao.AbstractDao;
import dao.AddressDao;
import dao.StudentDao;
import dao.TeacherDao;

import entities.Address;
import entities.Student;
import entities.Teacher;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        System.out.println("Start................................................................................................");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            StudentDao studentDao = new StudentDao(entityManager);
            TeacherDao teacherDao = new TeacherDao(entityManager);
            AddressDao addressDao = new AddressDao(entityManager);
            Student student = new Student("Shayan","Sam","AB78", LocalDate.of(1966,12,6));
            Teacher teacher = new Teacher("James","Baily","KJ876",2000.00,LocalDate.of(1977,6,16));
            Address address = new Address("3459890987","NA","TH","177-76-54","8788876543");
            Address address2 = new Address("13452345544","CA","TX","1779-56-64","9809887987");
            Set<Address> addresses = new HashSet<>();
            Set<Student> students = new HashSet<>();



            addresses.add(address);
            students.add(student);
            student.setAddresses(addresses);
            teacher.setAddress(address2);
            teacher.setStudents(students);
            teacherDao.save(teacher);
            studentDao.save(student);
            System.out.println(teacherDao.load(1L));
            System.out.println(studentDao.load(1L));
            System.out.println(addressDao.load(22L));
            System.out.println(addressDao.load(23L));

            entityTransaction.commit();


        }catch (Exception e){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            JpaUtil.shutdown();
            System.out.println("Done................................................................................................");
        }

    }
}

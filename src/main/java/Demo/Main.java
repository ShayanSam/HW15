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
            Student student = new Student("Shayan","Sam","HG23", LocalDate.of(1986,12,6));
            Teacher teacher = new Teacher("mark","Helmark","Jk76",2000.00,LocalDate.of(1967,6,16));
            Address address = new Address(22L,"09765768434","VA","TH","1000-76-54","8776544354");
            Address address2 = new Address(23L,"09767868434","CA","TX","1099-56-64","8748934564");
            Set<Address> addresses = new HashSet<>();
            Set<Student> students = new HashSet<>();
//            addresses.add(address);
//            students.add(student);
//            student.setAddresses(addresses);
//            teacher.setAddress(address2);
//            teacher.setStudents(students);
//            teacherDao.save(teacher);
//            studentDao.save(student);
//            System.out.println(teacherDao.load(1L));
//            System.out.println(studentDao.load(1L));
//            System.out.println(addressDao.load(22L));
//            System.out.println(addressDao.load(23L));





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

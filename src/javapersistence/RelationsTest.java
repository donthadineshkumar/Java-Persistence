package javapersistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import persist.entities.Author;
import persist.entities.AuthorDetail;
import persist.entities.BookAuthor;
import persist.entities.Course;
import persist.entities.Customer;
import persist.entities.PurchaseOrder;
import persist.entities.Student;

public class RelationsTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaPersistencePU");
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction entr = em.getTransaction();
            entr.begin();
//            
//           AuthorDetail adetail = new AuthorDetail("W","H","TG","W","504");
//           Author author = new Author("Dinesh","THis is my bio",adetail);
//            Customer customer = new Customer();
//            customer.setCustomerName("Padma");
//            customer.setCustomerCity("Warangal");
//            customer.setPhoneNumber("9849751031");
//
//            PurchaseOrder po1 = new PurchaseOrder();
//            po1.setCustomerId(customer);
//            po1.setPurchasedProduct("Gold");
//            po1.setPurchaseAmount("200000");
//
//            PurchaseOrder po2 = new PurchaseOrder();
//            po2.setCustomerId(customer);
//            po2.setPurchasedProduct("Silver");
//            po2.setPurchaseAmount("50000");
//
//            List<PurchaseOrder> polist = new ArrayList<PurchaseOrder>();
//            polist.add(po1);
//            polist.add(po2);
//
//            customer.setPurchaseOrderList(polist);
//
//            Student student1 = new Student();
//            student1.setName("Rajesh");
//            student1.setCity("Tirupathi");
//            student1.setDob(new Date());
//            
//            Student student2 = new Student();
//            student2.setName("Eshwar");
//            student2.setCity("Vemulawada");
//            student2.setDob(new Date());
//           
//            Course course1 = new Course();
//            course1.setName("Java");
//            course1.setStartDate(new Date());
//            course1.setCourseVenue("Hyderabad");
//            
//           Course course2 = new Course();
//            course2.setName("Scala");
//            course2.setStartDate(new Date());
//            course2.setCourseVenue("Mumbai");
//                       
//            List<Course> clist1 = new ArrayList<Course>();
//            clist1.add(course2);
//            
//            List<Course> clist2 = new ArrayList<Course>();
//             clist2.add(course1);
//              
//              
//        List<Student> slist1 = new ArrayList<Student>();
//            slist1.add(student1);
//            
//        List<Student> slist2 = new ArrayList<Student>();
//            slist2.add(student2);
//             slist2.add(student1);
//             
//              
//              course1.setStudents(slist2);
//              student1.setCourses(clist2);
//              course2.setStudents(slist1);
//              student2.setCourses(clist1);
//            
            
            Query query = em.createNamedQuery("BookAuthor.findAll");
            List authorlist = query.getResultList();
            Iterator aiterator = authorlist.iterator();
         
            while (aiterator.hasNext()) {
                BookAuthor author = (BookAuthor) aiterator.next();
                System.out.println("Author Name: " +  author.getLastName() + " " + author.getFirstName() + " -> " + author.getBio());
                System.out.println();
            }
             System.out.println("Here I am ");
//            
//            boolean successful = false;
//            em.persist(course1);
//            em.persist(student1);
//            em.persist(course2);
//            em.persist(student2);
//
//            successful = true;
//
//            if (successful) {
//                entr.commit();
//                System.out.println("committed");
//            } else {
//                entr.rollback();
//                System.out.println("Rolled back");
//            }


        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}

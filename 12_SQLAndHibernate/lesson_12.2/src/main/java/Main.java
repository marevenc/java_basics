import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateInit.init();
        Session session = HibernateInit.getSession(sessionFactory);
        Transaction t = session.beginTransaction();

        String hql = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseListRecords = session.createQuery(hql).getResultList();

        for(PurchaseList purchaseList : purchaseListRecords){
            LinkedPurchaseListPK pk = new LinkedPurchaseListPK();

            hql = "From Student Where name = :paramName";
            Query query = session.createQuery(hql);
            query.setParameter("paramName", purchaseList.getId().getStudentName());
            List<Student> studentRecord = query.list();

            hql = "From Course Where name = :paramName";
            query = session.createQuery(hql);
            query.setParameter("paramName", purchaseList.getId().getCourseName());
            List<Course> courseRecord = query.list();

            pk.setStudentId(studentRecord.get(0).getId());
            pk.setCourseId(courseRecord.get(0).getId());
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(pk);
            session.save(linkedPurchaseList);
        }

        t.commit();
        sessionFactory.close();
    }
}

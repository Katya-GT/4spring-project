package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {

      sessionFactory.getCurrentSession().save(user);
   }

   @Override
 @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User").list();


   }
@Override
   public User findUserByCar(String model, int series) {
   return (User) sessionFactory.getCurrentSession().createQuery("from User where car.model = :model and car.series = :series")
           .setParameter("model", model)
           .setParameter("series", series)
           .uniqueResult();
}
}
package hiber.service;


import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SqlRequest {
    private String model;
    private int series;

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    private final SessionFactory sessionFactory;

    @Autowired
    public SqlRequest(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public String findUserByCarModelAndSeries(String model, int series) {

        Session session = sessionFactory.getCurrentSession();
        User user = null;
        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        user = query.uniqueResult();
        if (user != null) {
            return user.toString();
        } else {
            return "Пользователи, удовлетворяющие заданным параметрам, отсутствуют";
        }

    }
}
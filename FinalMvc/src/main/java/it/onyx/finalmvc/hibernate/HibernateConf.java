package it.onyx.finalmvc.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.onyx.finalmvc.dao.DaoMvc;

public class HibernateConf {
	

	
	public static DaoMvc select(String email, String password) {
		Configuration cfg = new Configuration();
		cfg.configure("hib.cfg.xml");

		Session session = cfg.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DaoMvc> cr = cb.createQuery(DaoMvc.class);
		
		Root<DaoMvc> root =cr.from(DaoMvc.class);
		cr.select(root).where(cb.equal(root.get("email"), email),cb.equal(root.get("password"), password));
		
		Query<DaoMvc> query = session.createQuery(cr);
		DaoMvc ud =query.getSingleResult();
		session.close();

		return ud;
	}
	
	public static DaoMvc insert(DaoMvc daoMvc) {
		
		Configuration cfg=new Configuration(); 
		cfg.configure("hib.cfg.xml");
        Session session = cfg.buildSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.save(daoMvc);
        session.getTransaction().commit();
        return daoMvc;
	}
	
	public static DaoMvc update(DaoMvc daoMvc) {
		Configuration cfg=new Configuration(); 
		cfg.configure("hib.cfg.xml");
        Session session = cfg.buildSessionFactory().getCurrentSession();
        session.beginTransaction();
		
        CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<DaoMvc> update = cb.createCriteriaUpdate(DaoMvc.class);
		Root<DaoMvc> root = update.from(DaoMvc.class);
		update.set("nome", daoMvc.getNome());
		update.set("cognome", daoMvc.getCognome());
		update.set("num_telefono", daoMvc.getNum_telefono());
		update.set("email", daoMvc.getEmail());
		update.set("password", daoMvc.getPassword());
		update.where(cb.equal(root.get("ID_Cliente"), daoMvc.getId_cliente()));
		session.createQuery(update).executeUpdate();
		return daoMvc;
	}
	public static DaoMvc delete(DaoMvc daoMvc) {
		Configuration cfg=new Configuration(); 
		cfg.configure("hib.cfg.xml");
        Session session = cfg.buildSessionFactory().getCurrentSession();
        session.beginTransaction();
		
        CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<DaoMvc> delete = cb.createCriteriaDelete(DaoMvc.class);
		Root<DaoMvc> root = delete.from(DaoMvc.class);
		delete.where(cb.equal(root.get("email"), daoMvc.getEmail()));
		session.createQuery(delete).executeUpdate();
		return daoMvc;
		
		
		
	}
}

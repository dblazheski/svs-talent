package infrastructure.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import core.application.services.bookDao;
import core.entities.Book;

public class HBookDao implements bookDao{

	public void insert(Book entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (RuntimeException e){
			if(tx!=null)
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	public void delete(Book entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (RuntimeException e){
			if(tx!=null)
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	public void update(Book entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (RuntimeException e){
			if(tx!=null)
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	public Book findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Book B WHERE B.id = :id");
		query.setLong("id", id);
		return (Book) query.uniqueResult();
	}

	public Book findByTitle(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Book B WHERE B.title = :title");
		query.setString("title", title);
		Book book = (Book) query.uniqueResult();
		session.close();
		return book;
	}

	public Book findByIsbn(String isbn) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Book B WHERE B.isbn = :isbn");
		query.setString("isbn", isbn);
		Book book = (Book) query.uniqueResult();
		session.close();
		return book;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Book");
		List<Book> books = query.list();
		session.close();
		return books;
	}

}

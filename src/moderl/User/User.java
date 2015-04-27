package moderl.User;

import java.util.List;

import model.Hibernate.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.BeanUser;

public class User {
	private Session sesion;
	private Transaction tx;
	
	/**
	 * Method for create hibernate session
	 * @throws HibernateException
	 */
	private void initOp() throws HibernateException{
		sesion = HibernateUtil.getSession().openSession();
		if(sesion !=null){
			tx = sesion.beginTransaction();
		}
	}
	/**
	 * Custom control for hibernate exception
	 * @param he
	 * @throws HibernateException
	 */
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Ocurrio un error en la capa de acceso a datos", he);
	}
	
	/**
	 * Method to save new Users
	 * @param user
	 * @return
	 */
	public int saveUser(BeanUser user){
		int id=0;
		try {
			initOp();
			if(sesion!=null){
			id = (Integer) sesion.save(user);
			tx.commit();
			}
		} catch (HibernateException e) {
			manejaExcepcion(e);
			throw e;
		}
		finally{
			sesion.close();
		}
		return id;
	}
	
	/**
	 * Method to update Users
	 * @param user
	 * @throws HibernateException
	 */
	public void updateUser(BeanUser user) throws HibernateException{
		try {
			initOp();
			if(sesion!=null){
				sesion.update(user);
				tx.commit();	
			}
		} catch (HibernateException e) {
			manejaExcepcion(e);
			throw e;
		}
		finally{
			sesion.close();
		}
	}
	/**
	 * Method to delete the User
	 * @param user
	 * @throws HibernateException
	 */
	public void deleteUser(BeanUser user) throws HibernateException{
		try {
			initOp();
			if(sesion!=null){
			sesion.delete(user);
			tx.commit();
			}
		} catch (HibernateException e) {
			manejaExcepcion(e);
			throw e;
		}
		finally{
			sesion.close();
		}
	}
	/**
	 * Method to fill bean with a especial id
	 * @param id
	 * @return Bean User
	 * @throws HibernateException
	 */
	public BeanUser getUserById(int id) throws HibernateException{
		BeanUser user = null;
		try {
			initOp();
			if(sesion!=null){
				user = (BeanUser) sesion.get(User.class, id);
			}
		} catch (HibernateException e) {
			throw e;
		}
		finally{
			sesion.close();
		}
		return user;
	}
	@SuppressWarnings("unchecked")
	/**
	 * Method to get a List of Users
	 * @return List<BeanUser>
	 * @throws HibernateException
	 */
	public List<BeanUser> getListUser() throws HibernateException{
		List<BeanUser> lstUser = null;
		try {
			initOp();
			if(sesion!=null){
			lstUser = sesion.createQuery("from BeanUser").list();
			}
		} catch (HibernateException e) {
			throw e;
		}
		finally{
			sesion.close();
		}
		return lstUser;
	}
}

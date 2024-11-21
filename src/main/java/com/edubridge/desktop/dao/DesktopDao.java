package com.edubridge.desktop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.desktop.model.Desktop;
import com.edubridge.desktop.utils.HibernateUtils;
import com.edubridge.desktop.dao.DesktopDaoI;

public class DesktopDao implements DesktopDaoI {

	
	public void addDesktop(Desktop desktop) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(desktop); // Using persist for adding the desktop entity
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("New desktop added!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}


	public List<Desktop> getAllDesktops() {
		
		List<Desktop> desktops = new ArrayList<Desktop>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "from Desktop"; // HQL query to fetch all desktops
			Query query = session.createQuery(hql, Desktop.class);
			desktops = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desktops;
	}

	public Desktop getDesktopById(Integer id) {
		Desktop desktop = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			desktop = session.get(Desktop.class, id); // Retrieve a desktop by ID
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return desktop;
	}

	public void updateDesktop(Desktop desktop) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(desktop); // Merge desktop for update
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("Desktop updated!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteDesktop(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Desktop desktop = session.get(Desktop.class, id); // Fetch the desktop by ID

			if (desktop != null) {
				session.remove(desktop); // Remove the desktop if found
				tx.commit();
				System.out.println("Desktop deleted!");
			} else {
				System.out.println("No desktop found!");
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteAllDesktops() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from Desktop"; // HQL to delete all desktops
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All desktops are deleted!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
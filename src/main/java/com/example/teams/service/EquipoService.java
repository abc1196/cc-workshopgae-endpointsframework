package com.example.teams.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.example.teams.entity.Equipo;

public class EquipoService {

	private EntityManager em;

	public EquipoService() {
		em = PersistenceManager.getEntityManager();
	}

	public boolean addEquipo(Equipo e) {
		// Check for already exists
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.flush();
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean updateEquipo(Equipo e) {
		try {
			em.getTransaction().begin();
			em.merge(e); // cascades the tool & skill relationships
			em.flush();
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean removeEquipo(String id) {
		try {
			Equipo equipo = em.find(Equipo.class, id);
			em.getTransaction().begin();
			em.remove(equipo);
			em.flush();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.close();
			return false;
		}
	}

	public List<Equipo> getEquipos() {
		List<Equipo> equipos = null;
		em.getTransaction().begin();
		TypedQuery<Equipo> q = em.createNamedQuery("Equipo.getAll", Equipo.class);
		try {
			equipos = q.getResultList();
		} catch (NoResultException e) {
			equipos = new ArrayList<Equipo>();
		}

		em.flush();
		em.getTransaction().commit();
		return equipos;
	}

	public Equipo getEquipoById(String id) {

		em.getTransaction().begin();
		Equipo equipo = em.find(Equipo.class, id);
		em.flush();
		em.getTransaction().commit();
		return equipo;
	}

}

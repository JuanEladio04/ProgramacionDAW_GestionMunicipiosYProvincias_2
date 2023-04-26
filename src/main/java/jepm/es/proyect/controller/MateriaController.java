package jepm.es.proyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.es.proyect.model.Materia;


public class MateriaController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvincias_Pt2");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Materia> query = em.createNamedQuery("Materia.findAll", Materia.class);
	    return query.getResultList();
	}
	
	
}

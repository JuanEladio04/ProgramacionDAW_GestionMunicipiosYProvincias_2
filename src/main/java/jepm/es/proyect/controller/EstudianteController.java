package jepm.es.proyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.es.proyect.model.Estudiante;


public class EstudianteController {
	
	
	private static EstudianteController controller = null;

	
	/**
	 * 
	 * @return
	 */
	public static EstudianteController getController() {
		if (controller == null) {
			controller = new EstudianteController();
		}
		return controller;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvincias_Pt2");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.findAll", Estudiante.class);
	    return query.getResultList();
	}



}

package jepm.es.proyect.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@Table(name="materia")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String acronimo;

	@Column(name="curso_id")
	private int cursoId;

	private String nombre;

	//bi-directional many-to-one association to Valoracionmateria
	@OneToMany(mappedBy="materia")
	private List<Valoracionmateria> valoracionmaterias;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public int getCursoId() {
		return this.cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Valoracionmateria> getValoracionmaterias() {
		return this.valoracionmaterias;
	}

	public void setValoracionmaterias(List<Valoracionmateria> valoracionmaterias) {
		this.valoracionmaterias = valoracionmaterias;
	}

	public Valoracionmateria addValoracionmateria(Valoracionmateria valoracionmateria) {
		getValoracionmaterias().add(valoracionmateria);
		valoracionmateria.setMateria(this);

		return valoracionmateria;
	}

	public Valoracionmateria removeValoracionmateria(Valoracionmateria valoracionmateria) {
		getValoracionmaterias().remove(valoracionmateria);
		valoracionmateria.setMateria(null);

		return valoracionmateria;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}
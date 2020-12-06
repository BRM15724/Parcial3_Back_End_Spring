package com.web.app.controllers.repositorys;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.controllers.entitys.Maestro;

@Repository
public class MaestroDAO implements IMaestroDAO{
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Maestro t) {
		em.persist(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Maestro find(Integer id) {
		return em.find(Maestro.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Maestro> findAll() {
		List<Maestro> result = em
				.createQuery("from Maestro")
				.getResultList(); // No es SQL , es HQL o JPQL
		return result;
	}

	@Override
	@Transactional
	public void update(Maestro t) {
		//em.merge(t); Opción No. 1
		Maestro cambio = find(t.getId());
		cambio.setNombre(t.getNombre());
		cambio.setEdad(t.getEdad());
		cambio.setSalario(t.getSalario());
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Maestro delete = find(id);
		em.remove(delete);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Maestro> find_nombre(String nombre){
		List<Maestro> result = em.createQuery("SELECT m FROM Maestro m WHERE m.nombre=:nombreM").setParameter("nombreM", nombre).getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Maestro> find_salarios(float salarioMin , float salarioMax){
		if (salarioMin != 0 && salarioMax!=0) {
			List<Maestro> result = em.createQuery("SELECT m FROM Maestro m WHERE m.salario>=:salariomin AND m.salario<=:salariomax").setParameter("salariomin", salarioMin).setParameter("salariomax", salarioMax).getResultList();
			return result;
		}
			else{
				List<Maestro> result = em.createQuery("SELECT m FROM Maestro m WHERE m.salario>=:salariomin").setParameter("salariomin", salarioMin).getResultList();
				return result;
			}
	}
}

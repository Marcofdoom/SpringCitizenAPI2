package com.example.springbatchexample1.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbatchexample1.model.Citizen;

@Repository
public class CitizenRepositoryCustomImpl implements CitizenRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public CitizenRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Citizen> findCitizens(Long citizenId, String forenames, String surname, String homeAddress,
			Date dateOfBirth, String placeOfBirth, String sex) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Citizen> cq = cb.createQuery(Citizen.class);

		Root<Citizen> citizen = cq.from(Citizen.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (forenames != null && !forenames.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("forenames")), forenames.toLowerCase()));
		}

		if (surname != null && !surname.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("surname")), surname.toLowerCase()));
		}

		if (homeAddress != null && !homeAddress.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("homeAddress")), homeAddress.toLowerCase()));
		}

		if (dateOfBirth != null && !dateOfBirth.toString().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("dateOfBirth")), dateOfBirth));
		}

		if (placeOfBirth != null && !placeOfBirth.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("placeOfBirth")), placeOfBirth.toLowerCase()));
		}

		if (sex != null && !sex.trim().contentEquals("")) {
			predicates.add(cb.equal(cb.lower(citizen.get("sex")), sex.toLowerCase()));
		}

		if (predicates.isEmpty()) {
			return new ArrayList<Citizen>();
		}

		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Citizen> query = entityManager.createQuery(cq);
		System.out.println(query.toString());
		return query.getResultList();
	}

}
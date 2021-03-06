package com.bibliotheque.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bibliotheque.entities.Loan;

/**
 * DAO emprunt 
 * 
 * @author PICHAT morgan
 *
 */
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	/**
	 * requete de recherche des reservations en cours pour un utilisateur
	 * 
	 * @param user_id --> id de l'utilisateur
	 * @param now --> date actuel
	 * 
	 * @return list d'emprunt
	 */
	@Query("select l from Loan l where l.user.id = :x and l.end_loan > :y and made = false")
	public List<Loan> getListLoanByUserID(@Param("x")Long user_id, @Param("y")Date now);
	
	/**
	 * requete de recherche des reservations en retard pour un utilisateur
	 * 
	 * @param user_id --> id de l'utilisateur
	 * @param now --> date actuel
	 * 
	 * @return list d'emprunt
	 */
	@Query("select l from Loan l where l.user.id = :x and l.end_loan < :y and made = false")
	public List<Loan> getListLoanLateByUserID(@Param("x")Long user_id, @Param("y")Date now);
	
	/**
	 * requete de recherche des reservations en retard 
	 * 
	 * @param now --> date actuel
	 * 
	 * @return list d'emprunt
	 */
	@Query("select l from Loan l where l.end_loan < :y and made = false")
	public List<Loan> getListLoanLate(@Param("y")Date now);
}

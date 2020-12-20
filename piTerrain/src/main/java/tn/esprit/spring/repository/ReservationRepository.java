package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Reservation;;

public interface ReservationRepository  extends JpaRepository<Reservation, Long> 
{	 @Query("SELECT u FROM Reservation u WHERE u.user.id= :id")
List<Reservation> afficherReservation(@Param("id") Long id);

}

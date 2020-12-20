package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {

    @Query("SELECT u FROM Terrain u WHERE u.user.id= :id")
    List<Terrain> afficherTerrainUser(@Param("id") Long id);
}

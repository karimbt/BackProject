package tn.esprit.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.Terrain;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.repository.TerrainRepository;;


@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/terrain")
public class TerrainController {

	@Autowired
    private TerrainRepository lc;
    private ReservationRepository lr;

	  @GetMapping("/terrains")
	    public List<Terrain> getTerrain() {
	        return lc.findAll();
	    }
	
	   @GetMapping("/terrains/{id}")
	    public ResponseEntity<Terrain> getTerrain(@PathVariable(value = "id") Long Id)
	        throws ResourceNotFoundException {
	        Terrain terrain = lc.findById(Id)
	          .orElseThrow(() -> new ResourceNotFoundException("terrain not found for this id :: " + Id));
	        return ResponseEntity.ok().body(terrain);
	    }
	   @PostMapping("/terrains")
	    public Terrain ajoutTerrain(@Valid @RequestBody Terrain terrain) {
		   return lc.save(terrain);
	    }

	   
	   @DeleteMapping("/terrains/{id}")
	    public Map<String, Boolean> suppTerrain(@PathVariable(value = "id") Long Id)
	         throws ResourceNotFoundException {
	        Terrain terrain = lc.findById(Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Terrain not found for this id :: " + Id));

	        lc.delete(terrain);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	   
	   @PutMapping("/terrains/{id}")
	    public ResponseEntity<Terrain> modifierTerrain(@PathVariable(value = "id") Long Id,
	         @Valid @RequestBody Terrain  terrainD) throws ResourceNotFoundException {
	        Terrain terrain = lc.findById(Id)
	        .orElseThrow(() -> new ResourceNotFoundException("terrain not found for this id :: " + Id));
   terrain.setId(terrainD.getId());
   terrain.setUser(terrainD.getUser());
   terrain.setEtat(terrainD.getEtat());
   terrain.setType(terrainD.getType());
   terrain.setPrix(terrainD.getPrix());
terrain.setEndroit(terrainD.getEndroit());

   final Terrain modifierTerrain = lc.save(terrainD);
	        return ResponseEntity.ok(modifierTerrain);
	    }
	   @GetMapping("/terrains/user/{id}")
	    public List<Terrain> getLocalId(@PathVariable(value = "id") Long Id){
	        return  lc.afficherTerrainUser(Id);
	    }
	    /*********reservation****************************/
	   
	    @GetMapping("/terrains/reservations/{id}")
	    public List<Reservation> getReservation(@PathVariable(value = "id") Long Id){
	        return  lr.afficherReservation(Id);
	    }
	    @PostMapping("/terrains/reservations")
	    public Reservation ajoutReservation(@Valid @RequestBody Reservation reservation) {
	        return lr.save(reservation);
	    }
	    

	    @PutMapping("/terrains/reservations/{id}")
	    public ResponseEntity<Reservation> changerEtat(@PathVariable(value = "id") Long Id,
	         @Valid @RequestBody Reservation  reservation) throws ResourceNotFoundException {
	        Reservation reserv = lr.findById(Id)
	        .orElseThrow(() -> new ResourceNotFoundException("reservation not found for this id :: " + Id));
    reserv.setId(reservation.getId());
reserv.setEtat(reservation.getEtat());


	        return ResponseEntity.ok(lr.save(reserv));
	    }
	    /******************/
	    @PutMapping("/terrains/like/{id}")
	    public ResponseEntity<Terrain> incrementLike(@PathVariable(value = "id") Long Id,
	         @Valid @RequestBody Terrain  terrainD) throws ResourceNotFoundException {
	        Terrain terrain = lc.findById(Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Terrain not found for this id :: " + Id));
    terrain.setId(terrainD.getId());
terrain.setLikes(terrainD.getLikes());


	        return ResponseEntity.ok(lc.save(terrain));
	    }
	    
	    
	    
}

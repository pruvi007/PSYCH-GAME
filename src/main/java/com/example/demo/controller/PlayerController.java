package com.example.demo.controller;

import java.util.*;
import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Executable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        System.out.println("I am Inside GetAllPlayers");
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player players(@Valid @RequestBody Player player){
        System.out.println("I am Inside CreatePlayer");
        System.out.println("Name: "+ player.getId() );
        System.out.println("Name: "+ player.getName() );
        return playerRepository.save(player);
    }
    @PostMapping("/multiPlayers")
    public String multiPlayers( @Valid @RequestBody List<Player> player ) throws Exception{
        int size = player.size();
        for(int i=0;i<size;i++)
        {
            playerRepository.save(player.get(i));
        }
        return "All Players Saved";
    }

    // "/api/players/101/"
    @GetMapping("/playerId/{id}")
    public Player playerId( @PathVariable(value="id") Long id ) throws Exception {
        System.out.println("I am Inside GetPlayerById");
        return playerRepository.findById(id).orElseThrow(() -> new Exception("Something Went Wrong"));
    }
    @GetMapping("/playerName/{name}")
    public ArrayList<Player> playerName( @PathVariable(value="name") String name ) throws Exception{
        List<Player> p = playerRepository.findAll();
        ArrayList<Player> desiredPlayers = new ArrayList<Player>();
        int size = p.size();
        for(int i=0;i<size;i++)
        {
            String foundName = p.get(i).getName();
            if( foundName.equals(name) )
                desiredPlayers.add(p.get(i));
        }
        return desiredPlayers;

    }

    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayer( @PathVariable(value="id") Long id, @Valid @RequestBody Player player) throws Exception {
        Player p = playerRepository.findById(id).orElseThrow(() -> new Exception("Something Went Wrong"));
        p.setName(player.getName());
        System.out.println("I am Inside updatePlayer");
        return playerRepository.save(p);
    }

    @DeleteMapping("/deletePlayerId/{id}")
    public ResponseEntity<?> deletePlayerId( @PathVariable(value="id") Long id ) throws Exception{
        Player p = playerRepository.findById(id).orElseThrow(()-> new Exception("Something Went Wrong") );
        playerRepository.delete(p);
        System.out.println("I am Inside DeletePlayers");
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deletePlayerName/{name}")
    public ResponseEntity<?> deletePlayerName( @PathVariable(value="name") String name) throws Exception{
        List<Player> p = playerRepository.findAll();
        int size = p.size();
        for(int i=0;i<size;i++)
        {
            String foundName = p.get(i).getName();
            if( foundName.equals(name))
                playerRepository.delete(p.get(i));
        }
        return ResponseEntity.ok().build();

    }

}

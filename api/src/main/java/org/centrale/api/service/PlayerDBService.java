package org.centrale.api.service;

import javax.sql.DataSource;
import org.centrale.api.repository.PlayerRepository;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.domain.PierreFeuilleCiseaux.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PlayerDBService {

    final DataSource dataSource;
    final PlayerRepository playerRepository;

    public PlayerDBService(DataSource dataSource, PlayerRepository playerRepository) {
        this.dataSource = dataSource;
        this.playerRepository = playerRepository;
    }

    // Use of JDBC to retrieve DB info
    public Player getPlayerById(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("SELECT * from player where id = ?",
                (rs, rowNum) -> new Player(rs.getInt("id"), rs.getString("name")), id);
    }


    // Use of JPA (hibernate).
    public PlayerEntity getPlayerEntity(Long id){
        return playerRepository.findById(id).orElseThrow();
    }

    public String addNewPlayer(String name){
        PlayerEntity newPlayer = new PlayerEntity();
        newPlayer.setName(name);
        playerRepository.save(newPlayer);
        return "Ajout du joueur "+name+" avec succès !";
    }
}

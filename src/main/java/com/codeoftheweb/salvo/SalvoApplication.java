package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository) {
		return (args) -> {
			// save a couple of players
			Player p1 = new Player("j.bauer@ctu.gov");
			Player p2 = new Player("c.obrian@ctu.gov");
			Player p3 = new Player("kim_bauer@gmail.com");
			Player p4 = new Player("t.almeida@ctu.gov");
			Player p5 = new Player("d.palmer@whitehouse.gov");
			playerRepository.save(p1);
			playerRepository.save(p2);
			playerRepository.save(p3);
			playerRepository.save(p4);

			// save a couple of games
			Date creationDate = new Date();
			Date newDate = Date.from(creationDate.toInstant().plusSeconds(3600));
			Date newDate2 = Date.from(newDate.toInstant().plusSeconds(3600));
			Game g1 = new Game(creationDate);
			Game g2 = new Game(newDate);
			Game g3 = new Game(newDate2);
			gameRepository.save(g1);
			gameRepository.save(g2);
			gameRepository.save(g3);

			// save a couple of games and players
			GamePlayer gp1 = new GamePlayer(p1, g1);
			GamePlayer gp2 = new GamePlayer(p2, g1);
			GamePlayer gp3 = new GamePlayer(p3, g2);
			GamePlayer gp4 = new GamePlayer(p4, g2);
			GamePlayer gp5 = new GamePlayer(p2, g3);
			GamePlayer gp6 = new GamePlayer(p4, g3);
			gamePlayerRepository.save(gp1);
			gamePlayerRepository.save(gp2);
			gamePlayerRepository.save(gp3);
			gamePlayerRepository.save(gp4);
			gamePlayerRepository.save(gp5);
			gamePlayerRepository.save(gp6);

			// save a couple of ships
			List<String> locations1 = new ArrayList<>();
			{ 	locations1.add("H2");
				locations1.add("H3");
				locations1.add("H4"); }
			List<String> locations2 = new ArrayList<>();
			{ 	locations2.add("E1");
				locations2.add("F1");
				locations2.add("G1"); }
			List<String> locations3 = new ArrayList<>();
			{ 	locations3.add("B4");
				locations3.add("B5"); }
			List<String> locations4 = new ArrayList<>();
			{ 	locations4.add("B5");
				locations4.add("C5");
				locations4.add("D5"); }
			List<String> locations5 = new ArrayList<>();
			{ 	locations5.add("F1");
				locations5.add("F2"); }
			String shipType1 = "Carrier";//length = 5
			String shipType2 = "Battleship"; //length = 4
			String shipType3 = "Submarine"; //length = 3
			String shipType4 = "Destroyer"; //length = 3
			String shipType5 = "Patrol Boat"; //length = 2
			Ship ship1 = new Ship(shipType4, locations1, gp1);
			Ship ship2 = new Ship(shipType3, locations2, gp1);
			Ship ship3 = new Ship(shipType5, locations3, gp1);
			Ship ship4 = new Ship(shipType4, locations4, gp2);
			Ship ship5 = new Ship(shipType5, locations5, gp2);
			shipRepository.save(ship1);
			shipRepository.save(ship2);
			shipRepository.save(ship3);
			shipRepository.save(ship4);
			shipRepository.save(ship5);
		};
	}
	}
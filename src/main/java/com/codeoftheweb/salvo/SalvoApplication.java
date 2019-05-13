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
	public CommandLineRunner initData(PlayerRepository playerRepository,
									  GameRepository gameRepository,
									  GamePlayerRepository gamePlayerRepository,
									  ShipRepository shipRepository,
									  SalvoRepository salvoRepository) {
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
			// save a couple of salvoes
			List<String> salvoLocations1 = new ArrayList<>();
			{ 	salvoLocations1.add("B4");
				salvoLocations1.add("B5");
				salvoLocations1.add("F1"); }
			List<String> salvoLocations2 = new ArrayList<>();
			{ 	salvoLocations2.add("B4");
				salvoLocations2.add("B5");
				salvoLocations2.add("B6"); }
			List<String> salvoLocations3 = new ArrayList<>();
			{ 	salvoLocations3.add("F2");
				salvoLocations3.add("D5"); }
			List<String> salvoLocations4 = new ArrayList<>();
			{ 	salvoLocations4.add("E1");
				salvoLocations4.add("H3");
				salvoLocations4.add("A2"); }
			List<String> salvoLocations5 = new ArrayList<>();
			{ 	salvoLocations5.add("A2");
				salvoLocations5.add("A4");
				salvoLocations5.add("G6"); }
			List<String> salvoLocations6 = new ArrayList<>();
			{ 	salvoLocations6.add("B5");
				salvoLocations6.add("D5");
				salvoLocations6.add("C7"); }
			List<String> salvoLocations7 = new ArrayList<>();
			{ 	salvoLocations7.add("A3");
				salvoLocations7.add("H6"); }
			List<String> salvoLocations8 = new ArrayList<>();
			{ 	salvoLocations8.add("C5");
				salvoLocations8.add("C6"); }
			Salvo salvo1 = new Salvo(gp1, 1, salvoLocations1);
			Salvo salvo2 = new Salvo(gp2, 1, salvoLocations2);
			Salvo salvo3 = new Salvo(gp1, 2, salvoLocations3);
			Salvo salvo4 = new Salvo(gp2, 2, salvoLocations4);
			Salvo salvo5 = new Salvo(gp3, 1, salvoLocations5);
			Salvo salvo6 = new Salvo(gp4, 1, salvoLocations6);
			Salvo salvo7 = new Salvo(gp3, 2, salvoLocations7);
			Salvo salvo8 = new Salvo(gp4, 2, salvoLocations8);
			salvoRepository.save(salvo1);
			salvoRepository.save(salvo2);
			salvoRepository.save(salvo3);
			salvoRepository.save(salvo4);
			salvoRepository.save(salvo5);
			salvoRepository.save(salvo6);
			salvoRepository.save(salvo7);
			salvoRepository.save(salvo8);
		};
	}
	}
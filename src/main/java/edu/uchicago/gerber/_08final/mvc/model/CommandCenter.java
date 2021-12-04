package edu.uchicago.gerber._08final.mvc.model;



import edu.uchicago.gerber._08final.mvc.controller.Sound;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//the lombok @Data gives us automatic getters and setters on all members
@Data
public class CommandCenter {

	private  int numFalcons;
	private  int level;
	private  long score;
	//the falcon is located in the movFriends list, but since we use this reference a lot, we keep track of it in a
	//separate reference. See spawnFalcon() method below.
	private  Falcon falcon;
	private  boolean paused;

	private BufferedImage ship;
	private BufferedImage explosion1;
	private BufferedImage explosion2;
	private BufferedImage explosion3;
	private BufferedImage explosion4;
	private ArrayList<BufferedImage> asteroids0;
	private ArrayList<BufferedImage> asteroids1;
	private ArrayList<BufferedImage> asteroids2;

	private List<Movable> movDebris = new LinkedList<>();
	private List<Movable> movFriends = new LinkedList<>();
	private List<Movable> movFoes = new LinkedList<>();
	private List<Movable> movFloaters = new LinkedList<>();

	private GameOpsList opsList = new GameOpsList();


	private static CommandCenter instance = null;

	// Constructor made private
	private CommandCenter() {}

    //this class maintains game state - make this a singleton.
	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}


	public  void initGame(){
		setLevel(1);
		setScore(0);
		setNumFalcons(4);
		spawnFalcon();

		loadGraphics();
	}

	private void loadGraphics() {
		ship = loadGraphic("ship.png");

		asteroids0 = new ArrayList<>();
		asteroids0.add(loadGraphic("asteroid1_0.png"));
		asteroids0.add(loadGraphic("asteroid2_0.png"));
		asteroids0.add(loadGraphic("asteroid3_0.png"));
		asteroids0.add(loadGraphic("asteroid4_0.png"));
		asteroids0.add(loadGraphic("asteroid5_0.png"));

		asteroids1 = new ArrayList<>();
		asteroids1.add(loadGraphic("asteroid1_1.png"));
		asteroids1.add(loadGraphic("asteroid2_1.png"));
		asteroids1.add(loadGraphic("asteroid3_1.png"));
		asteroids1.add(loadGraphic("asteroid4_1.png"));
		asteroids1.add(loadGraphic("asteroid5_1.png"));

		asteroids2 = new ArrayList<>();
		asteroids2.add(loadGraphic("asteroid1_2.png"));
		asteroids2.add(loadGraphic("asteroid2_2.png"));
		asteroids2.add(loadGraphic("asteroid3_2.png"));
		asteroids2.add(loadGraphic("asteroid4_2.png"));
		asteroids2.add(loadGraphic("asteroid5_2.png"));

		explosion1 = loadGraphic("explosion1.png");
		explosion2 = loadGraphic("explosion2.png");
		explosion3 = loadGraphic("explosion3.png");
		explosion4 = loadGraphic("explosion4.png");
	}

	private BufferedImage loadGraphic(String imgName) {
		BufferedImage img;
		try {
			img = ImageIO.read(CommandCenter.class.getResourceAsStream("/img/" + imgName));
		}
		catch (IOException e) {
			e.printStackTrace();
			img = null;
		}

		return img;
	}

	public BufferedImage getFalconImg(){
		return ship;
	}

	public BufferedImage getAsteroid(int asteroidNum, int size) {
		if (size == 0) {
			return asteroids0.get(asteroidNum);
		} else if (size == 1) {
			return asteroids1.get(asteroidNum);
		} else {
			return asteroids2.get(asteroidNum);
		}
	}

	public BufferedImage getExplosion(int explosionNum) {
		switch(explosionNum){
			case 1:
				return explosion1;
			case 2:
				return explosion2;
			case 3:
				return explosion3;
			case 4:
				return explosion4;
			default:
				return null;
		}
	}

	public  boolean isGameOver() {		//if the number of falcons is zero, then game over
		return getNumFalcons() == 0;
	}

	public  void spawnFalcon() {

		//decrement the number of falcons first
		setNumFalcons(getNumFalcons() - 1);
		if (isGameOver()) return;

		falcon = new Falcon();
		opsList.enqueue(falcon, CollisionOp.Operation.ADD);
		Sound.playSound("shipspawn.wav");

	}

	public  void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}





}

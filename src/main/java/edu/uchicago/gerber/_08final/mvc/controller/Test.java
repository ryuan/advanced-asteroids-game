package edu.uchicago.gerber._08final.mvc.controller;

import edu.uchicago.gerber._08final.mvc.model.CommandCenter;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.printf(String.valueOf(ImageIO.read(CommandCenter.class.getResourceAsStream("/img/ship.png"))));
    }
}

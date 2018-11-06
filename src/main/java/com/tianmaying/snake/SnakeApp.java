package com.tianmaying.snake;

import javax.swing.*;
import java.awt.*;

public class SnakeApp implements Runnable {
    
    Grid grid;
    GameView gameView;
    GameController gameController;

    public void run() {

        grid = new Grid(Settings.DEFAULT_GRID_WIDTH / Settings.DEFAULT_NODE_SIZE,
                Settings.DEFAULT_GRID_HEIGHT / Settings.DEFAULT_NODE_SIZE);

        gameView = new GameView(grid);
        gameView.init();
        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));
        
        JFrame window = new JFrame("天码营贪吃蛇游戏");
        window.setPreferredSize(new Dimension(1000, 500));
		JLabel label=new JLabel(Integer.toString(grid.getScore()));
		label.setBounds(800, 200, 800, 200);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 200));
        Container contentPane = window.getContentPane();
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        gameController = new GameController(grid, gameView);
        window.addKeyListener(gameController);

        new Thread(gameController).start();
    }
    
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new SnakeApp());
    }
}
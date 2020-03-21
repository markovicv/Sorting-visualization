package ui;
import utils.Konstants;

import javax.swing.*;
import java.awt.*;

public class VisuUI extends JFrame {
    private Visualizator visualizator;
    private CommandView commandView;



    public VisuUI(){
        super("Visualizator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Konstants.WIDTH,Konstants.HEIGHT);




        visualizator = new Visualizator();
        commandView = new CommandView(visualizator);
        visualizator.setPreferredSize(new Dimension(Konstants.WIDTH,800));
        commandView.setPreferredSize(new Dimension(Konstants.WIDTH,67));

      //  visualizator.repaint();
        this.add(visualizator,BorderLayout.CENTER);
        this.add(commandView,BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
      //  visualizator.setAlgo(new QuickSort());
      //  visualizator.startSorting();


    }

    public static void main(String[] args){
        VisuUI visuUI = new VisuUI();
    }
}

package ui;

import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.RafSort;
import utils.Konstants;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandView extends JPanel  {
    private JButton shufflerBtn = new JButton("SHUFFLE");
    private JButton startBtn = new JButton("START");
    private JButton stopBtn = new JButton("STOP");
    private JButton resumeSortingBtn = new JButton("RESUME");
    private JSlider slider = new JSlider(0,100,25);
    private JButton colorBtn = new JButton();
    private String[] algos = {"QuickSort","BubbleSort"};
    private String[] icons = {"Bar","Star","Dot"};
    private JComboBox comboBox;
    private JComboBox typeComboBox;
    private Visualizator visualizator;

    public CommandView(Visualizator visualizator){
        this.visualizator = visualizator;
        this.setLayout(new FlowLayout());
        this.comboBox = new JComboBox(algos);
        this.typeComboBox = new JComboBox(icons);
        this.comboBox.setSelectedIndex(0);

        this.setBackground(new Color(204,162,51));
        initWidgets();
        listeners();

    }

    private void initWidgets(){
        stopBtn.setPreferredSize(new Dimension(120,25));
        startBtn.setPreferredSize(new Dimension(120,25));
        stopBtn.setToolTipText("Stop sorting");
        shufflerBtn.setPreferredSize(new Dimension(120,25));
        colorBtn.setPreferredSize(new Dimension(40,25));
        colorBtn.setToolTipText("Choose a color");
        resumeSortingBtn.setPreferredSize(new Dimension(120,25));
        resumeSortingBtn.setToolTipText("Resume sorting");
        this.add(comboBox);
        this.add(startBtn);
        this.add(stopBtn);
        this.add(resumeSortingBtn);
        this.add(shufflerBtn);
        this.add(colorBtn);
        this.add(slider);
        this.add(typeComboBox);



        colorBtn.setIcon(new ImageIcon("resources/color.png"));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(0);
    }
    private void listeners(){
        startBtn.addActionListener(actionEvent -> {
            if(comboBox.getSelectedIndex()==0){
                visualizator.setAlgo(new QuickSort());
                visualizator.setAlgoSleepTime(slider.getValue());
                visualizator.startSorting();

            }
            else if(comboBox.getSelectedIndex() == 1){
                visualizator.setAlgo(new BubbleSort());
                visualizator.setAlgoSleepTime(slider.getValue());
                visualizator.startSorting();

            }
        });

        typeComboBox.addActionListener(actionEvent -> {
            if(typeComboBox.getSelectedIndex()==0)
                visualizator.setType(Konstants.BAR);
            else if(typeComboBox.getSelectedIndex()==1)
                visualizator.setType(Konstants.STAR);
            else if(typeComboBox.getSelectedIndex() == 2)
                visualizator.setType(Konstants.DOT);
        });

        shufflerBtn.addActionListener(actionEvent -> {
            visualizator.shuffle(visualizator.array);
            visualizator.repaint();
        });

        colorBtn.addActionListener(actionEvent -> {
            Color color = JColorChooser.showDialog(CommandView.this,"Choose a color",Color.RED);
            visualizator.setColor(color);
            visualizator.repaint();
        });
        stopBtn.addActionListener(actionEvent -> visualizator.stopSorting());
        resumeSortingBtn.addActionListener(actionEvent -> visualizator.resumeSorting());
        slider.addChangeListener(changeEvent -> visualizator.setAlgoSleepTime(slider.getValue()));
    }


}

package ui;

import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.RafSort;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandView extends JPanel  {
    private JButton shufflerBtn = new JButton("SHUFFLE");
    private JButton startBtn = new JButton("START");
    private JButton stopBtn = new JButton();
    private JButton resumeSortingBtn = new JButton();
    private JSlider slider = new JSlider(0,100,25);
    private JButton colorBtn = new JButton();
    private JColorChooser colorChooser = new JColorChooser();

    private  String[] algos = {"QuickSort","BubbleSort"};
    private JComboBox comboBox;

    private JComboBox<String> sorters = new JComboBox<>();
    private Visualizator visualizator;

    public CommandView(Visualizator visualizator){
        this.visualizator = visualizator;
        this.setLayout(new FlowLayout());
        this.comboBox = new JComboBox(algos);
        this.comboBox.setSelectedIndex(0);
        this.setBackground(new Color(204,162,51));
        initWidgets();
        listeners();

    }

    private void initWidgets(){
        stopBtn.setPreferredSize(new Dimension(40,25));
        startBtn.setPreferredSize(new Dimension(120,25));
        stopBtn.setToolTipText("Stop sorting");
        shufflerBtn.setPreferredSize(new Dimension(120,25));
        colorBtn.setPreferredSize(new Dimension(40,25));
        colorBtn.setToolTipText("Choose a color");
        resumeSortingBtn.setPreferredSize(new Dimension(40,25));
        resumeSortingBtn.setToolTipText("Resume sorting");
        this.add(comboBox);
        this.add(startBtn);
        this.add(shufflerBtn);
        this.add(stopBtn);
        this.add(resumeSortingBtn);
        this.add(colorBtn);
        this.add(slider);

        stopBtn.setIcon(new ImageIcon("resources/pause.png"));
        resumeSortingBtn.setIcon(new ImageIcon("resources/resume.png"));
        colorBtn.setIcon(new ImageIcon("resources/color.png"));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(0);
    }
    private void listeners(){
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
            }
        });

        shufflerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualizator.shuffle(visualizator.array);
                visualizator.repaint();
            }
        });

        colorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color color = JColorChooser.showDialog(CommandView.this,"Choose a color",Color.RED);
                visualizator.setColor(color);
                visualizator.repaint();
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualizator.stopSorting();
            }
        });
        resumeSortingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualizator.resumeSorting();
            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                visualizator.setAlgoSleepTime(slider.getValue());
            }
        });
    }


}

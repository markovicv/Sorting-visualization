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

public class CommandView extends JPanel implements ActionListener {
    private JButton qucikSortBtn = new JButton("QUICKSORT");
    private JButton mergeSortBtn = new JButton("MERGESORT");
    private JButton bubbleSortBtn = new JButton("BUBBLESORT");
    private JButton heapSortBtn = new JButton("HEAPSORT");
    private JButton rafSortBtn = new JButton("RAFsort");
    private JButton shufflerBtn = new JButton("SHUFFLE");
    private JButton stopBtn = new JButton();
    private JButton resumeSortingBtn = new JButton();
    private JSlider slider = new JSlider(0,100,25);
    private JButton colorBtn = new JButton();
    private JColorChooser colorChooser = new JColorChooser();

    private JComboBox<String> sorters = new JComboBox<>();
    private Visualizator visualizator;

    public CommandView(Visualizator visualizator){
        this.visualizator = visualizator;
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(204,162,51));
        initWidgets();
        listeners();

    }
    private void initWidgets(){
        qucikSortBtn.setPreferredSize(new Dimension(120,25));
        mergeSortBtn.setPreferredSize(new Dimension(120,25));
        bubbleSortBtn.setPreferredSize(new Dimension(130,25));
        heapSortBtn.setPreferredSize(new Dimension(120,25));
        stopBtn.setPreferredSize(new Dimension(40,25));
        stopBtn.setToolTipText("Stop sorting");
        shufflerBtn.setPreferredSize(new Dimension(120,25));
        rafSortBtn.setPreferredSize(new Dimension(120,25));
        colorBtn.setPreferredSize(new Dimension(40,25));
        colorBtn.setToolTipText("Choose a color");
        resumeSortingBtn.setPreferredSize(new Dimension(40,25));
        resumeSortingBtn.setToolTipText("Resume sorting");
        this.add(qucikSortBtn);
        this.add(mergeSortBtn);
        this.add(bubbleSortBtn);
        this.add(heapSortBtn);
        this.add(shufflerBtn);
        this.add(slider);
        this.add(stopBtn);
        this.add(resumeSortingBtn);
        this.add(colorBtn);

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
        qucikSortBtn.addActionListener(this);
        bubbleSortBtn.addActionListener(this);
        shufflerBtn.addActionListener(this);
        rafSortBtn.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("QUICKSORT")) {
            visualizator.setAlgo(new QuickSort());
            visualizator.setAlgoSleepTime(slider.getValue());
            visualizator.startSorting();
        }
       else if(actionEvent.getActionCommand().equals("BUBBLESORT")){
            visualizator.setAlgo(new BubbleSort());
            visualizator.setAlgoSleepTime(slider.getValue());
            visualizator.startSorting();
        }
        else if(actionEvent.getActionCommand().equals("SHUFFLE")) {
            visualizator.shuffle(visualizator.array);
            visualizator.repaint();
        }
        else if(actionEvent.getActionCommand().equals("RAFsort")){
            visualizator.setAlgo(new RafSort());
            visualizator.setAlgoSleepTime(slider.getValue());
            visualizator.startSorting();
        }





    }

}

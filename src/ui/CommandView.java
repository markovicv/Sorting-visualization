package ui;

import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.RafSort;
import utils.Shuffler;

import javax.swing.*;
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
    private JComboBox<String> sorters = new JComboBox<>();
    private Visualizator visualizator;

    public CommandView(Visualizator visualizator){
        this.visualizator = visualizator;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.CYAN);
        initWidgets();
        listeners();

    }
    private void initWidgets(){
        qucikSortBtn.setPreferredSize(new Dimension(120,25));
        mergeSortBtn.setPreferredSize(new Dimension(120,25));
        bubbleSortBtn.setPreferredSize(new Dimension(130,25));
        heapSortBtn.setPreferredSize(new Dimension(120,25));
        shufflerBtn.setPreferredSize(new Dimension(120,25));
        rafSortBtn.setPreferredSize(new Dimension(120,25));
        this.add(qucikSortBtn);
        this.add(mergeSortBtn);
        this.add(bubbleSortBtn);
        this.add(heapSortBtn);
        this.add(rafSortBtn);
        this.add(shufflerBtn);

    }
    private void listeners(){
        qucikSortBtn.addActionListener(this);
        bubbleSortBtn.addActionListener(this);
        shufflerBtn.addActionListener(this);
        rafSortBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("QUICKSORT")) {
            visualizator.setAlgo(new QuickSort());
            visualizator.startSorting();
        }
        else if(actionEvent.getActionCommand().equals("BUBBLESORT")){
            visualizator.setAlgo(new BubbleSort());
            visualizator.startSorting();
        }
        else if(actionEvent.getActionCommand().equals("SHUFFLE")) {
            Shuffler.shuffler(visualizator.array);
            visualizator.repaint();
        }
        else if(actionEvent.getActionCommand().equals("RAFsort")){
            visualizator.setAlgo(new RafSort());
            visualizator.startSorting();
        }

    }
}
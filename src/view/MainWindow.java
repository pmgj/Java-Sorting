package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import view.graphics.UIGraphic;

public class MainWindow extends JFrame {

    /* UI Components */
    private MyPanel pCanvas;
    private JComboBox cbGraphics;
    private JComboBox cbAlgorithms;
    private JSpinner sQuantity;
    private JSpinner sDelay;

    private void createWindow() {
        this.setPreferredSize(new Dimension(618, 726));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Ordenação", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(titulo);
        topPanel.setMaximumSize(new Dimension(640, 50));
        this.add(topPanel);

        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cbGraphics = new JComboBox(UIGraphic.getGraphics());
        cbGraphics.setToolTipText("How to show the sorting algorithms");
        cbGraphics.addActionListener(ae -> pCanvas.repaint());
        middlePanel.add(cbGraphics);
        cbAlgorithms = new JComboBox(new String[]{"Bubble Sort", "Insertion Sort"});
        cbAlgorithms.setToolTipText("Sorting Algorithm");
        middlePanel.add(cbAlgorithms);
        sQuantity = new JSpinner(new SpinnerNumberModel(25, 1, 2000, 1));
        sQuantity.setToolTipText("Quantity of numbers to sort");
        middlePanel.add(sQuantity);
        sDelay = new JSpinner(new SpinnerNumberModel(5, 1, 2000, 1));
        sDelay.setToolTipText("Delay in milisseconds");
        middlePanel.add(sDelay);
        JButton bShuffle = new JButton("Shuffle");
        bShuffle.addActionListener(ae -> pCanvas.shuffle((Integer) sQuantity.getValue()));
        middlePanel.add(bShuffle);
        JButton bRun = new JButton("Run!");
        bRun.addActionListener(ae -> pCanvas.run());
        middlePanel.add(bRun);
        middlePanel.setMaximumSize(new Dimension(640, 50));
        this.add(middlePanel);

        pCanvas = new MyPanel(this);
        pCanvas.shuffle((Integer) sQuantity.getValue());
        this.add(pCanvas);

        this.pack();
    }

    public JComboBox getCbGraphics() {
        return cbGraphics;
    }

    public JComboBox getCbAlgorithms() {
        return cbAlgorithms;
    }

    public JSpinner getsQuantity() {
        return sQuantity;
    }

    public JSpinner getsDelay() {
        return sDelay;
    }

    public MainWindow() {
        super("Sorting Algorithms");
    }

    public static void main(String[] args) {
        MainWindow w = new MainWindow();
        w.createWindow();
    }
}

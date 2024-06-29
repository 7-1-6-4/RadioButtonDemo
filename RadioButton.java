import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.*;

public class RadioButton extends JFrame {
    JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    ButtonGroup group;
    JLabel imageLabel;
    Map<String, ImageIcon> petImages;
    public RadioButton(){
        setTitle("RadioButton");
        setLayout(new BorderLayout());

        //Initializing radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        //Grouping the radio buttons
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        //creating panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        //Loading images for pets
        loadImages();

        //set action listeners for the radio buttons
        birdButton.addActionListener(e -> displayMessage("Bird"));
        catButton.addActionListener(e -> displayMessage("Cat"));
        dogButton.addActionListener(e -> displayMessage("Dog"));
        rabbitButton.addActionListener(e -> displayMessage("Rabbit"));
        pigButton.addActionListener(e -> displayMessage("Pig"));

        //creating label for displaying images
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER) ;
        imageLabel.setPreferredSize(new Dimension(300, 300));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Adding components to frame
        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }
    void loadImages(){
        petImages = new HashMap<>();
        petImages.put("Bird",  new ImageIcon("bird.jpg"));
        petImages.put("Cat",  new ImageIcon("cat.jpg"));
        petImages.put("Dog",  new ImageIcon("dog.jpg"));
        petImages.put("Rabbit",  new ImageIcon("rabbit.jpg"));
        petImages.put("Pig",  new ImageIcon("pig.jpg"));
    }
    void displayMessage(String pet){
        ImageIcon imageIcon = petImages.get(pet);
        if (imageIcon != null){
            imageLabel.setIcon(imageIcon);
            JOptionPane.showMessageDialog(this, "You selected: " + pet);

        }else {
            JOptionPane.showMessageDialog(this, "Image not found: " + pet);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButton());
    }
}

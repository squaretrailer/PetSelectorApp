import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PetSelector extends JFrame implements ActionListener {
    private final JRadioButton pig, dog, cat, bird, rabbit;
    private final ButtonGroup group;
    private final JLabel imageLabel, messageLabel;

    public PetSelector() {
        setTitle("Pet Selector");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 450);
        setLayout(new BorderLayout());

        // --- Left side: radio buttons ---
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        pig = new JRadioButton("Pig");
        dog = new JRadioButton("Dog");
        cat = new JRadioButton("Cat");
        bird = new JRadioButton("Bird");
        rabbit = new JRadioButton("Rabbit");

        group = new ButtonGroup();
        group.add(pig);
        group.add(dog);
        group.add(cat);
        group.add(bird);
        group.add(rabbit);

        panel.add(pig);
        panel.add(dog);
        panel.add(cat);
        panel.add(bird);
        panel.add(rabbit);

        add(panel, BorderLayout.WEST);

        // --- Center: image + message ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        imageLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        messageLabel.setForeground(Color.DARK_GRAY);

        centerPanel.add(imageLabel, BorderLayout.CENTER);
        centerPanel.add(messageLabel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // --- Add listeners ---
        pig.addActionListener(this);
        dog.addActionListener(this);
        cat.addActionListener(this);
        bird.addActionListener(this);
        rabbit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = "";
        String imagePath = "";

        if (e.getSource() == pig) {
            petName = "Pig 🐷";
            imagePath = "images/pig.jpg";
        } else if (e.getSource() == dog) {
            petName = "Dog 🐶";
            imagePath = "images/dog.jpg";
        } else if (e.getSource() == cat) {
            petName = "Cat 🐱";
            imagePath = "images/cat.jpg";
        } else if (e.getSource() == bird) {
            petName = "Bird 🐦";
            imagePath = "images/bird.jpg";
        } else if (e.getSource() == rabbit) {
            petName = "Rabbit 🐰";
            imagePath = "images/rabbit.jpg";
        }

        // Load image
        java.net.URL imgURL = getClass().getResource("/" + imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found!");
        }

        // Show message
        messageLabel.setText("You selected " + petName);
    }
}

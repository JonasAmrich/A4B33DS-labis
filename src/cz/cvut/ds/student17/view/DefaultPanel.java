package cz.cvut.ds.student17.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DefaultPanel extends JPanel {

    private BufferedImage image;

    public DefaultPanel() {
        String pathToImage = "./aperture_science_by_u235master-d31kzdt.jpg";
        //ImageIcon Icon = new ImageIcon(getClass().getClassLoader().getResource(pathToImageSortBy));
        System.out.println("Default panel");
        try {
            //ImageIcon Icon = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
            //image = ImageIO.read(getClass().getClassLoader().getResource(pathToImage));
            image = ImageIO.read(getClass().getClassLoader().getResource(pathToImage));
            //JLabel picLabel = new JLabel(new ImageIcon(image));
            //add(picLabel);
            //repaint();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
}

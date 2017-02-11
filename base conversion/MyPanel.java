/**
 * Ethan Gordon
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyPanel extends JPanel implements ActionListener{
    
    public MyPanel() {
        super();
        setFocusable(true);
        setBackground(new Color(170, 220, 220));
        setDoubleBuffered(true);
        
        Timer timer = new Timer(20, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
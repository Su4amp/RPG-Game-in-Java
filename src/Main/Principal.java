package src.Main;

import javax.swing.JFrame;

public class Principal{
    private Principal(){
        JFrame frame = new JFrame();
        MainPanel panel = new MainPanel();

        frame.add(panel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("RPG v1");
        frame.setResizable(false); 
        
        panel.initThread();
    }
    public static void main(String[] args) {
        new Principal();
    }    
}
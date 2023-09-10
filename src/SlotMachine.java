import controller.ThreadReel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotMachine extends JFrame {

    private JButton iniciar;
    private JPanel telaPrincipal;
    private JLabel numero1;
    private JLabel numero2;
    private JLabel numero3;

    public SlotMachine() {
        setContentPane(telaPrincipal);

        setTitle("Slot Machine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThreadReel cacaNiquel1 = new ThreadReel(numero1, iniciar);
                ThreadReel cacaNiquel2 = new ThreadReel(numero2, iniciar);
                ThreadReel cacaNiquel3 = new ThreadReel(numero3, iniciar);

                cacaNiquel1.start();
                cacaNiquel2.start();
                cacaNiquel3.start();
            }
        });
    }

    public static void main(String[] args) {
        new SlotMachine();
    }
}

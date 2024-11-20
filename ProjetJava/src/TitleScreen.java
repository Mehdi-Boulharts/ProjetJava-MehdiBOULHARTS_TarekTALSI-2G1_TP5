import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class TitleScreen extends JPanel {
    private JFrame window;
    private Image backgroundImage;

    /**
     * Constructeur de la classe TitleScreen.
     *
     * Ce constructeur initialise l'écran de titre du jeu en configurant la fenêtre,
     * charge l'image de fond, et crée les boutons pour démarrer le jeu ou le quitter
     * @param window
     */
    public TitleScreen(JFrame window) {
        this.window = window;
        try {
            backgroundImage = ImageIO.read(new File("./img/Ecran_Titre.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(350, 200, 100, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    startGame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(startButton);

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(350, 400, 100, 50);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeGame();
            }
        });
        add(quitButton);
    }

    /**
     * Dessine le composant, y compris l'image de fond.
     *
     * Cette méthode est appelée pour rendre le contenu graphique du composant.
     * Elle appelle d'abord la méthode de peinture de la classe parente,
     * puis dessine l'image de fond si elle est disponible
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Démarre une nouvelle instance du jeu.
     *
     * Cette méthode ferme la fenêtre actuelle et initialise une nouvelle
     * instance de la classe Main, lançant ainsi le jeu
     * @throws Exception
     */
    private void startGame() throws Exception {
        window.dispose();
        new Main();
    }

    /**
     * Ferme la fenêtre du jeu et libère les ressources associées.
     *
     * Cette méthode est appelée pour quitter le jeu en fermant la fenêtre
     * principale et en s'assurant que toutes les ressources sont libérées
     */
    private void closeGame() {
        window.dispose();
    }
}
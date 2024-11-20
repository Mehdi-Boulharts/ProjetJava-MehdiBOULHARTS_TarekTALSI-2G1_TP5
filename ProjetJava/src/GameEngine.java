import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener {
    DynamicSprite hero;

    /**
     * Constructeur de la classe GameEngine
     *
     * Ce constructeur initialise le moteur de jeu avec le sprite
     * principal représentant le héros
     * @param hero
     */
    public GameEngine(DynamicSprite hero) {
        this.hero = hero;
    }

    /**
     * Met à jour l'état du moteur de jeu
     */
    @Override
    public void update() {

    }

    /**
     * Gère l'événement de frappe de touche
     *
     * Cette méthode est appelée lorsque l'utilisateur tape une touche sur le clavier.
     * Actuellement, elle ne contient pas d'implémentation et ne gère pas les événements de frappe
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Gère l'événement de pression de touche
     *
     * Cette méthode est appelée lorsque l'utilisateur appuie sur une touche du clavier.
     * Elle met à jour l'état du héros en fonction de la touche pressée.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            hero.setSprinting(true);
        }
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                hero.setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection(Direction.EAST);
                break;
        }
    }

    /**
     * Gère l'événement de relâchement de touche
     *
     * Cette méthode est appelée lorsque l'utilisateur relâche une touche du clavier.
     * Elle met à jour l'état du héros en désactivant le mode sprint si la touche SHIFT est relâchée
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            hero.setSprinting(false);
        }
    }
}
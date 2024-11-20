import java.awt.*;

public class Sprite implements Displayable{
    protected double x;
    protected double y;
    protected final Image image;
    protected final double width;
    protected final double height;

    /**
     * Constructeur de la classe Sprite
     *
     * Ce constructeur initialise un nouveau sprite avec ses coordonnées,
     * son image, et ses dimensions
     * @param x
     * @param y
     * @param image
     * @param width
     * @param height
     */
    public Sprite(double x, double y, Image image, double width, double height) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
    }

    /**
     * Dessine l'image du sprite sur le composant graphique
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(image,(int)x,(int)y,null);
    }
}

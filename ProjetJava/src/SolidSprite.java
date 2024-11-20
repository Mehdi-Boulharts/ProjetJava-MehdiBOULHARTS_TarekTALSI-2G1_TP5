import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SolidSprite extends Sprite{

    /**
     * Constructeur de la classe SolidSprite
     *
     * Ce constructeur initialise un nouveau sprite solide en appelant le
     * constructeur de la classe parente Sprite avec les coordonnées,
     * l'image et les dimensions fournies
     * @param x
     * @param y
     * @param image
     * @param width
     * @param height
     */
    public SolidSprite(double x, double y, Image image, double width, double height) {
        super(x, y, image, width, height);
    }

    /**
     * Récupère la boîte de collision du sprite sous forme de Rectangle2D.
     *
     * Cette méthode crée et retourne un objet Rectangle2D représentant
     * la zone de collision du sprite, définie par sa position (x, y)
     * et ses dimensions (width, height).
     * @return
     */
    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(x,y,(double) width,(double) height);
    }

    /**
     * Vérifie si la boîte de collision du sprite intersecte avec une autre boîte de collision
     *
     * Cette méthode utilise la boîte de collision actuelle du sprite et
     * vérifie si elle se chevauche avec la boîte de collision spécifiée
     * @param hitBox
     * @return
     */
    public boolean intersect(Rectangle2D.Double hitBox){
        return this.getHitBox().intersects(hitBox);
    }
}
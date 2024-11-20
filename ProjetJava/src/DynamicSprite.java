import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite{
    private Direction direction = Direction.EAST;
    private double speed = 5;
    private double timeBetweenFrame = 250;
    private boolean isWalking =true;
    private final int spriteSheetNumberOfColumn = 10;
    private boolean isSprinting = false;
    private int actualSpeed;

    /**
     * Constructeur de la classe DynamicSprite
     *
     * Ce constructeur initialise un nouveau sprite dynamique en appelant le
     * constructeur de la classe parente Sprite avec les coordonnées,
     * l'image et les dimensions fournies.
     * @param x
     * @param y
     * @param image
     * @param width
     * @param height
     */
    public DynamicSprite(double x, double y, Image image, double width, double height) {
        super(x, y, image, width, height);
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment){
        Rectangle2D.Double moved = new Rectangle2D.Double();
        if (isSprinting) {
            actualSpeed = 2 * (int) speed + 5;
        } else {
            actualSpeed = (int) speed + 5;
        }
        switch(direction){
            case EAST: moved.setRect(super.getHitBox().getX()+actualSpeed,super.getHitBox().getY(),
                                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case WEST:  moved.setRect(super.getHitBox().getX()-actualSpeed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case NORTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()-actualSpeed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case SOUTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()+actualSpeed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
        }

        for (Sprite s : environment){
            if ((s instanceof SolidSprite) && (s!=this)){
                if (((SolidSprite) s).intersect(moved)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Définit la direction du sprite
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;

    }

    /**
     * Définit l'état de sprint du sprite
     * @param sprinting
     */
    public void setSprinting(boolean sprinting) {
        this.isSprinting = sprinting;
    }

    private void move(){
        switch (direction){
            case NORTH -> {
                this.y-=speed;
            }
            case SOUTH -> {
                this.y+=speed;
            }
            case EAST -> {
                this.x+=speed;
            }
            case WEST -> {
                this.x-=speed;
            }
        }
    }

    private void sprint(){
        switch (direction){
            case NORTH -> {
                this.y-=2*speed;
            }
            case SOUTH -> {
                this.y+=2*speed;
            }
            case EAST -> {
                this.x+=2*speed;
            }
            case WEST -> {
                this.x-=2*speed;
            }
        }
    }

    /**
     * Déplace le sprite si le mouvement est possible
     * @param environment
     */
    public void moveIfPossible(ArrayList<Sprite> environment){

        if (isMovingPossible(environment)){
            if (isSprinting) {
                sprint();
            } else {
                move();
            }
            move();
        }
    }

    /**
     * Dessine le sprite sur le composant graphique
     *
     * Cette méthode utilise l'objet Graphics fourni pour dessiner
     * l'image du sprite à la position spécifiée par les coordonnées x et y
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        int index= (int) (System.currentTimeMillis()/timeBetweenFrame%spriteSheetNumberOfColumn);

        g.drawImage(image,(int) x, (int) y, (int) (x+width),(int) (y+height),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);
    }
}

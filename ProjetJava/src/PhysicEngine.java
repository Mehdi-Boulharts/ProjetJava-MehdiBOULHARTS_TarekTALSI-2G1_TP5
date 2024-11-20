import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhysicEngine implements Engine{
    private ArrayList<DynamicSprite> movingSpriteList;
    private ArrayList <Sprite> environment;

    /**
     * Constructeur de la classe PhysicEngine.
     *
     * Ce constructeur initialise le moteur de physique en créant
     * des listes pour les sprites en mouvement et l'environnement
     */
    public PhysicEngine() {
        movingSpriteList = new ArrayList<>();
        environment = new ArrayList<>();
    }

    /**
     * Ajoute un sprite à la liste de l'environnement s'il n'y est pas déjà présent
     *
     * Cette méthode utilise l'objet Graphics fourni pour dessiner
     * l'image du sprite à la position spécifiée par les coordonnées x et y
     * @param sprite
     */
    public void addToEnvironmentList(Sprite sprite){
        if (!environment.contains(sprite)){
            environment.add(sprite);
        }
    }

    /**
     * Définit l'environnement du moteur de jeu
     *
     * Cette méthode permet de remplacer l'environnement actuel par une nouvelle liste de sprites
     * @param environment
     */
    public void setEnvironment(ArrayList<Sprite> environment){
        this.environment=environment;
    }

    /**
     * Ajoute un sprite dynamique à la liste des sprites en mouvement s'il n'y est pas déjà présent
     *
     * Cette méthode vérifie si le sprite spécifié est déjà dans la liste des sprites en mouvement.
     * Si ce n'est pas le cas, le sprite est ajouté à la liste
     * @param sprite
     */
    public void addToMovingSpriteList(DynamicSprite sprite){
        if (!movingSpriteList.contains(sprite)){
            movingSpriteList.add(sprite);
        }
    }

    /**
     * Met à jour l'état des sprites en mouvement
     *
     * Cette méthode parcourt la liste des sprites dynamiques et appelle
     * la méthode de mouvement pour chaque sprite, en vérifiant
     * s'il peut se déplacer dans l'environnement
     */
    @Override
    public void update() {
        for(DynamicSprite dynamicSprite : movingSpriteList){
            dynamicSprite.moveIfPossible(environment);
        }
    }
}

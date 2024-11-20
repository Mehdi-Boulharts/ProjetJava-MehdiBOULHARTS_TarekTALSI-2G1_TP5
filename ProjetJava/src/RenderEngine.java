import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine{
    private ArrayList<Displayable> renderList;

    /**
     * Constructeur de la classe RenderEngine.
     *
     * Ce constructeur initialise le moteur de rendu en configurant
     * la taille préférée du composant et en initialisant la liste de rendu
     * @param jFrame
     */
    public RenderEngine(JFrame jFrame) {
        setPreferredSize(new Dimension(800, 600));
        renderList = new ArrayList<>();
    }

    /**
     * Ajoute un objet affichable à la liste de rendu s'il n'y est pas déjà présent
     *
     * Cette méthode vérifie si l'objet spécifié est déjà dans la liste de rendu
     * Si ce n'est pas le cas, l'objet est ajouté à la liste
     * @param displayable
     */
    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    /**
     * Ajoute une liste d'objets affichables à la liste de rendu s'ils n'y sont pas déjà présents
     *
     * Cette méthode vérifie si la liste fournie est déjà présente dans la liste de rendu
     * Si ce n'est pas le cas, tous les objets de la liste sont ajoutés à la liste de rendu
     * @param displayable
     */
    public void addToRenderList(ArrayList<Displayable> displayable){
        if (!renderList.contains(displayable)){
            renderList.addAll(displayable);
        }
    }

    /**
     * Dessine le contenu de la fenêtre.
     *
     * Cette méthode est appelée pour rendre le contenu graphique de la fenêtre.
     * Elle appelle d'abord la méthode de peinture de la classe parente,
     * puis dessine tous les objets affichables de la liste de rendu.
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Displayable renderObject:renderList) {
            renderObject.draw(g);
        }
    }

    /**
     * Met à jour l'affichage de la fenêtre.
     *
     * Cette méthode est appelée pour rafraîchir l'affichage en demandant
     * une nouvelle peinture de la fenêtre. Elle appelle la méthode repaint()
     * pour redessiner le contenu graphique
     */
    @Override
    public void update(){
        this.repaint();
    }
}

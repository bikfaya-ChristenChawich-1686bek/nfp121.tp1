package question1;

import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.0 (15 July 2000)
 */

public class Circle {
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new circle at default position with default color.
     */
    public Circle() {
        diameter = 30;
        xPosition = 20;
        yPosition = 60;
        color = "blue";
        isVisible = false;
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight() {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft() {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp() {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown() {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance) {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance) {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newDiameter) {
        erase();
        diameter = newDiameter;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    private void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition,
                    diameter, diameter));
            canvas.wait(10);
        }
    }

    /*
     * Erase the circle on screen.
     */
    private void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Cr�ation", le constructeur d'un auditeur avec son nom, son pr�nom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son pr�nom
     * @param matricule
     *            sur la carte d'inscription, pr�s de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premi�res lettres du nom suivies de la premi�re
     * lettre du pr�nom s�par�es de '_' . le login retourn� est en minuscules,
     * le trait d'union, ou sp�ciaux <i>(pour unix)</i> sont remplac�s par des
     * '_' pas de caract�res accentu�s pour le login voir les classes
     * pr�d�fines, java.lang.String : les m�thodes replaceAll, toLowerCase et
     * substring java.lang.Math : la m�thode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifi�, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        String login="";
        String n=this.nom().toLowerCase().substring(0,6).replaceAll("[^a-zA-Z]+","_");
        String p=this.prenom().toLowerCase().substring(0,1).replaceAll("[^a-zA-Z]+","_");
        login=n+"_"+p;
        return login;
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return null;// � compl�ter
    }

    /**
     * Lecture du pr�nom de l'auditeur.
     * 
     * @return son pr�nom
     */
    public String prenom() {
        return null;// � compl�ter
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return null;// � compl�ter
    }

    /**
     * m�thode toString ( m�thode red�finie de la classe Object).
     * 
     * @return la concat�nation du nom, du pr�nom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }
}
}

# Exercice 1:

En utilisant l'héritage, définir une classe `SlantedRectangle` permettant de manipuler de tels objets. Définir des constructeurs appropriés.

## Solution

```java
public class SlantedRectangle extends Rectangle {
    private double angle;
    
    // Constructeur avec point, largeur, hauteur et angle
    public SlantedRectangle(Point basGauche, double largeur, double hauteur, double angle) {
        super(basGauche, largeur, hauteur);
        this.angle = angle;
    }
    
    // Constructeur avec deux points et angle
    public SlantedRectangle(Point basGauche, Point topRight, double angle) {
        super(basGauche, topRight);
        this.angle = angle;
    }
    
    // Constructeur avec 4 coordonnées et angle
    public SlantedRectangle(double x1, double y1, double x2, double y2, double angle) {
        super(x1, y1, x2, y2);
        this.angle = angle;
    }
    
    // Getter pour l'angle
    public double getAngle() {
        return angle;
    }
}
```
### Explications

La classe `SlantedRectangle` étend la classe `Rectangle` en ajoutant un attribut `angle` pour représenter l'inclinaison du rectangle par rapport à l'horizontale. Les constructeurs reprennent les paramètres des constructeurs de la classe parente et y ajoutent l'angle d'inclinaison.
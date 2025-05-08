# Exercice 2:

Définir une méthode `rotate` dans l'esprit de la méthode `translate`.

## Solution

```java
public class SlantedRectangle extends Rectangle {
    private double angle;
    
    // Constructeurs (comme définis précédemment)
    
    /**
     * Fait pivoter le rectangle d'un angle donné (en radians)
     * @param alpha l'angle de rotation à ajouter
     */
    public void rotate(double alpha) {
        this.angle = (this.angle + alpha) % (2 * Math.PI);
        // Si l'angle est négatif, on ajuste pour avoir une valeur entre 0 et 2π
        if (this.angle < 0) {
            this.angle += 2 * Math.PI;
        }
    }
    
    // Getter pour l'angle
    public double getAngle() {
        return angle;
    }
}
```
### Explications

La méthode `rotate` permet de faire pivoter le rectangle incliné en modifiant son angle d'inclinaison. Elle prend en paramètre un angle (en radians) à ajouter à l'angle actuel. Pour maintenir l'angle dans l'intervalle [0, 2π], on utilise l'opération modulo et un ajustement pour les angles négatifs.
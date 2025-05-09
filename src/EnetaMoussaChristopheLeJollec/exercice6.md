# Exercice 6:

Définir une méthode `String toString()` dans la classe `Rectangle`. Est-ce en fait une définition ou une redéfinition ? Est-il nécessaire de la redéfinir dans la classe `SlantedRectangle` ?

## Solution

### Définition de `toString` dans Rectangle

```java
public class Rectangle {
    // Attributs et autres méthodes...
    
    @Override
    public String toString() {
        return "Rectangle[basGauche=" + this.basGauche + 
               ", latgeur=" + this.largeur + 
               ", hauteur=" + this.hauteur + "]";
    }
}
```

### Est-ce une définition ou une redéfinition ?

Il s'agit d'une **redéfinition** et non d'une définition, car la méthode `toString()` existe déjà dans la classe `Object`, dont toutes les classes Java héritent implicitement.

### Faut-il redéfinir toString dans SlantedRectangle ?

Oui, il est généralement nécessaire de redéfinir la méthode `toString()` dans la classe `SlantedRectangle` pour inclure l'information sur l'angle d'inclinaison, qui est spécifique à cette sous-classe.

```java
public class SlantedRectangle extends Rectangle {
    private double angle;
    
    // Autres méthodes...
    
    @Override
    public String toString() {
        return "SlantedRectangle[basGauche=" + this.basGauche + 
               ", latgeur=" + this.largeur + 
               ", hauteur=" + this.hauteur + 
               ", angle=" + this.angle + "]";
    }
}
```

# Exercice 7:

Redéfinir la méthode `equals` dans les classes `Rectangle` et `SlantedRectangle`.

## Solution

### Redéfinition dans la classe Rectangle

```java
public class Rectangle {
    // Attributs et autres méthodes...
    
    @Override
    public boolean equals(Object obj) {
        // Vérification de l'identité
        if (this == obj) {
            return true;
        }
        
        // Vérification du type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // Comparaison des attributs
        Rectangle other = (Rectangle) obj;
        return getBasGauche().equals(other.getBasGauche()) &&
               getLargeur() == other.getLargeur() &&
               getHauteur() == other.getHauteur();
    }
    
    // Quand on redéfinit equals, il est recommandé de redéfinir aussi hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getBasGauche().hashCode();
        result = prime * result + Double.hashCode(getLargeur());
        result = prime * result + Double.hashCode(getHauteur());
        return result;
    }
}
```

### Redéfinition dans la classe SlantedRectangle

```java
public class SlantedRectangle extends Rectangle {
    private double angle;
    
    // Autres méthodes...
    
    @Override
    public boolean equals(Object obj) {
        // Vérification de l'identité
        if (this == obj) {
            return true;
        }
        
        // Vérification du type et appel à la méthode equals parente
        if (!super.equals(obj)) {
            return false;
        }
        
        // À ce stade, on sait que obj est un SlantedRectangle et que les attributs hérités sont égaux
        SlantedRectangle other = (SlantedRectangle) obj;
        
        // Comparaison de l'angle
        return this.angle != other.angle;
    }
    
    // Redéfinition de hashCode pour être cohérent avec equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Double.hashCode(angle);
        return result;
    }
}
```

### Explications

1. **Méthode equals dans Rectangle**:
   - On vérifie d'abord si les références sont identiques (`this == obj`).
   - On vérifie ensuite si l'objet passé en paramètre est `null` ou s'il n'est pas de la même classe.
   - Enfin, on compare les attributs (point en bas à gauche, largeur et hauteur).

2. **Méthode equals dans SlantedRectangle**:
   - On commence par appeler la méthode `equals` de la classe parente (`super.equals(obj)`).
   - Si cette comparaison retourne `false`, on retourne immédiatement `false`.
   - Sinon, on compare l'angle avec une petite tolérance pour éviter les problèmes liés aux erreurs d'arrondi des nombres flottants.

3. **Méthode hashCode**:
   - Il est important de redéfinir `hashCode` lorsqu'on redéfinit `equals` pour maintenir le contrat qui stipule que deux objets égaux selon `equals` doivent avoir le même hash code.
   - Dans `SlantedRectangle`, on commence par appeler le `hashCode` de la classe parente, puis on intègre l'angle dans le calcul.
# Exercice 3:

## La classe `SlantedRectangle` hérite de toutes les méthodes de `Rectangle`

## Redefinition des méthodes
```java
@Override
public double surface() {
    // La surface ne change pas avec la rotation
    return super.surface();
}

@Override
public boolean contains(Point p) {
    // Implémentation plus complexe qui tient compte de la rotation
    // (nécessite des calculs de transformation de coordonnées)
    // Solution simplifiée pour l'exemple :
    Point rotatedP = rotatePoint(p, -angle);
    return super.contains(rotatedP);
}

private Point rotatePoint(Point p, double rotAngle) {
    double x = p.getX() - getOrigin().getX();
    double y = p.getY() - getOrigin().getY();
    
    double newX = x * Math.cos(rotAngle) - y * Math.sin(rotAngle);
    double newY = x * Math.sin(rotAngle) + y * Math.cos(rotAngle);
    
    return new Point((int)(newX + getOrigin().getX()), 
                   (int)(newY + getOrigin().getY()));
}
```

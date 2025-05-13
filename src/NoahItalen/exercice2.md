# Exercice 2:

## La méthode rotate()
```java
public void rotate(double deltaAngle) {
    this.angle += deltaAngle;
    // Normaliser l'angle entre 0 et 2π
    this.angle = this.angle % (2 * Math.PI);
}
```

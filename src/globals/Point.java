public class Point {
    // Coordonnées
    private double abs;
    private double ord;
    
    // Constructeur
    public Point(double abs, double ord) {
        this.abs = abs;
        this.ord = ord;
    }
    
    // Getters et setters
    public double getAbs() {
        return abs;
    }
    
    public double getOrd() {
        return ord;
    }

    public void setAbs(double abs) {
        this.abs = abs;
    }
    
    public void setOrd(double ord) {
        this.ord = ord;
    }
}
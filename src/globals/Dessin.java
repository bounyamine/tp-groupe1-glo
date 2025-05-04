public class Dessin {
    private Rectangle[] rectangles;
    private int nbRectangles;
    private Rectangle hullRect; // Pour l'exercice 9
    
    public Dessin(int taille) {
        rectangles = new Rectangle[taille];
        nbRectangles = 0;
        hullRect = null;
    }
    
    // Méthode pour ajouter un rectangle
    public boolean add(Rectangle r) {
        if (nbRectangles < rectangles.length) {
            rectangles[nbRectangles] = r;
            nbRectangles++;
            
            // Mise à jour du rectangle englobant (pour l'exercice 9)
            if (hullRect == null) {
                hullRect = new Rectangle(
                    r.getBasGauche(),
                    r.getLargeur(),
                    r.getHauteur()
                );
            } else {
                double minX = Math.min(hullRect.getBasGauche().getAbs(), r.getBasGauche().getAbs());
                double minY = Math.min(hullRect.getBasGauche().getOrd(), r.getBasGauche().getOrd());
                double maxX = Math.max(
                    hullRect.getBasGauche().getAbs() + hullRect.getLargeur(),
                    r.getBasGauche().getAbs() + r.getLargeur()
                );
                double maxY = Math.max(
                    hullRect.getBasGauche().getOrd() + hullRect.getHauteur(),
                    r.getBasGauche().getOrd() + r.getHauteur()
                );
                
                hullRect = new Rectangle(minX, minY, maxX - minX, maxY - minY);
            }
            
            return true;
        }
        return false;
    }
    
    // Méthode pour calculer la surface totale du dessin
    public double surface() {
        double totalSurface = 0;
        for (int i = 0; i < nbRectangles; i++) {
            totalSurface += rectangles[i].surface();
        }
        return totalSurface;
    }
    
    // Méthode pour translater le dessin
    public void translate(double dx, double dy) {
        for (int i = 0; i < nbRectangles; i++) {
            rectangles[i].translate(dx, dy);
        }
        
        // Mise à jour du rectangle englobant
        if (hullRect != null) {
            hullRect.translate(dx, dy);
        }
    }
    
    // Méthode qui renvoie le rectangle englobant du dessin
    public Rectangle hull() {
        return hullRect;
    }
}
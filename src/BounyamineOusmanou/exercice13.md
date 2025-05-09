# Exercice 13

On considère les définitions de classes suivantes :

```java
class C {
    char ch = 'C';
    char getCh() { return ch; }
}

class D extends C {
    char ch = 'D';
    char getCh() { return ch; }
}
```

Qu'affiche le fragment de programme suivant ?

```java
C c = new C();
C cd = new D();
D d = new D();

System.out.println(c.ch);
System.out.println(c.getCh());
System.out.println(cd.ch);
System.out.println(cd.getCh());
System.out.println(d.ch);
System.out.println(d.getCh());
```

## Solution

En Java, les attributs sont liés au type statique (déclaré) de la variable, contrairement aux méthodes qui sont liées au type dynamique (réel) de l'objet. C'est ce qu'on appelle le "masquage d'attributs" par opposition à la "redéfinition de méthodes".

1. **c.ch** :
   - Type statique de `c` est `C`
   - On accède à l'attribut `ch` de la classe `C`
   - **Affichage :** `C`

2. **c.getCh()** :
   - Type statique de `c` est `C`
   - Type dynamique de `c` est `C`
   - On appelle la méthode `getCh()` de la classe `C`
   - Cette méthode retourne l'attribut `ch` de la classe `C`
   - **Affichage :** `C`

3. **cd.ch** :
   - Type statique de `cd` est `C`
   - On accède à l'attribut `ch` de la classe `C`
   - **Affichage :** `C`

4. **cd.getCh()** :
   - Type statique de `cd` est `C`
   - Type dynamique de `cd` est `D`
   - On appelle la méthode `getCh()` de la classe `D` (redéfinition)
   - Cette méthode retourne l'attribut `ch` de la classe `D`
   - **Affichage :** `D`

5. **d.ch** :
   - Type statique de `d` est `D`
   - On accède à l'attribut `ch` de la classe `D`
   - **Affichage :** `D`

6. **d.getCh()** :
   - Type statique de `d` est `D`
   - Type dynamique de `d` est `D`
   - On appelle la méthode `getCh()` de la classe `D`
   - Cette méthode retourne l'attribut `ch` de la classe `D`
   - **Affichage :** `D`

Le résultat complet sera donc :

```
C
C
C
D
D
D
```
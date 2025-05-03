# TP POO Java

Ce projet créer pour les travaux pratique en groupe sur la Programmation Orienté Objet en Java.

## Membres du groupe

- **Membre 1** : BOUNYAMINE OUSMANOU
- **Membre 2** : DIYEN YEM BRIAN
- **Membre 3** : ENETA MOUSSA CHRISTOPHE LE JOLEC
- **Membre 4** : ITALEN NOAH CLAUDE SOREL

## Répartition des exercices

- **Membre 1** : Exercices 10, 11, 12, 13
- **Membre 2** : Exercices 7, 8, 9
- **Membre 3** : Exercices 4, 5, 6
- **Membre 4** : Exercices 1, 2, 3

## Guide de contribution

Pour maintenir une organisation claire et permettre à notre enseignant d'identifier facilement qui a travaillé sur quoi, veuillez suivre scrupuleusement ces règles pour chaque commit.

### 1. Configuration initiale (à faire une seule fois)

```bash
# Cloner le dépôt
git clone https://github.com/bounyamine/tp-groupe1-glo.git
cd tp-groupe1-glo

# Configurer votre identité Git
git config user.name "Votre Nom"
git config user.email "votre.email@example.com"
```

### 2. Procédure pour chaque séance de travail

#### Avant de commencer à coder

```bash
# S'assurer d'être à jour avec le dépôt distant
git pull origin main
```

#### Pendant votre travail

Programmez vos solutions pour les exercices qui vous sont attribués.
N'oubliez pas d'ajouter un en-tête de documentation à chaque fichier :

```java
/**
 * Exercice X :
 * @author [Votre Nom]
 * @date [Date du jour]
 */
```

#### Pour commiter votre travail

```bash
# Vérifier les fichiers modifiés
git status

# Ajouter seulement VOS fichiers (pas ceux des autres)
git add src/[Votre Nom]/exerciceX.md

# Commiter avec un message clair
git commit -m "[ExerciceX] Implémentation de [fonctionnalité] - par [Votre Nom]"

# Pull avant de push (pour éviter les conflits)
git pull origin main

# Pousser vos modifications
git push origin main
```

### 3. Conventions pour les messages de commit

Utilisez le format suivant pour vos messages de commit :

```
[ExerciceX] Description courte - par [Votre Nom]
```

Exemple :
- "[Exercice1] Implémentation de la classe SlantedRectangle - par BOUNYAMINE OUSMANOU"


### 4. En cas de conflit

Si un conflit survient lors du pull :

1. Ouvrez les fichiers marqués comme conflictuels (ils contiennent des marqueurs `<<<<<<<`, `=======`, `>>>>>>>`)
2. Discutez avec votre collègue pour résoudre le conflit
3. Éditez le fichier pour conserver le code correct
4. Marquez le conflit comme résolu :
   ```bash
   git add [fichier-avec-conflit]
   git commit -m "Résolution de conflit dans ExerciceX - collaboration entre [Nom1] et [Nom2]"
   git push origin main
   ```

### 5. Bonnes pratiques

- **Ne modifiez que vos propres fichiers** pour éviter les conflits
- **Commettez régulièrement** (au moins après avoir terminé chaque exercice)
- **Vérifiez toujours avec `git status`** avant d'ajouter des fichiers
- **Faites un pull avant chaque push** pour éviter les conflits
- **Communiquez avec vos coéquipiers** lorsque vous commencez à travailler sur le projet

## Structure du projet

```
/src
    /ItalenNoahClaudeSorel
        exercice1.md
        exercice2.md
        exercice3.md
    /EnetaMoussaChristopheLeJolec
        exercice4.md
        exercice5.md
        exercice6.md
    /DiyenYemBrian
        exercice7.md
        exercice8.md
        exercice9.md
    /DiyenYemBrian
        exercice10.md
        exercice11.md
        exercice12.md
        exercice13.md
    /globals
        Point.java
        Rectangle.java
        Dessin.java
        SlantedRectangle.java
        Main.java

## Date de rendu

À finir pour le : 20/05/2025
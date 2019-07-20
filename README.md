# README Projet POO

Ce projet a été réalisé dans le cadre du module de POO - Programmation Orientée Objet - Java.

## Credits


Hereng Adrien  
ESIEA Paris - 2017/2018


## Getting Started

### Utilisation des scripts

#### Prérequis
Avant de lancer toutes commandes, veuillez rendre les trois fichiers **compile.sh**, **test.sh** et **launch_banking.sh** exécutables.  
Pour cela, tapez **chmod +x launch_banking.sh test.sh compile.sh** dans votre terminal.

#### compile.sh
Le fichier compile.sh lancera la compilation de tous les fichiers java des différents projets.  
Pour lancer la compilation de tous les fichiers java, tapez **./compile.sh** dans votre terminal.


#### launch_banking.sh
Le fichier launch_banking.sh lancera l'application banking.  
Pour lancer l'application banking, tapez **./launch_banking.sh** dans votre terminal.
Cette option simulera l'entrée dans l'espace client d'une banque fonctionnelle.
Vous pourrez ainsi créer un compte, y accéder, déposer de l'argent, transférer de l'argent d'un compte à un autre, emprunter de l'argent, et plein d'autres choses encore.


### launch_test.sh
Le fichier launch_test.sh lancera les tests du projet banking.  
Pour lancer tous les tests du projet banking, tapez **./launch_test.sh** dans votre terminal.
Cette option permettera de vérifier le bon fonctionnement du programme, vous pourrez observer les classes et méthodes testées, le temps en ms employé pour chaque test, ainsi que le pourcentage de réussite pour chaque classe.

### Points d'entrée du code

Il y a deux points d'entrée dans le code : **Banking.java** et **RunTest.java**.

### Difficultés rencontrées

J'ai surtout rencontré des difficultés dans la partie **test_framework** du projet. j'ai appris à gérer les tests unitaires sur des fonctions simples (getters et setters par exemple) mais je n'ai pas réussi à implémenter des tests unitaires sur des fonctions demandant des entrées au clavier par exemple. Pour remédier à ce problème, j'ai recrée des fonctions simplifiées pour ensuite les tester.
De plus j'ai fait quelques choix de simplification pour le programme **banking**. Par exemple, l'utilisateur ne peut pas créer deux comptes avec le même nom, car la seule chose qui différencie deux comptes avec le même nom est l'age de la personne possédant le compte. Dans ce projet le but du programme **banking** étant d'implémenter une application bancaire simple, nous je n'ai donc pas utilisé de mot de passe pour différencier deux comptes avec le même nom, car mot de passe implique sécurité, et sécurité implique cryptologie et chiffrement des données, ce qui n'est pas attendu ici.

# Dojo - La main de Poker

## Description du problème
Comparer deux mains de poker saisies sur l’entrée standard, déterminer laquelle est la plus forte et 
afficher ce résultat.

## Description du projet
Le jeu peut se jouer avec autant de joueur que voulu, tant qu'il y a des cartes disponibles dans le packet de cartes. 
La saisie des cartes peut se faire de manière Automatique ou Manuel.
Le code détecte toutes les mains possibles du poker et est capable d'identifier le gagnant ou s'il y a égalité et puis les afficher.
Et aussi dans le dossier Test se trouve les tests des classes java.

Et ce code fonctionne aussi avec une interface de jeu qui se trouve se le checkout Visuel.

## Installation
* git clone https://github.com/pns-si3-projects/dojo-poker-21-22-gd5.git
* cd dojo-poker-21-22-gd5
* git checkout FINAL
* Open in a IDE
* Run PokerHand.java
* Have fun. 😄 👍

## Description des règles
Une main de poker comprend 5 cartes tirées d’un seul jeu de 52 cartes. Chaque carte a une couleur, Trèfle, Carreau, Cœur, Pique (dénotée Tr, Ca, Co, Pi) et une valeur parmi 2, 3, 4, 5, 6, 7, 8, 9, 10, valet, dame, roi, as (dénotée 2, 3, 4, 5, 6, 7, 8, 9, 10, V, D, R, A). Pour le calcul du score, toutes les couleurs ont le même niveau, par exemple l’as de carreau n’est pas battu par l’as de pique, ils sont égaux. Les valeurs sont ordonnées comme définies précédemment, le 2 étant la plus petite valeur et l’as la plus grande.
Une main de poker est faite de 5 cartes. Dans le texte ci-dessous, les mains sont classées de la plus faible à la plus forte :

● Plus haute carte : les mains qui ne correspondent à aucune autre catégorie sont classées par la valeur de leur plus haute carte. Si les plus hautes cartes ont la même valeur, les mains sont classées par la plus haute suivante et ainsi de suite.

● Paire : 2 des 5 cartes de la main ont la même valeur. Deux mains qui contiennent une paire sont classées par la valeur des cartes formant la paire. Si les valeurs sont les mêmes, les mains sont classées par les cartes hors de la paire, en ordre décroissant.

● Deux paires : La main contient deux paires différentes. Les mains qui contiennent deux paires sont classées par la valeur de la paire la plus élevée. Deux mains avec la paire la plus élevée de même valeur sont classées par l’autre paire. Si ces valeurs sont les mêmes, les mains sont classées par la valeur de la carte restante.

● Brelan : 3 cartes dans la main ont la même valeur. Deux mains avec un brelan sont classées par la valeur des 3 cartes.

● Suite : 5 cartes de valeurs consécutives. Deux suites sont classées par la valeur de leur carte la plus élevée.

● Couleur : La main contient 5 cartes de la même couleur. Deux mains “couleur” sont classées par les règles de la carte la plus élevée.

● Full : La main contient 3 cartes de la même valeur avec les 2 cartes formant une paire, le classement se fait par la valeur des 3 cartes.

● Carré : 4 cartes de la même valeur, classement par la valeur des 4 cartes.

● Quinte Flush : 5 cartes de la même couleur avec des valeurs consécutives, classement par la carte la plus élevée dans la main.


## Donnations
On aime créer des programmes gratuitement. Si vous souhaitez donner de l'argent pour aider des étudiants comme nous, ce serait très apprécié !

### Matis Herrmann
[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.me/MatisHerrmann)

### Louis Hattiger
[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.me/LouisHattiger)

### Vinh Faucher
[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.me/VinhFaucher)

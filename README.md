Polytech Nice - Sophia Antipolis PS5 – Projet de développement semestre 5
1/2
Dojo - La main de Poker
septembre 2021 - V0.4
Philippe Collet & Sébastien Mosser
D’après PokerHands (codingDojo.org, the coding dojo handbook de Emily Bache)
Description du problème
Comparer deux mains de poker saisie sur l’entrée standard, déterminer laquelle est la plus 
forte et afficher ce résultat.
Description des règles
Une main de poker comprend 5 cartes tirées d’un seul jeu de 52 cartes. Chaque carte a une couleur, 
Trèfle, Carreau, Cœur, Pique (dénotée Tr, Ca, Co, Pi) et une valeur parmi 2, 3, 4, 5, 6, 7, 8, 9, 10, 
valet, dame, roi, as (dénotée 2, 3, 4, 5, 6, 7, 8, 9, 10, V, D, R, A). Pour le calcul du score, toutes les 
couleurs ont le même niveau, par exemple l’as de carreau n’est pas battu par l’as de pique, ils sont 
égaux. Les valeurs sont ordonnées comme définies précédemment, le 2 étant la plus petite valeur 
et l’as la plus grande.
Une main de poker est faite de 5 cartes. Dans le texte ci-dessous, les mains sont classées de la 
plus faible à la plus forte :
● Plus haute carte : les mains qui ne correspondent à aucune autre catégorie sont classées 
par la valeur de leur plus haute carte. Si les plus hautes cartes ont la même valeur, les mains 
sont classées par la plus haute suivante et ainsi de suite.
● Paire : 2 des 5 cartes de la main ont la même valeur. Deux mains qui contiennent une paire 
sont classées par la valeur des cartes formant la paire. Si les valeurs sont les mêmes, les 
mains sont classées par les cartes hors de la paire, en ordre décroissant.
● Deux paires : La main contient deux paires différentes. Les mains qui contiennent deux 
paires sont classées par la valeur de la paire la plus élevée. Deux mains avec la paire la plus 
élevée de même valeur sont classées par l’autre paire. Si ces valeurs sont les mêmes, les 
mains sont classées par la valeur de la carte restante.
● Brelan : 3 cartes dans la main ont la même valeur. Deux mains avec un brelan sont classées 
par la valeur des 3 cartes.
● Suite : 5 cartes de valeurs consécutives. Deux suites sont classées par la valeur de leur 
carte la plus élevée.
● Couleur : La main contient 5 cartes de la même couleur. Deux mains “couleur” sont classées 
par les règles de la carte la plus élevée.
● Full : La main contient 3 cartes de la même valeur avec les 2 cartes formant une paire, le 
classement se fait par la valeur des 3 cartes.
● Carré : 4 cartes de la même valeur, classement par la valeur des 4 cartes.
● Quinte Flush : 5 cartes de la même couleur avec des valeurs consécutives, classement par 
la carte la plus élevée dans la main.
Exemples
Main 1: 2Tr 6Ca 7Ca 8Tr APi
Polytech Nice - Sophia Antipolis PS5 – Projet de développement semestre 5
2/2
Main 2: 3Tr 5Ca 9Ca DCo RCo
La main 1 gagne avec carte la plus élevée : As
Main 1: 2Tr 6Ca 7Ca 8Tr APi
Main 2: 3Tr 5Ca 5Co DCo RCo
La main 2 gagne avec paire de 5
Main 1: 2Tr 6Ca 3Ca 8Tr APi
Main 2: 3Tr 6Pi 2Ca 8Co ACo
Egalite
Travail à réaliser pour les débutants
● S37: Première semaine : 
 Spécifier un découpage des tâches et des releases pour implémenter en trinôme 
une solution en Java (faire aussi le setup github, équipe sur github classroom, etc.).
● S38: Deuxième semaine : 
 Présenter la spécification des tâches (fichier excel nommé “Nom”-”specs”.xls, 
exemple A-specs.xls) au chargé de TD en début de séance.
 Commencer à implémenter la solution en versionnant le code, tenir à jour et 
modifier le planning des tâches…
● S39 : Troisième semaine : 
 Le code est sur le git, la progression s’est faite et continue commit par commit
 Continuer mais avec des tests, plus rien n’est livré sans que vous puissiez donner 
confiance dans la correction de votre code et dans chaque livraison
● S40 : Quatrième semaine : test / code / version / refactor
● S41 : Cinquième semaine : test / code / version / refactor
● S42 : Sixième semaine : test / code / version / refactor
● S43 : Septième semaine : soutenance technique
Travail à réaliser pour les moins débutants
La même chose en 3 semaines semaines en équipe de 4, mais en découpant, construisant les 
bonnes abstractions testées (ceci n’est pas un exercice de rush de programmation) 
A partir de la 3ème semaine : si votre version est correctement réalisée (bonnes abstractions, 
bons tests), réutiliser le comparateur de main dans un jeu de poker interactif en ligne de 
commandes à 2 joueurs (le descriptif sera publié plus tard).
Logistique
● Modèle de tableur Excel de définition et suivi des tâches : https://unicemy.sharepoint.com/:x:/g/personal/philippe_collet_unice_fr/EQCR8cKkSdxAhXJTevv89QgB
cHduxIX1SYTNk9aKAVmnmQ?e=ZyFduY
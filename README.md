http://www-igm.univ-mlv.fr/ens/IR/IR2/2025-2026/JavaAvance/td01.php

Q1 : Faut créer un record Car et écrire les préconditions dans le constructeur canonique

Q2 : La méthode parse est statique. 

Pour empêcher de faire un new FerryParser(), il faut rendre private le constructeur.

Pour empêcher l'héritage il faut rendre la classe final (ou scellé la classe mais c'est pas ce qu'on demande).

JsonParser implante l'interface AutoCloseable, ça veut dire qu'il doit être dans un bloc try-with-resources.

Q3 : L'interface des dictionnaires est une Map et on va utiliser une HashMap.

On va utiliser la méthode merge pour cumuler le prix d'une voiture si un propriétaire en possède plusieurs.

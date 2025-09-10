http://www-igm.univ-mlv.fr/ens/IR/IR2/2025-2026/JavaAvance/td01.php

**Q1** : Faut créer un record Car et écrire les préconditions dans le constructeur canonique

**Q2** : La méthode parse est statique. 

Pour empêcher de faire un new FerryParser(), il faut rendre private le constructeur.

Pour empêcher l'héritage il faut rendre la classe final (ou scellé la classe mais c'est pas ce qu'on demande).

JsonParser implante l'interface AutoCloseable, ça veut dire qu'il doit être dans un bloc try-with-resources.

**Q3** : L'interface des dictionnaires est une Map et on va utiliser une HashMap.

On va utiliser la méthode merge pour cumuler le prix d'une voiture si un propriétaire en possède plusieurs.

**Q4** : On va créer une interface Vehicle et on va utiliser le Pattern Matching pour calculer le prix d'une liste de voiture ou de camion.

**Q5** :

````java
public static List<Vehicle> parse(String jsonText) throws IOException {
    Objects.requireNonNull(jsonText);
    return reader.forType(new TypeReference<List<Vehicle>>(){}).readValue(jsonText);
}
````

**Q6** : On va changer notre HashMap en LinkedHashMap pour conserver l'ordre d'insertion.
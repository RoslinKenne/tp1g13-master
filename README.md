# Gestion de bus en Java console

Prérequis : JDK 21 (fonctionne également avec un JDK compatible avec les switch expressions).

```sh
mkdir -p build
javac -d build src/*.java tests/*.java
java -cp build AutoRent
java -cp build BusTest
```

Le menu permet de créer des chauffeurs et des bus, de réserver un bus et de consulter les trajets. L’identifiant du chauffeur est affiché après sa création. Les réservations sont conservées en mémoire pendant la session ; aucun paiement ni stockage JSON n’est implémenté. Un bus déjà réservé ne peut pas être réservé une deuxième fois dans cette session.

Tests : réservations, références bus/trajet, doublons, saisies invalides et agrandissement des tableaux.

## Validation

Les tests couvrent les scénarios décrits ci-dessous. Ils vérifient la version corrigée ; ils ne garantissent pas tous les usages possibles.

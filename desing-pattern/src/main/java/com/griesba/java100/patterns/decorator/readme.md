Decorator pattern also known as wrapper.
Attach additional responsibility to an object dynamically. Decorator provide alternative to subclassing for extending functionality.

Example : on est dans une situation où un catalogue de véhicule présente un ensemble de véhicule haut de gamme. 
Nous voulons afficher des informations techniques supplémentaire dans le catalogue.
Pour cela on décide de créer deux décorateur (un pour le modèle et l'autre pour la marque de véhicule). 
On évite ainsi d'utiliser l'héritage qui est un outil trop puissant pour la fonctionalité demandé et est également statique.
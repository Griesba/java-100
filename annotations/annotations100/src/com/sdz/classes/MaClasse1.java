package com.sdz.classes;

import com.sdz.annotation.NIVEAU;
import com.sdz.annotation.Todo;
import com.sdz.annotation.Todos;

public class MaClasse1 {
    @Todo(
            auteur = "zozor",
            niveau = NIVEAU.AMELIORATION,
            commentaire = "Tu ferais mieux d'utiliser un double...",
            destinataire = "cysboy"
    )
    private short entier = 0;

    @Todos(todos = {
            @Todo(   auteur = "zouzou",
                    niveau = NIVEAU.AMELIORATION,
                    commentaire = "Tu ferais mieux d'utiliser un double...",
                    destinataire = "nombre"),
            @Todo(
                    commentaire = "Utiliser l'annotation @SuppressWarning",
                    destinataire = "cysboy")
    })
    private int nombre = 12;

    @Todo(
            commentaire = "Penser à faire les initialisations...",
            destinataire = "zozor"
    )
    public MaClasse1(){ }
    
}

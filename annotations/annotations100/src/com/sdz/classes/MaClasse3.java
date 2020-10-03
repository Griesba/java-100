package com.sdz.classes;

import com.sdz.annotation.NIVEAU;
import com.sdz.annotation.Todo;

public class MaClasse3 {
    public void doSomething(
            @Todo(
                    niveau = NIVEAU.BUG,
                    commentaire = "Vérifier le contenu de ce paramètre",
                    destinataire = "cysboy"
            )
            String str
    ){

    }
}

package com.sdz.classes;

import com.sdz.annotation.NIVEAU;
import com.sdz.annotation.Todo;

@Todo(
        niveau = NIVEAU.CRITIQUE,
        commentaire = "Il faudrait penser à terminer la classe.",
        destinataire = "zozor"
)
public class MaClasse2 extends MaClasse1 {
}

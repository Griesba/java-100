@ControllerAdvice
    permet de capturé les exceptions de façon isolé. 
    Ainsi le code qui capture les exception n'a pas besoin de se mettre dans la classe de RestController.
    C'est un Exception Handler global, qui intercepte toute les requettes provenant du client, 
    capture les eventuel exceptions avant de transferé la requette au service rest de destination.
    This is best practice for large and real-time project.
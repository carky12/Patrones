# Patrones de Diseño de Software

Proyecto en el que se implementan de forma teórica y práctica distintos patrones de diseño de software.

#### Creado por carky12

## Definición de patrón de diseño

Un patrón es una solución estandarizada en la que se agrupará el código y componentes para que sean reutilizables y sostenibles en el tiempo, haciendo del código escalable, desacoplado y metiendo una capa de abstracción. Los patrones de diseño se pueden agrupar en los siguientes tipos:

- Patrones de creación: Se inician y configuran objetos.
- Patrones estructurales: separan la interfaz de la implementación.
- Patrones de comportamiento: describen la comunicación entre los objetos implicados en la implementación.

## Patrones desarrollados

#### Singleton
Patrón de creación. El objetivo es tener una única instancia de una clase durante toda la aplicación para que todos los usuarios utilicen esa instancia. Por ejemplo, una lista de países a mostrar, que es casi improbable que cambien los nombres, no tiene sentido devolver un objeto por cada usuario, lo mejor es devolver un único objeto instanciado y por cada usuario que pida ese objeto se le proporcione el objeto. (en consumo de memoria es mucho mejor). Otro ejemplo típico es para la implementación de una conexión con base de datos. Este es el patrón que utiliza el framework Spring por defecto para definir sus beans.

Tenemos que generar una clase con un constructor de ámbito privado, para que no se pueda instanciar el objeto con "new". Para obtener la instancia del objeto se llama a un método estático que evalúa si ya existe una instancia del objeto. Si ya existe devuelve dicha instancia y si no existe se crea una nueva para devolverla.

#### Factoría
Patrón de creación. El objetivo es devolver instancias de un objeto en particular por medio de un identificador. No se va instanciar directamente el objeto, si no que la fabrica será la encargada de realizar la instancia y devolverla. Tenemos que indicarle a la fabrica que tipo de objeto queremos. Es fundamental apoyar el patrón sobre una interfaz ya que lo que se devolverá será una implementación de esa interfaz. Con esto conseguimos no depender de ninguna instancia en particular con lo que el código es mas flexible.

Se tendrá una interfaz que definirá el comportamiento de nuestros objetos. Tendremos multitud de implementaciones de esa interfaz. Por ejemplo interfaz Conexión y las implementaciones podrían ser ConexionMySQL, ConexionOracle, etc...El patrón se implementará en una clase que tendrá un método que devulve un objeto de tipo interfaz Conexion. Este método recibe por parámetro el identificador para saber que objeto se tiene que instanciar. Se realizará la instancia de la implementación correspondiente al identificador que se pasa por parámetro y se devuelve.

#### Factoría Abstracta
Patrón de creación. El objetivo es tener una super fabrica que genera fabricas. Para obtener una instancia de un objeto primero debemos indicar que fabrica utilizar. Nos apoyaremos en una interfaz que definirá las fabricas que tendrá nuestro código (habrá tantas fábricas como familias de objetos se quieran instanciar). Cada familia de objetos tendrá sus implementaciones, que es lo que devolverá la fabrica que utilicemos (el método de la fábrica está definido para que devuelva una interfaz, pero lo que devuelve es una implementación de esa interfaz).

Se tendrán tantas fábricas como familias diferentes de objetos necesitemos. La filosofía de estas fábricas es la misma que se aplica en el patrón fábrica, pero ahora a mayores tendremos una clase que recibirá un parámetro para realizar el instanciado de la fábrica que necesitemos. Dicha instancia devolverá una fábrica u otra en función del parámetro que se le pase al constructor. Una vez devuelta la fábrica podremos pedirle una instancia del objeto que necesitemos.

#### Prototype
Patrón de creación. El objetivo es crear una nueva instancia con los valores copiados de otra instancia. Si tenemos objetos con unos valores y queremos otro objeto diferente pero con los mismos valores sin tener que pasar por la asignación de atributos uno por uno podemos usar este patrón. La ventaja principal es que si teneos un objeto con multitud de valores y queremos una copia podemos usar este patrón.

Tendremos una interfaz que extiende de Clonable y que tendrá definido un método clonar que devolverá un objeto del mismo tipo que la intrfaz. Tendremos una clase que implementa esta interfaz, con lo que estaremos obligados a sobrescribir el método clonar. En ese método se realizará el clone y se devuelve el nuevo objeto clonado.

#### Fachada
Patrón estructural. El objetivo es ocultar la complejidad de la aplicación de forma que el cliente tenga un acceso fácil a la aplicación. El cliente utiliza la fachada para disponer de las operaciones de las implementaciones, no pasará directamente por la implementación. El cliente pasa por parámetro todo lo necesario para que las implementaciones realicen los cálculos o búsquedas, de tal forma que el cliente no sabe la lógica que se está realizando detrás de la fachada.

Se tendrá una clase que contendrá las variables privadas de las clases que contienen la lógica de negocio. En el constructor de dicha clase se realiza la instancia, con el operador new, de todas las clases definidas. Se definirá en la clase un método que será el encargado de hacer las llamadas a los métodos de todas las clases. Este método tendrá que recibir todos los parámetros necesarios para todas los métodos de todas las clases que están utilizando. El cliente (app principal por ejemplo) realizará un instanciado de la clase fachada y realizará la llamada al método central de dicha clase.

#### Decorator
Patrón estructural. El objetivo es agregar funcionalidades a un objeto existente sin alterar su estructura. Por ejemplo para indicar que herede de otra clase, o agregar otros atributos que nos hagan falta.

Se tendrá una clase plana con sus métodos y atributos. Se tendrá una interfaz que definirá los métodos de uso. Se tendrán tantas implementaciones de la interfaz como se necesiten. Dichas implementaciones asignan valores de la clase plana según sus preferencias. Sobre este escenario vamos a definir una clase Decorador, que será abstracta y en la que se implementará la interfaz sobre la que está definido el comportamiento de nuestras implementaciones, definiendo de forma protected (para que sea accesible desde la herencia de clases) una variable del tipo interfaz que hemos definido. Al implementar la interfaz tendremos que sobrescribir los métodos que realizan la asignación de atributos de cada implementación. En el constructor de esta clase Decorador se recibirá la instancia de la implementación que contiene la clase plana que queremos decorar. Después se definirá una clase que extienda de nuestra clase Decorador. En esta clase se sobrescribirá el método de las implementaciones, es en este método donde se agregará el comportamiento o atributo nuevo que queremos dar a nuestra clase plana.

#### Proxy
Patrón estructural. El objetivo es envolver el acceso al objeto final que necesitamos en un objeto intermediario. Con este patrón conseguimos encapsular el instanciado del objeto dentro de la clase proxy, esto es útil si el instanciado es costoso. Si hacemos que la clase proxy reciba una interfaz tendremos el código flexible y desacoplado, y a la hora de instanciar la clase proxy le pasaremos una implementación de la interfaz.

Se define una clase que implemente la interfaz que define las implementaciones que contienen nuestra lógica de negocio. En la clase proxy se sobrescriben los métodos de la interfaz. En dichos métodos se realizará la lógica o llamadas a métodos de las implementaciones de la interfaz. En el constructor de la clase se recibirá un objeto de tipo interfaz, de tal forma que al instanciar al proxy se puede pasar una implementación de dicha interfaz, con esto conseguimos desacoplar el código y que no dependa de una implementación en concreto. En los métodos de la clase proxy es donde estarán las instancias de las implementaciones, de tal forma que el cliente sólo trabaje con la instancia de la clase proxy.

#### Observer
Patrón de comportamiento. Utilizado en frameworks como Angular y en los paradigmas de programación reactiva. El patrón consta de tres clases. El sujeto (el que va ser observado), el observador y el cliente. El sujeto tiene un estado y una lista de observadores, y cuando el sujeto cambia su estado notifica a la lista de observadores el cambio de estado.

Tendremos una clase abstracta que definirá los métodos de lógica de negocio. Además en esta clase tendremos un objeto sujeto de ámbito protected para que pueda estar accesible desde la herencia. Esta clase será el observador. A continuación tendremos tantas clases como necesitemos que hereden de la clase observador. En el constructor de esta clase se seteará la variable sujeto (que tenía ámbito protected) y además se utilizará un método de dicha clase sujeto para agregar la clase a la lista de observadores (se utilizará la palabra reservada "this"). Además se sobrescribirán los métodos de lógica de negocio definidos en la clase padre. Por último tendremos la clase sujeto que tendrá definido de ámbito privado la lista de observadores, y tendremos un método público en el que se recibirán las clases que agregaremos a la lista de observadores. Este método recibirá objetos de tipo observadores (clase abstracta definida anteriormente). Esta clase sujeto además tendrá un método que se encargará de recorrer la lista de observadores y ejecutar el método o métodos de lógica de negocio que queremos lanzar cuando se produzca el seteo de cierta propiedad el objeto. Lo único que faltaría sería realizar la llamada al método de notificación de todos los observadores en el método setter para el cual queramos establecer la observación, de tal forma que cuando se realice el seteo de dicho atributo del objeto se lance la notificación y se ejecuten los métodos de todas las implementaciones que heredan de la clase observador. Desde la aplicación principal se creará una instancia de la clase sujeto y se le pasará a las instancias que se realicen de cada una de las clases que necesitemos (recordemos que el constructor de estas clases recibe un objeto de tipo sujeto). Con esto, cuando se haga un seteo del atributo en cuestión se lanzarán todos los métodos de las clases suscritas como observadores de la clase sujeto.

#### Strategy
Patrón de comportamiento. El objetivo es encapsular familias de algoritmos y hacerlos intercambiables. Consigue que los algoritmos sean independientes de los clientes que los utilizan. Realiza ejecuciones de lógica de negocio en función de la instancia que se envíe desde el cliente. Es un patrón que se puede utilizar para cambiar la interfaz gráfica en función del usuario que entre en la aplicación.

El patrón se basa en la creación de una interfaz que defina el método o métodos a ejecutar. Después tendremos tantas clases abstractas como familias de algoritmos necesitemos. Estas clases abstractas implementarán la interfaz estrategia, obligando a sobrescribir los métodos que contendrán la lógica a ejecutar. En las clases abstractas definiremos los métodos para ejecución de algoritmos, y esos métodos son los que se ejecutarán (en el orden que deseemos) en el método sobreescrito. Por otra parte tendremos tantas clases que heredan de las clases abstractas como deseemos, es en los métodos sobrescritos de esta clase donde estará la lógica de los algoritmos a ejecutar. Por último se definirá una clase intermedia (clase de contexto) donde se definirá una variable privada de la interfaz estrategia, iniciando dicha variable en el constructor (que recibe por parámetro una implementación de las clases que heredan de las clases abstractas, que son las clases que contienen la lógica de los algoritmos a utilizar). Además esta clase tendrá un método para ejecutar el método común definido en la interfaz que desenlaza la ejecución. Desde el cliente se creará una instancia de la clase intermediaria (clase de contexto) y se le pasará por parámetro una instancia de la clase que contiene la familia de algoritmos a ejecutar. Si queremos cambiar la familia de algoritmos lo único que tendremos que hacer es cambiar el parámetro por otra instancia de clase que contenga otros algoritmos. Como apunte la instancia que pasamos por parámetro la podemos generar utilizando el patrón de fábrica.

#### DAO (Data Access Object)
El objetivo es abstraer la lógica de acceso a una serie de operaciones. Es muy común utilizarlo para acceder a operaciones de bases de datos.

Tendremos una interfaz en donde estarán definidos todos los métodos u operaciones. Tendremos una implementación de esa interfaz en la que se detallará la lógica de negocio de cada operación. Desde el cliente se instanciará un objeto del tipo interfaz haciendo un new del objeto que contiene la implementación. Como siempre, programar orientado a interfaces nos dará la ventaja de tener un código desacoplado. Por último podremos utilizar los métodos de la clase instanciada y que contienen la lógica de cada operación. Como nota, para cada entidad o familia de operaciones (que trabajen sobre objetos diferentes) tendríamos que crear su interfaz junto con su implementación. Para reducir esta redundancia en el código se puede recurrir al uso de clases genéricas en la definición de la interfaz principal, que definirá todas los métodos comunes. Si las implementaciones necesitan métodos particulares para cada tipo de objetos se pueden mantener las interfaces extendiendo cada una de la clase que tiene la definición de todos los métodos comunes.

#### Inyección de dependencias
El objetivo es que se suministren objetos a una clase en lugar de ser la propia clase la que se crea los objetos. Es utilizado en el framework Spring.

Este patrón se puede implementar a través de un método setter o a través de un constructor. Se creará una clase que reciba como parámetro un objeto, que lo utilizará para iniciar una variable de tipo privada de ese objeto. Podemos dinamizar y desacoplar el código utilizando en el parámetro una interfaz definida que contenga todos los métodos comunes a todas las implementaciones que necesitemos. De tal forma que el cliente hará una instancia de una de las implementaciones y se la pasará a la clase a través del constructor. La clase por tanto no ese la encargada de realizar la nueva instancia, si no que la recibe por parámetro del constructor.

#### MVC (Modelo Vista Controlador)
El objetivo es separar según el contexto. La capa modelo contendrá todo lo que tiene que ver con las clase POJO. La capa de vista se mostrará lo que el cliente va a visualizar, utilizando los datos que contiene la capa del modelo. La capa controlador actuará como intermediario para tener separada la vista y el modelo. El patrón favorece la escalabilidad y que los proyectos sean fácilmente sostenibles.

Lo primero que hay que aclarar es que no es necesario dividir la estructura de paquetes en 3, aunque es fundamental que la nomenclatura de los paquetes sea clara y concisa para cada capa del patrón. Es habitual tener un paquete "model" que por supuesto pertenece a la capa modelo, aunque hay más paquetes que pueden pertenecer a la capa de modelo, como por ejemplo "dao" (para implementaciones de patrón dao) "dao.logic" para encapsular lógica de negocio o validaciones previas al acceso a datos. Para la capa controlador se suele utilizar el paquete "controller" y para la vista depende de si el proyecto es web o de escritorio. Si es web la parte de la vista estará dentro de la carpeta webapp.

## Antipatrones
Los antipatrones son prácticas que están totalmente desaconsejadas. Los podemos dividir de la siguiente manera:

#### Anti patrones de codificación

- Flujo de Lava: programar al estilo volcán, construir grandes cantidades de código de forma desordenada y con poca documentación y poca claridad. Cuanto más crece más porciones de código se hacen difícil de mantener.
- God: programa omnipresente, una sola clase o módulo hace todo.
- Varita mágica: vicio relacionado con aferrarse a un paradigma para el desarrollo de ciertos algoritmos. Por ejemplo la sucesión de Fibonacci tiene mejor implementación en lenguajes puramente científicos que en Java por ejemplo.
- Código spaghetti: código mal estructurado en el que mueves una línea y se va todo al garete.
- Fantasmas: clases, módulos o métodos declaradas que no se utilizan.

#### Anti patrones de arquitectura
A nivel de arquitectura podemos tener los siguientes:

- Reinventar la rueda: obsesión para crear un framework propio para implementar patrones de diseño cuando en el mercado ya hay alternativas que hacen esa labor.
- Casarse con el diablo: crear un software que esté fuertemente relacionado con una marca/solución.
- Cocinando en caliente: cada miembro del equipo de desarrollo modulariza una funcionalidad pero cada parte no se relaciona fácilmente con las demás con lo que nos queda un código tipo Frankestein.
- Referencias: En la siguiente página están todos los diagramas UML y cada patrón definido de forma detallada: https://sourcemaking.com/design_patterns

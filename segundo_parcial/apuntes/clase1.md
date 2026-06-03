# Introduccion

## principios de poo

los principios de poo son:

- Abstracción: Es el proceso de ocultar los detalles de implementación y mostrar solo la funcionalidad esencial de un objeto. Permite a los desarrolladores centrarse en lo que hace un objeto en lugar de cómo lo hace.
- Encapsulamiento: Es el proceso de agrupar datos y métodos que operan sobre esos datos dentro de una unidad llamada clase. Esto ayuda a proteger los datos de acceso no autorizado y a mantener la integridad del objeto.
- Herencia: Es el mecanismo por el cual una nueva clase (subclase) puede heredar las propiedades y comportamientos de una clase existente (superclase). Esto promueve la reutilización del código y la creación de jerarquías de clases.
- Polimorfismo: Es la capacidad de un objeto de tomar muchas formas. Permite que una función o método pueda operar en objetos de diferentes clases, siempre y cuando compartan una interfaz común. Esto facilita la extensibilidad y la flexibilidad del código.

## que son principios solid

Los principios SOLID son un conjunto de cinco principios de diseño de software que ayudan a los desarrolladores a crear sistemas más mantenibles, flexibles y escalables. Los principios SOLID son:

- Single Responsibility Principle (SRP): Una clase debe tener una sola responsabilidad o razón para cambiar. Esto significa que una clase debe tener una única función o propósito.
- Open/Closed Principle (OCP): Las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas para la extensión pero cerradas para la modificación. Esto significa que se debe poder agregar nueva funcionalidad sin modificar el código existente.
- Liskov Substitution Principle (LSP): Los objetos de una clase derivada deben ser sustituibles por objetos de la clase base sin alterar el correcto funcionamiento del programa. Esto significa que las subclases deben ser capaces de reemplazar a sus superclases sin causar errores o comportamientos inesperados.
- Interface Segregation Principle (ISP): Los clientes no deben verse obligados a depender de interfaces que no utilizan. Esto significa que es mejor tener varias interfaces específicas en lugar de una interfaz general que abarque muchas funcionalidades.
- Dependency Inversion Principle (DIP): Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones. Las abstracciones no deben depender de detalles. Los detalles deben depender de abstracciones. Esto significa que el código debe depender de interfaces o clases abstractas en lugar de implementaciones concretas.

## que son transacciones acid

Las transacciones ACID son un conjunto de propiedades que garantizan que las transacciones en una base de datos se realicen de manera confiable. ACID es un acrónimo que representa Atomicidad, Consistencia, Aislamiento y Durabilidad. Estas propiedades son fundamentales para asegurar la integridad de los datos y la confiabilidad de las operaciones en una base de datos.

- Atomicidad: Garantiza que una transacción se ejecute completamente o no se ejecute en absoluto. Si alguna parte de la transacción falla, toda la transacción se revierte a su estado original, asegurando que los datos no queden en un estado inconsistente.
- Consistencia: Asegura que una transacción lleve a la base de datos de un estado válido a otro estado válido. Esto significa que cualquier transacción debe cumplir con todas las reglas y restricciones definidas en la base de datos, como claves primarias, claves foráneas, y otras restricciones de integridad.
- Aislamiento: Garantiza que las transacciones concurrentes se ejecuten de manera aislada entre sí. Esto significa que los cambios realizados por una transacción no serán visibles para otras transacciones hasta que la transacción se haya completado. Esto ayuda a prevenir problemas como la lectura sucia, la lectura no repetible y la phantom read.
- Durabilidad: Asegura que una vez que una transacción se ha completado con éxito, sus cambios se guardarán de manera permanente en la base de datos, incluso en caso de fallos del sistema o cortes de energía. Esto significa que los datos no se perderán una vez que la transacción haya sido confirmada (committed).


# Principios SOLID
los principios SOLID son uno de los fundamentos mas importantes en la arquitectura y desarrollo de software.
- Son principios basicos aplicables al diseño de componentes.
- SOn fundamentales en la ingenieria de software orientada a objetos.
- Su proposito es facilitar los cambios en las aplicaciones
- Tambien busca minimizar los efectos colaterales de los cambios. Por ejemplo refactorizar codigo
- Sirven como guia en el desarrollo de cada componente de software.

- Principio de Responsabilidad Unica (SRP): Cada clase debe tener una unica responsabilidad. Esto ayuda a mantener el codigo limpio y facil de mantener, y facilita la reutilizacion de codigo.
- Principio de Abierto/Cerrado (OCP): Las entidades de software deben estar abiertas para la extension pero cerradas para la modificacion. Esto significa que se debe poder agregar nueva funcionalidad sin modificar el codigo existente, lo que ayuda a prevenir errores y a mantener la estabilidad del sistema.
- Principio de Sustitucion de Liskov (LSP): Los objetos de una clase derivada deben ser sustituibles por objetos de la clase base sin alterar el correcto funcionamiento del programa. Esto significa que las subclases deben ser capaces de reemplazar a sus superclases sin causar errores o comportamientos inesperados, lo que promueve la reutilización y la flexibilidad del código.
- Principio de Segregacion de Interfaces (ISP): Los clientes no deben verse obligados a depender de interfaces que no utilizan. Esto significa que es mejor tener varias interfaces específicas en lugar de una interfaz general que abarque muchas funcionalidades, lo que ayuda a mantener el código más limpio y fácil de entender.
- Principio de Inversion de Dependencias (DIP): Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones. Las abstracciones no deben depender de detalles. Los detalles deben depender de abstracciones. Esto significa que el código debe depender de interfaces o clases abstractas en lugar de implementaciones concretas, lo que facilita la flexibilidad y la mantenibilidad del código.

# Principio de Responsabilidad Unica (SRP)
- Cada clase debe tener una unica responsabilidad
- Ayuda a mantener el codigo limpio y facil de mantener
- Facilita la reutilizacion de codigo
- Permite que los cambios en una parte del sistema no afecten a otras partes, lo que mejora la estabilidad y la escalabilidad del software.
- Facilita la comprensión del código, ya que cada clase tiene un propósito claro y específico.

## Ejemplo de falta de implemetacion del SRP
Una clase UserManager que hace TODO: crea usuarios, los guarda en BD, valida y genera respuestas JSON:

# Principio de Abierto/Cerrado (OCP)    
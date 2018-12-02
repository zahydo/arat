# Architectural Rationale Annotations Tool

ARAT (Architectural Rationale Annotations Tool) es una herramienta que complementa el código fuente basada en anotaciones de código Java que permiten documentar el Rationale arquitectónico.

## Introducción y propósito
El Rationale arquitectónico son las razones del porqué una arquitectura está planteada de una forma o de otra, este Rationale arquitectónico define la justificación o el porqué de una acción o un pensamiento dirigido a la toma de decisiones en la construcción de la arquitectura de un sistema. Generalmente este Rationale no se encuentra de manera explícita en los diferentes artefactos de la documentación de un sistema, causando que sea mucho más lenta la fase de mantenimiento del mismo, debido a que se requiere de más tiempo para tratar de capturar y analizar las decisiones tomadas en el diseño del software.

Las anotaciones de código fuente sirven como un puente entre el desarrollador y las
diferentes herramientas y librerías que son capaces de reconocerlas, gestionarlas y brindar una mayor cantidad de servicios a través de los metadatos marcados con información relevante para el desarrollo. El uso de estas anotaciones es importante ya que tienen como objetivo construir sistemas más complejos, que permitan encapsular lógica de programación repetitiva en componentes aparte de las reglas de negocio de un sistema en particular, precisamente una de las mayores ventajas de las anotaciones de código fuente es permitir al desarrollador crear diferentes elementos lógicos encargados de capturar y procesar dichas anotaciones con los metadatos de los componentes marcados, con el objetivo de delegarle a las anotaciones de código la responsabilidad de realizar procesos comunes y repetitivos en toda la aplicación

## Fundamentos
La documentación del Rationale arquitectónico está caraceterisada por una paradoja que comunmente persiste en el desarrollo de software:
>Cuanto más Rationale se genera, hay menos posibilidades de capturarlo.

Esta paradoja está sustentada por las siguientes observaciones manifestadas por [Allen Dutoit. et al](https://link.springer.com/chapter/10.1007%2F978-3-540-30998-7_1):
  - El Rationale se crea cuando se toma una decisión.
  - Durante el proceso de toma de decisiones los participantes son muy activos.
  - El Rationale se considera importante y evidente en el momento en el que se crea. Sin embargo, con el paso del tiempo este generalmente suele ser olvidado.
  - Generalmente las decisiones futuras están basadas en decisiones antiguas, provocando que las decisiones se sobre escriban en el desarrollo del proyecto.
  - Existe la necesidad de que se exprese el conocimiento tácito involucrado en el desarrollo de las actividades por parte de los participantes, sin embargo, interrumpir el flujo de actividades frecuentemente provoca la pérdida de motivación y puede ralentizar el trabajo. Por ello los participantes deciden enfocarse en las actividades "principales" y posponer la documentación del Rationale.

## Instalación
En el siguiente [link](https://github.com/zahydo/arat-V1.0) encontrará información relacionada con el proyecto, el código fuente, algunas características de la herramienta, el manual de usuario y la herramienta en formato .jar. 
Descargue el [plugin .jar](https://drive.google.com/open?id=1wQX3y1WgvNLhs5reRQY8NaT0wuIrdMjz) y guárdelo en un lugar en el que recuerde su ubicación. Para completar la instalación por favor consulte el [Manual de usuario](https://github.com/zahydo/arat-V1.0/blob/master/files/Manual%20de%20usuario.pdf).
Una vez se haya instalado el plugin se debe instanciar una clase con un método **main**, la cual puede generar el reporte mediante la clase *RationaleFacade* 
```sh
RationaleFacade.generateReportByAll(package)
```
Para generar un archivo con el reporte de todas las anotaciones marcadas en el código fuente dentro del **package** especificado.

```sh
RationaleFacade.generateReportsByOne(package)
```
Para generar un archivo por cada anotación marcada en el código fuente dentro del **package** especificado.

## Sobre el proyecto 
Este documento es un artefacto generado en la investigación del uso de las anotaciones de
código como una herramienta para gestionar conocimiento tácito directamente en el
código fuente, estableciendo un modelo de Rationale Arquitectónico que permita el
registro y la gestión de decisiones y razones arquitectónicas, importantes para la evolución y el correcto mantenimiento de cualquier sistema.
La documentación completa de este proyecto y la investigación se encuentra en el
siguiente repositorio de github. En este repositorio también se encuentra el link a un sitio web en el cual se puede descargar la herramienta.
Para las personas interesadas en continuar con el proyecto o realizar contribuciones
pueden solicitar acceso al repositorio contactando al [autor](http://artemisa.unicauca.edu.co/~santiagodorado/).

Licencia
----

Apache License 2.0

### Uso permitido
- Uso comercial  
- Modificación
- Distribución
- Uso de patente
- Uso privado

### Limitaciones
- Uso de marca registrada
- Responsabilidad
- Garantía

### Condiciones
- Licencia y aviso de copyright
- Cambios de estado

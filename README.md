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

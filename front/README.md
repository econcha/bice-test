# BiceIndicators

Proyecto realizado con `Angular 8, typescript`

## Development server

Correr `ng serve --open` para levantar servidor. Se levantará por defecto en `http://localhost:4200/`. El app se actualizarà automáticamente contra cada cambio realizado una vez levantado.

## Build

Correr `ng build` para buildear aplicacion. El comando generará una carpeta /dist en el root actual, el cual será el empaquetado que se debe subir al servidor web.

## Arquitectura.

La aplicación tiene carga de modulos lazy loading. Siendo el mòdulo `Landing` el mòdulo de la aplicacion.

Modulos:
 -- Landing : módulo de la aplicacion. Este modulo consta la vistas de   `home` y  `indicators`.
 -- Shared  : modulo compartido . En este módulo estaràn todos los componentes reutilizables en la aplicacion.
 -- Core    : módulo compartido . En este módulo estaràn todos los servicios, pipes, constants, interceptors utilizados en la aplicacion.

La aplicacion utiliza dos API Backend : 
   - `http://localhost:8096/bice-indicators/last`  --> Detalle actualizado de los indicadores
   - `http://localhost:8096/bice-indicators/{indicator}/detail` --> detalle de un indicador y su variaciòn en el tiempo.
   
## Running unit tests

Correr `ng test` para ejecutar test vìa [Karma](https://karma-runner.github.io).


## Further help


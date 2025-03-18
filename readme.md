# Gilded Rose Refactorización

Este proyecto contiene una solución refactorizada para el kata clásico de programación "Gilded Rose", aplicando patrones de diseño y principios SOLID para mejorar la calidad del código.

## 🌟 Descripción

Gilded Rose es una tienda de ítems mágicos con reglas específicas para la actualización de la calidad de su inventario:

- Todos los ítems tienen un valor de `SellIn` que indica los días para venderlos
- Todos los ítems tienen un valor de `Quality` que indica su valor
- Al final de cada día, el sistema reduce ambos valores
- Cuando la fecha de venta ha pasado, la `Quality` se degrada el doble de rápido
- La `Quality` nunca es negativa
- "Aged Brie" aumenta su `Quality` con el tiempo
- La `Quality` nunca es mayor a 50
- "Sulfuras" nunca cambia ni debe venderse
- "Backstage passes" aumentan su `Quality` al acercarse la fecha del concierto:
  - Aumenta en 2 cuando quedan 10 días o menos
  - Aumenta en 3 cuando quedan 5 días o menos
  - Cae a 0 después del concierto
- Los ítems "Conjured" degradan su `Quality` el doble de rápido

## 🛠️ Patrón de Diseño Implementado

Se han utilizado dos patrones de diseño principales:

### Patrón Strategy

- Permite definir una familia de algoritmos, encapsularlos y hacerlos intercambiables
- Cada tipo de ítem tiene su propia estrategia de actualización
- Elimina los condicionales anidados del código original

### Patrón Factory

- Centraliza la creación de las estrategias según el tipo de ítem
- Facilita la extensión para nuevos tipos de ítems en el futuro

## 🔍 Principios SOLID Aplicados

La refactorización aplica los principios SOLID:

- **S** - Principio de Responsabilidad Única: Cada clase tiene una única razón para cambiar
- **O** - Principio Abierto/Cerrado: El código está abierto para extensión pero cerrado para modificación
- **L** - Principio de Sustitución de Liskov: Todas las estrategias pueden usarse de manera intercambiable
- **I** - Principio de Segregación de Interfaces: La interfaz contiene solo los métodos necesarios
- **D** - Principio de Inversión de Dependencias: La clase principal depende de abstracciones, no implementaciones

## 🧹 Code Smells Eliminados

La refactorización ha eliminado varios "code smells":

- **Condicionales Anidados Complejos**: Reemplazados por el patrón Strategy
- **Código Duplicado**: Métodos comunes extraídos como métodos por defecto en la interfaz
- **Método Largo**: Dividido en métodos más pequeños con responsabilidades claras
- **Acoplamiento Temporal**: Cada estrategia encapsula la secuencia correcta de operaciones
- **Large Class**: La responsabilidad se distribuye entre varias clases de estrategia

## 📂 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com/
│           └── gildedrose/
│               ├── GildedRose.java            // Clase principal refactorizada
│               ├── Item.java                  // Clase Item original (sin modificar)
│               └── strategy/
│                   ├── ItemUpdateStrategy.java       // Interfaz para todas las estrategias
│                   ├── ItemUpdateStrategyFactory.java // Factory para crear estrategias
│                   ├── StandardItemStrategy.java     // Estrategia para ítems normales
│                   ├── AgedBrieStrategy.java         // Estrategia para Aged Brie
│                   ├── BackstagePassStrategy.java    // Estrategia para Backstage passes
│                   ├── SulfurasStrategy.java         // Estrategia para Sulfuras
│                   └── ConjuredItemStrategy.java     // Estrategia para ítems conjurados
└── test/
    └── java/
        └── com/
            └── gildedrose/
                └── GildedRoseTest.java        // Pruebas unitarias
```

## ✅ Pruebas

Las pruebas unitarias comprueban todos los casos de uso:

- Degradación normal de ítems estándar
- Incremento de calidad para "Aged Brie"
- Comportamiento de "Sulfuras"
- Incremento y caída a 0 de "Backstage passes"
- Degradación doble para "Conjured Items"
- Límites de calidad (0-50)

## 🌱 Extensibilidad

Para añadir un nuevo tipo de ítem:

1. Crear una nueva clase que implemente `ItemUpdateStrategy`
2. Añadir la condición correspondiente en `ItemUpdateStrategyFactory`


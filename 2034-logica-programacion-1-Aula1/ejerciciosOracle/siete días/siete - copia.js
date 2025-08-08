// Datos de ejemplo
const datos = [
    { metaProgramada: 100, metaModificada: null, metaAlcanzada: 90 },
    { metaProgramada: null, metaModificada: 120, metaAlcanzada: 125 },
    { metaProgramada: 80, metaModificada: 90, metaAlcanzada: 85 },
    { metaProgramada: null, metaModificada: null, metaAlcanzada: 50 }
  ];
  
  // Función para analizar los datos
  function analizarMetas(datos) {
    return datos.map((fila, index) => {
      const meta = fila.metaProgramada ?? fila.metaModificada;
  
      if (meta === null || meta === undefined) {
        return {
          fila: index + 1,
          estado: "Sin meta válida",
          resultado: null
        };
      }
  
      const alcanzada = fila.metaAlcanzada >= meta;
  
      return {
        fila: index + 1,
        metaEsperada: meta,
        metaAlcanzada: fila.metaAlcanzada,
        cumplida: alcanzada
      };
    });
  }
  
  // Ejecutar análisis y mostrar resultados
  const resultados = analizarMetas(datos);
  console.log(resultados);
  
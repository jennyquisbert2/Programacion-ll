import math

class AlgebraVectorial:
    def __init__(self, *args):
        # Sobrecarga de constructor
        if len(args) == 1 and isinstance(args[0], (list, tuple)):
            self.comp = [float(x) for x in args[0]]
        else:
            self.comp = [float(x) for x in args]

    # --- Métodos Auxiliares ---
    def modulo(self):
        return math.sqrt(sum(x**2 for x in self.comp))

    def producto_punto(self, v):
        return sum(a * b for a, b in zip(self.comp, v.comp))

    def restar(self, v):
        return AlgebraVectorial([a - b for a, b in zip(self.comp, v.comp)])

    def sumar(self, v):
        return AlgebraVectorial([a + b for a, b in zip(self.comp, v.comp)])

    # --- (1) y (2) Perpendicularidad y Paralelismo con Sobrecarga ---
    
    def perpendicular(self, v, criterio="c"):
        """
        Simulación de sobrecarga para los criterios a, b, c, d de la imagen.
        """
        if criterio == "a": # |a + b| = |a - b|
            return math.isclose(self.sumar(v).modulo(), self.restar(v).modulo())
        
        elif criterio == "b": # |a - b| = |b - a| (Propiedad general)
            return math.isclose(self.restar(v).modulo(), v.restar(self).modulo())
        
        elif criterio == "c": # a · b = 0
            return math.isclose(self.producto_punto(v), 0, abs_tol=1e-9)
        
        elif criterio == "d": # |a + b|^2 = |a|^2 + |b|^2
            izq = self.sumar(v).modulo()**2
            der = self.modulo()**2 + v.modulo()**2
            return math.isclose(izq, der)

    def paralela(self, v, criterio="f"):
        """
        Simulación de sobrecarga para los criterios e, f de la imagen.
        """
        if criterio == "e": # a = r * b (proporcionalidad)
            proporciones = [a/b if b != 0 else 0 for a, b in zip(self.comp, v.comp)]
            return all(math.isclose(p, proporciones[0]) for p in proporciones)
        
        elif criterio == "f": # a x b = 0 (Solo para 3D)
            if len(self.comp) == 3 and len(v.comp) == 3:
                a, b, c = self.comp
                x, y, z = v.comp
                cross = [b*z - c*y, c*x - a*z, a*y - b*x]
                return all(math.isclose(i, 0, abs_tol=1e-9) for i in cross)
            return "Cross product solo definido para 3D"

    # --- (3) Proyección (g) ---
    def proyeccion_de_a_sobre_b(self, b):
        escalar = self.producto_punto(b) / (b.modulo()**2)
        return [escalar * componente for componente in b.comp]

    # --- (4) Componente (h) ---
    def componente_de_a_en_b(self, b):
        return self.producto_punto(b) / b.modulo()

    def __str__(self):
        return f"Vector{tuple(self.comp)}"

# ---------------------------------
a = AlgebraVectorial(3, 0, 0)
b = AlgebraVectorial(0, 3, 0)

print(f"Vector A: {a} | Vector B: {b}")
print(f"¿Son perpendiculares (Criterio C: Punto)? {a.perpendicular(b, 'c')}")
print(f"¿Son perpendiculares (Criterio D: Pitágoras)? {a.perpendicular(b, 'd')}")
print(f"Componente de A en B: {a.componente_de_a_en_b(b)}")
print(f"Proyección de A sobre B: {a.proyeccion_de_a_sobre_b(b)}")
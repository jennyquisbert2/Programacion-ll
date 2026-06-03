import math

class Vector3D:
    def __init__(self, a1, a2, a3):
        self.a1 = float(a1)
        self.a2 = float(a2)
        self.a3 = float(a3)

    # a) Sobrecarga de suma (+)
    def __add__(self, otro):
        return Vector3D(self.a1 + otro.a1, self.a2 + otro.a2, self.a3 + otro.a3)

    # Sobrecarga de resta (-) necesaria para la lógica de perpendicularidad
    def __sub__(self, otro):
        return Vector3D(self.a1 - otro.a1, self.a2 - otro.a2, self.a3 - otro.a3)

    # b) Sobrecarga de multiplicación por escalar (*)
    def __mul__(self, r):
        if isinstance(r, (int, float)):
            return Vector3D(r * self.a1, r * self.a2, r * self.a3)
        raise ValueError("La multiplicación debe ser por un número escalar.")

    # c) Longitud o Magnitud (usando abs())
    def __abs__(self):
        return math.sqrt(self.a1**2 + self.a2**2 + self.a3**2)

    # d) Normal del vector
    def normal(self):
        mag = abs(self)
        if mag == 0: return Vector3D(0, 0, 0)
        return Vector3D(self.a1 / mag, self.a2 / mag, self.a3 / mag)

    # e) Producto escalar (punto)
    def punto(self, otro):
        return (self.a1 * otro.a1) + (self.a2 * otro.a2) + (self.a3 * otro.a3)

    # f) Producto vectorial (cruz)
    def cruz(self, b):
        rx = self.a2 * b.a3 - self.a3 * b.a2
        ry = self.a3 * b.a1 - self.a1 * b.a3
        rz = self.a1 * b.a2 - self.a2 * b.a1
        return Vector3D(rx, ry, rz)

    # Figura 1: Perpendicularidad por diagonales
    def es_perpendicular(self, otro):
        # |a + b| == |a - b|
        diagonal_suma = abs(self + otro)
        diagonal_resta = abs(self - otro)
        return math.isclose(diagonal_suma, diagonal_resta)

    # Figura 2: Proyección de 'a' sobre 'b'
    def proyeccion_sobre(self, b):
        # Formula: ( (a·b) / |b|² ) * b
        denominador = abs(b)**2
        if denominador == 0: return Vector3D(0,0,0)
        escalar = self.punto(b) / denominador
        return b * escalar

    def __str__(self):
        return f"({self.a1}, {self.a2}, {self.a3})"

# -----------------------------------------------
if __name__ == "__main__":
    v1 = Vector3D(3, 0, 0)
    v2 = Vector3D(0, 4, 0)

    print(f"Vector A: {v1}")
    print(f"Vector B: {v2}")
    print(f"Suma (A+B): {v1 + v2}")
    print(f"Magnitud de A: {abs(v1)}")
    print(f"Producto Punto: {v1.punto(v2)}")
    print(f"¿Son perpendiculares?: {v1.es_perpendicular(v2)}")
    
    v3 = Vector3D(1, 2, 3)
    print(f"Proyección de {v3} sobre eje X {v1}: {v3.proyeccion_sobre(v1)}")
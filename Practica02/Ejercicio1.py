import math

class MiPunto:
    # b) y c)
    def __init__(self, x=0.0, y=0.0):
        self.__x = x
        self.__y = y

    # a)
    def get_x(self):
        return self.__x

    def get_y(self):
        return self.__y

    # --- 
    def __str__(self):
        return f"Punto({self.__x}, {self.__y})"

    # d) y e)
    def distancia(self, *args):
        # Caso d: Se recibe un objeto de tipo MiPunto
        if len(args) == 1 and isinstance(args[0], MiPunto):
            punto2 = args[0]
            dx = self.__x - punto2.get_x()
            dy = self.__y - punto2.get_y()
            
        # Caso e: Se reciben coordenadas x e y por separado
        elif len(args) == 2:
            x2, y2 = args
            dx = self.__x - x2
            dy = self.__y - y2
        
        else:
            raise ValueError("Uso: distancia(otro_punto) o distancia(x, y)")

        return math.sqrt(dx**2 + dy**2)
    
    #2.1
    def determinar_cuadrante(self, x, y):
        if self.__x>0 and self.__y>0:
            return "cuadrante1 +X,+Y"
        elif self.__x>0 and self.__y<0:
             return "cuadrante2 +X,-Y"
        elif self.__x<0 and self.__y<0:
             return "cuadrante3 -X,-Y"
        elif self.__x<0 and self.__y>0:
             return "cuadrante4 -X,+Y"

if __name__ == "__main__":
    punto_a = MiPunto(1, 2)          
    punto_b = MiPunto(3, 2)   
    
    print(f"Punto A: {punto_a}")
    print(f"Punto B: {punto_b}")
    
    dist = punto_a.distancia(punto_b)
    
    print("-" * 30)
    print(f"La distancia entre ambos es: {dist:.2f}")

    print(f"resultado: {punto_a.determinar_cuadrante(punto_b)}")


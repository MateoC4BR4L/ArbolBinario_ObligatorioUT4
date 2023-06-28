import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArbolTest
{
    private Arbol<Integer> arbol;
    public void Inicio()
    {
        arbol = new Arbol<>();
    }

    @Test
    void esArbolBB()
    {
        Inicio();

        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);

        assertTrue(arbol.esArbolBB());
    }

    @Test
    void menorClave()
    {
        Inicio();

        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);

        assertEquals(arbol.menorClave(), (Integer) 1);
    }

    @Test
    void mayorClave()
    {
        Inicio();

        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);

        assertEquals(arbol.mayorClave(), (Integer) 20);
    }

    @Test
    void claveAnterior()
    {
        Inicio();

        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);

        assertAll(
                () -> assertEquals(arbol.claveAnterior(1), (Integer) 4),
                () -> assertEquals(arbol.claveAnterior(11), (Integer) 4),
                () -> assertNull(arbol.claveAnterior(4)),
                () -> assertEquals(arbol.claveAnterior(6), (Integer) 11),
                () -> assertEquals(arbol.claveAnterior(20), (Integer) 11)
        );
    }

    @Test
    void nodos_por_Nivel()
    {
        Inicio();

        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);

        assertAll(
                () -> assertEquals(arbol.nodos_por_Nivel(0), (Integer) 1),
                () -> assertEquals(arbol.nodos_por_Nivel(1), (Integer) 2),
                () -> assertEquals(arbol.nodos_por_Nivel(2), (Integer) 2)
        );

    }

    @Test
    void hojas()
    {
        Inicio();

        // Las hojas de este arbol son: 1, 6, 20
        arbol.insertar(4);
        arbol.insertar(1);
        arbol.insertar(11);
        arbol.insertar(20);
        arbol.insertar(6);
        Map<Nodo<Integer>, Integer> nodosHojas= arbol.hojas();

        /* Asserts para verificar si devuelve la altura correcta de las hojas
        *  Utilizamos el comando buscar para obtener los nodos hojas
        */
        assertAll(
                () -> assertEquals(nodosHojas.get(arbol.buscar(1)), 1),
                () -> assertEquals(nodosHojas.get(arbol.buscar(6)), 2),
                () -> assertEquals(nodosHojas.get(arbol.buscar(20)), 2)
        );

    }
}
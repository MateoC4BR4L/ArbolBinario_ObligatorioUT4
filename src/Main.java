import java.util.ArrayDeque;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        Arbol<Integer> a1 = new Arbol<Integer>();
        a1.insertar(13);
        a1.insertar(10);
        a1.insertar(18);
        a1.insertar(11);
        a1.insertar(9);
        a1.insertar(3);
        a1.insertar(1);
        a1.insertar(-45);

        System.out.println(a1.menorClave());
        System.out.println(a1.mayorClave());
        System.out.println(a1.claveAnterior(-45));

        System.out.println("Impresión INORDEN:");
        a1.inorden();
        System.out.println("Impresión POSTORDEN:");
        a1.postorden();
        System.out.println("Impresión PREORDEN:");
        a1.preorden();


        System.out.println("Si el arbol es de busqueda tira true, de lo contrario tira false:");
        System.out.println(a1.esArbolBB());
        
        System.out.println("Nodos por nivel: ");
        System.out.println(a1.nodos_por_Nivel(2));

    }
}
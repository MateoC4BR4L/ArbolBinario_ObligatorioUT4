
public class Main
{
    public static void main(String[] args)
    {
        Arbol<Integer> a1 = new Arbol<Integer>();
        a1.insertar(13);
        a1.insertar(4);
        a1.insertar(18);
        a1.insertar(67);
        a1.insertar(10000000);
        a1.insertar(3);
        a1.insertar(1);
        a1.insertar(-45);

        System.out.println(a1.menorClave());
        System.out.println(a1.mayorClave());
    }
}

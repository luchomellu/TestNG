package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import restaurant.Ingrediente;

import java.util.Random;

public class IngredienteTest{

    @DataProvider(name="generarIngredientes")
    public Object[][]generarIngredientes(){
        return new Object[][]{
                {new Ingrediente("chile","gr",1,200)},
                {new Ingrediente("tortilla","gr",1,150)},
                {new Ingrediente("guacamole","gr",1,10)},
                {new Ingrediente("cebolla","kg",1,50)},
                {new Ingrediente("morron","gr",1,5)},
                {new Ingrediente("apio","gr",1,200)},
                {new Ingrediente("zanahoria","gr",1,200)},
                {new Ingrediente("pollo","gr",1,200)},
                {new Ingrediente("aceite","gr",1,200)},
                {new Ingrediente("sal","gr",1,200)},
        };
    }

    public boolean excede10Caracteres(String nombre){
        if(nombre.length() > 10)
            return true;
        else
            return false;
    }



  @Test (dataProvider = "generarIngredientes")
    public void nombreIngredienteMaxCaracterAll(Ingrediente i) throws Exception{
        String nombre_test = i.getNombre();
        System.out.println(nombre_test);
        Assert.assertFalse(excede10Caracteres(nombre_test));
    }

    @Test
    public void nombreIngredienteMaxCaracterAleatorio() {
        // Obtén una referencia al DataProvider "generarIngredientes"
        Object[][] ingredientes = generarIngredientes();

        // Genera un índice aleatorio
        Random random = new Random();
        int indiceAleatorio = random.nextInt(ingredientes.length);

        // Obtén el Ingrediente aleatorio
        Ingrediente ingredienteAleatorio = (Ingrediente) ingredientes[indiceAleatorio][0];

        // Ejecuta la prueba con el ingrediente aleatorio
        String nombre_test = ingredienteAleatorio.getNombre();
        System.out.println(nombre_test);
        Assert.assertFalse(excede10Caracteres(nombre_test));
    }
    @Parameters({"nombre","medida","stock","precioCompra"})
    @Test
    public void crearIngredienteSatisfactoriamente(String nombre, String medida, int stock, float precioCompra){
        Assert.assertNotNull(new Ingrediente(nombre,medida,stock,precioCompra));
    }
}

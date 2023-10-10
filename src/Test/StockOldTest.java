package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restaurant.*;

public class StockOldTest {
    private ProductoBasico productoBasico;

    @BeforeTest
    public void setTestStock(){
        //StockOld stockOldATestear = new StockOld();
        StockOld.InitStock();
        this.productoBasico = new ProductoBasico("papa fritas",200,400);
        StockOld.AgregarStock(productoBasico,5);
    }

    @Test
    public void checkStockMinimo()  {
        Assert.assertThrows(SinSuficientesIngredientesException.class,() -> StockOld.consumirIngredientes(this.productoBasico,6));
    }

}

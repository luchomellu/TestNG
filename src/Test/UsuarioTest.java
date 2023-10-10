package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import restaurant.SinSaldoException;
import restaurant.Usuario;

public class UsuarioTest {

    private Usuario usuario;
    @BeforeTest
    public void setTestSaldoUsuario(){
        this.usuario = new Usuario("pepe el mas cra",1,200,"elpepon@yahoo.com");
    }

    @Test
    public void testDescontarSaldoUsuario(){
        Assert.assertThrows(SinSaldoException.class,()->this.usuario.descontarSaldo(201));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import eventools.TelaCadastroController;

/**
 *
 * @author Bernardo
 */
public class TelaCadastroControllerTest {
    TelaCadastroController n;
    
    public TelaCadastroControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        n = new TelaCadastroController();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class TelaCadastroController.
     */
    @Test
    public void testInitialize() {
    }

    /**
     * Test of cancelarCadastro method, of class TelaCadastroController.
     */
    @Test
    public void testCancelarCadastro() throws Exception {
    }

    /**
     * Test of finalizarCadastro method, of class TelaCadastroController.
     */
    @Test
    public void testFinalizarCadastro() throws Exception {
    }

    /**
     * Test of validarCpf method, of class TelaCadastroController.
     */
    @Test
    public void testValidarCpf() {
        assertTrue(n.validarCpf("12312312311"));
    }

    /**
     * Test of validarSenha method, of class TelaCadastroController.
     */
    @Test
    public void testValidarSenha() {
        assertTrue(n.validarSenha("12345678", "12345678"));
    }

    /**
     * Test of validarTelefone method, of class TelaCadastroController.
     */
    @Test
    public void testValidarTelefone() {
        assertTrue(n.validarTelefone("34245252"));
    }

    /**
     * Test of validarEmail method, of class TelaCadastroController.
     */
    @Test
    public void testValidarEmail() {
        assertTrue(n.validarEmail("abc@abc.com"));
    }

    /**
     * Test of validarNome method, of class TelaCadastroController.
     */
    @Test
    public void testValidarNome() {
        assertTrue(n.validarNome("AbC da silva"));
    }
    
}

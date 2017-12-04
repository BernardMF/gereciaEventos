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

/**
 *
 * @author Bernardo
 */
public class TelaNovoProdutoControllerTest {
    TelaNovoProdutoController p;
    public TelaNovoProdutoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new TelaNovoProdutoController();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class TelaNovoProdutoController.
     */
    @Test
    public void testInitialize() {
    }

    /**
     * Test of acaoCancelar method, of class TelaNovoProdutoController.
     */
    @Test
    public void testAcaoCancelar() throws Exception {
    }

    /**
     * Test of acaoCompletarCadastro method, of class TelaNovoProdutoController.
     */
    @Test
    public void testAcaoCompletarCadastro() throws Exception {
    }

    /**
     * Test of verificarNome method, of class TelaNovoProdutoController.
     */
    @Test
    public void testVerificarNome() {
        assertTrue(p.verificarNome("abc"));//testa nome do produto
    }

    /**
     * Test of verificarPreco method, of class TelaNovoProdutoController.
     */
    @Test
    public void testVerificarPreco() {
        assertTrue(p.verificarPreco("1,30"));//testa preco do produto
    }

    /**
     * Test of verificarDescricao method, of class TelaNovoProdutoController.
     */
    @Test
    public void testVerificarDescricao() {
        assertTrue(p.verificarDescricao("abc efgh"));
    }

    /**
     * Test of funcaoNaoImplementada method, of class TelaNovoProdutoController.
     */
    @Test
    public void testFuncaoNaoImplementada() {
    }
    
}

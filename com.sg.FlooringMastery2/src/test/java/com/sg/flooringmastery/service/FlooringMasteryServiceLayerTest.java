/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryDaoStubImpl;
import com.sg.flooringmastery.dao.FlooringMasteryFileNotFoundException;
import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryServiceLayerTest {
    private static final double DELTA = 1e-15;
    private FlooringMasteryServiceLayer service;
    
    public FlooringMasteryServiceLayerTest() {
        FlooringMasteryDao dao = new FlooringMasteryDaoStubImpl();
        service = new FlooringMasteryServiceLayerImpl(dao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        //"1::CustomerName::OH::6.25::Carpet::100.0::2.1::2.25::210.0::225.0::13.27::225.52::"
    }

    /**
     * Test of saveOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testSaveOrders() throws Exception {
    }

    /**
     * Test of getProductCostLabor method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetProductCostLabor() {
       List<Double> productCostLabor = service.getProductCostLabor("Tile");
       assertEquals(2.25, productCostLabor.get(0), DELTA);
       assertEquals(2.1, productCostLabor.get(1), DELTA);
    }

    /**
     * Test of getStateTax method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetStateTax() {
       assertEquals(6.25, service.getStateTax("MI"), DELTA);
    }

    /**
     * Test of validateOrderToEdit method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testValidateOrderToEdit() {
        assertEquals(false, service.validateOrderToEdit(0));
        assertEquals(true, service.validateOrderToEdit(1));
    }

    /**
     * Test of displayExistingFiles method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testDisplayExistingFiles() {
        List<String> listOfNames = service.displayExistingFiles();
        assertEquals(true, listOfNames.get(0).equals("Orders_10282017.txt"));
        assertEquals(true, listOfNames.get(1).equals("Orders_10292017.txt"));
        assertEquals(false, listOfNames.get(1).equals("Orders_10012017.txt"));
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        assertEquals(true, (service.removeOrder(1).getOrderNumber() == 1));
    }

    /**
     * Test of editOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
        Order onlyOrder = service.removeOrder(1);
        assertEquals(222.0, onlyOrder.getArea(), DELTA);
        assertEquals(921.3, onlyOrder.getMaterialCost(), DELTA);
        assertEquals(777.0, onlyOrder.getLaborCost(), DELTA);
        assertEquals(13.5, onlyOrder.getTax(), DELTA);
        assertEquals(2650.03, onlyOrder.getTotal(), DELTA);
        
        Order editOrder = service.editOrder(1, 100.0);
        //210.0::225.0::13.27::225.52
        assertEquals(100.0, editOrder.getArea(), DELTA);
        assertEquals(210.0, editOrder.getMaterialCost(), DELTA);
        assertEquals(225.0, editOrder.getLaborCost(), DELTA);
        assertEquals(58.73, editOrder.getTax(), DELTA);
        assertEquals(493.73, editOrder.getTotal(), DELTA);
    }   
}
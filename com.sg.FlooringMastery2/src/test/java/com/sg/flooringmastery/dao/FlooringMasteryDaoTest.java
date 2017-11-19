/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import static com.sg.flooringmastery.dao.FlooringMasteryDaoFileImpl.DELIMITER;
import com.sg.flooringmastery.dto.Order;
import java.io.File;
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
public class FlooringMasteryDaoTest {
    
    private static final double DELTA = 1e-15;
    private FlooringMasteryDao dao = new FlooringMasteryDaoFileImpl();
    
    public FlooringMasteryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{

        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for (File orderFile : filesList){
            if (orderFile.isFile()){
                if (orderFile.getName().startsWith("Orders")){
                    try {
                        List<String> orderList = dao.loadOrdersFromFile(orderFile.getName());
                        for (String order : orderList) {
                            String[] currentTokens = order.split(DELIMITER);
                            dao.removeOrder(Integer.parseInt(currentTokens[0]));
                            dao.saveWork();
                        }
                    } catch (Exception e){
                    }
                }
            }
        }
    }
    @Test
    public void testAddOrder() throws Exception {
        dao.loadOrdersFromFile("Orders_10292017.txt");
        Order order = new Order();
        order.setOrderNumber(10);
        order.setCustomerName("Name 1");
        order.setState("MI");
        order.setTaxRate(Double.parseDouble("5.75") );
        order.setProductType("Tile");
        order.setArea(Double.parseDouble("222.0"));
        order.setCostPerSquareFoot(Double.parseDouble("4.15"));
        order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
        order.setMaterialCost();//Double.parseDouble("921.3")
        order.setLaborCost();//Double.parseDouble("777.0")
        order.setTax();//Double.parseDouble("951.73")
        order.setTotal();//Double.parseDouble("2650.03")
        dao.addOrder(order,"Orders_10292017.txt" );
        dao.saveWork();
        assertEquals(true, dao.validateOrderToEdit(10));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryDao.
     */
    //@Test
    public void testGetAllOrders() throws Exception {

        Order order = new Order();
        order.setOrderNumber(1);
        order.setCustomerName("Name 1");
        order.setState("MI");
        order.setTaxRate(Double.parseDouble("5.75") );
        order.setProductType("Tile");
        order.setArea(Double.parseDouble("222.0"));
        order.setCostPerSquareFoot(Double.parseDouble("4.15"));
        order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
        order.setMaterialCost();//Double.parseDouble("921.3")
        order.setLaborCost();//Double.parseDouble("777.0")
        order.setTax();//Double.parseDouble("951.73")
        order.setTotal();//Double.parseDouble("2650.03")
        dao.addOrder(order, "Orders_10292017.txt"); dao.saveWork();
        
        order = new Order();
        order.setOrderNumber(2);
        order.setCustomerName("Name 2");
        order.setState("OH");
        order.setTaxRate(Double.parseDouble("5.75") );
        order.setProductType("Carpet");
        order.setArea(Double.parseDouble("222.0"));
        order.setCostPerSquareFoot(Double.parseDouble("4.15"));
        order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
        order.setMaterialCost();//DoubDle.parseDouble("921.3")
        order.setLaborCost();//Double.parseDouble("777.0")
        order.setTax();//Double.parseDouble("951.73")
        order.setTotal();//Double.parseDouble("2650.03")
        dao.addOrder(order, "Orders_10292017.txt");
        dao.saveWork();
        
        assertEquals(2, dao.loadOrdersFromFile("Orders_10292017.txt").size());
        
    }

    /**
     * Test of saveWork method, of class FlooringMasteryDao.
     */
    @Test
    public void testSaveWork_0args() throws Exception {
    }

    /**
     * Test of saveWork method, of class FlooringMasteryDao.
     */
    @Test
    public void testSaveWork_String() throws Exception {
    }

    /**
     * Test of getStateTax method, of class FlooringMasteryDao.
     * OH::6.25
     * PA::6.75
     * MI::5.75
     * IN::6.00
     */
    @Test
    public void testGetStateTax_String() {
       assertEquals(6.25, dao.getStateTax("OH"), DELTA);
       assertEquals(6.75, dao.getStateTax("PA"), DELTA);
       assertEquals(5.75, dao.getStateTax("MI"), DELTA);
       assertEquals(6.00, dao.getStateTax("IN"), DELTA);
    }

    /**
     * Test of getProductCostLabor method, of class FlooringMasteryDao.
     * Carpet::2.25::2.10
     * Laminate::1.75::2.10
     * Tile::3.50::4.15
     * Wood::5.15::4.75
     */
    @Test
    public void testGetProductCostLabor() {
       List<Double> productCostLabor = dao.getProductCostLabor("Carpet");
       assertEquals(2.25, productCostLabor.get(0), DELTA);
       assertEquals(2.10, productCostLabor.get(1), DELTA);
       productCostLabor = dao.getProductCostLabor("Laminate");
       assertEquals(1.75, productCostLabor.get(0), DELTA);
       assertEquals(2.10, productCostLabor.get(1), DELTA);
       productCostLabor = dao.getProductCostLabor("Tile");
       assertEquals(3.50, productCostLabor.get(0), DELTA);
       assertEquals(4.15, productCostLabor.get(1), DELTA);
       productCostLabor = dao.getProductCostLabor("Wood");
       assertEquals(5.15, productCostLabor.get(0), DELTA);
       assertEquals(4.75, productCostLabor.get(1), DELTA);
    }

    /**
     * Test of listAllOrders method, of class FlooringMasteryDao.
     */
    @Test
    public void testListAllOrders() throws Exception {
    }

    
    /**
     * Test of validateOrderToEdit method, of class FlooringMasteryDao.
     */
    @Test
    public void testValidateOrderToEdit() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
            Order order = new Order();
            order.setOrderNumber(5);
            order.setCustomerName("Name 1");
            order.setState("MI");
            order.setTaxRate(Double.parseDouble("5.75") );
            order.setProductType("Tile");
            order.setArea(Double.parseDouble("222.0"));
            order.setCostPerSquareFoot(Double.parseDouble("4.15"));
            order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
            order.setMaterialCost();//Double.parseDouble("921.3")
            order.setLaborCost();//Double.parseDouble("777.0")
            order.setTax();//Double.parseDouble("951.73")
            order.setTotal();//Double.parseDouble("2650.03")
            dao.addOrder(order, "Orders_10292017.txt"); dao.saveWork();
        } catch (Exception e){
        }
        assertEquals(false, dao.validateOrderToEdit(1000));
        assertEquals(true, dao.validateOrderToEdit(5));
    }

    /**
     * Test of editOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testEditOrder() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
            Order order = new Order();
            order.setOrderNumber(1);
            order.setCustomerName("Name 1");
            order.setState("MI");
            order.setTaxRate(Double.parseDouble("5.75") );
            order.setProductType("Tile");
            order.setArea(Double.parseDouble("222.0"));
            order.setCostPerSquareFoot(Double.parseDouble("4.15"));
            order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
            order.setMaterialCost();//Double.parseDouble("921.3")
            order.setLaborCost();//Double.parseDouble("777.0")
            order.setTax();//Double.parseDouble("951.73")
            order.setTotal();//Double.parseDouble("2650.03")
            dao.addOrder(order, "Orders_10292017.txt"); dao.saveWork();
    
            List<Double> editValues = new ArrayList<Double>();
            editValues.add(new Double(100));//area
            editValues.add(new Double(101));//material cost
            editValues.add(new Double(102));//labor cost
            editValues.add(new Double(103));//tax
            editValues.add(new Double(104));//total
            Order editedOrder = dao.editOrder(1, editValues, "Laminate", "PA", "Orders_10292017.txt", "cName", "Orders_11052017.txt");
            dao.saveWork();
            
            assertEquals(100, editedOrder.getArea(), DELTA);
            assertEquals(101, editedOrder.getMaterialCost(), DELTA);
            assertEquals(102, editedOrder.getLaborCost(), DELTA);
            assertEquals(103, editedOrder.getTax(), DELTA);
            assertEquals(104, editedOrder.getTotal(), DELTA);
            assertEquals(true, editedOrder.getProductType().equals("Laminate"));
            assertEquals(true, editedOrder.getState().equals("PA"));
        } catch (Exception e){
        }
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testRemoveOrder() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
            Order order = new Order();
            order.setOrderNumber(1);
            order.setCustomerName("Name 1");
            order.setState("MI");
            order.setTaxRate(Double.parseDouble("5.75") );
            order.setProductType("Tile");
            order.setArea(Double.parseDouble("222.0"));
            order.setCostPerSquareFoot(Double.parseDouble("4.15"));
            order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
            order.setMaterialCost();//Double.parseDouble("921.3")
            order.setLaborCost();//Double.parseDouble("777.0")
            order.setTax();//Double.parseDouble("951.73")
            order.setTotal();//Double.parseDouble("2650.03")

            dao.addOrder(order, "Orders_10292017.txt"); 
            dao.saveWork();

            order = new Order();
            order.setOrderNumber(2);
            order.setCustomerName("Name 2");
            order.setState("OH");
            order.setTaxRate(Double.parseDouble("5.75") );
            order.setProductType("Carpet");
            order.setArea(Double.parseDouble("222.0"));
            order.setCostPerSquareFoot(Double.parseDouble("4.15"));
            order.setLaborCostPerSquareFoot(Double.parseDouble("3.5"));
            order.setMaterialCost();//Double.parseDouble("921.3")
            order.setLaborCost();//Double.parseDouble("777.0")
            order.setTax();//Double.parseDouble("951.73")
            order.setTotal();//Double.parseDouble("2650.03")

            dao.addOrder(order, "Orders_10292017.txt");
            dao.saveWork();
            int ordersSize = dao.loadOrdersFromFile("Orders_10292017.txt").size();

            dao.removeOrder(2);
            dao.saveWork();
            assertEquals(false, dao.validateOrderToEdit(2));
            assertEquals(true, dao.validateOrderToEdit(10));
            dao.removeOrder(1);
            dao.saveWork();
            assertEquals(false, dao.validateOrderToEdit(1));
            
            assertEquals((ordersSize), dao.loadOrdersFromFile("Orders_10292017.txt").size());
            }catch(Exception e){
            }
    }
    /**
     * Test of getProductCost method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetProductCost() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
        } catch (Exception e){
        }
        assertEquals(4.15, dao.getProductCost(10), DELTA);
    }

    /**
     * Test of getLaborCostPerSquareFoot method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetLaborCostPerSquareFoot() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
        } catch (Exception e){
        }
        assertEquals(3.5, dao.getLaborCostPerSquareFoot(10), DELTA);
    }

    /**
     * Test of getStateTax method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetStateTax_int() {
        try{
            dao.loadOrdersFromFile("Orders_10292017.txt");
        } catch (Exception e){
        }
        assertEquals(97.65, dao.getStateTax(10), DELTA);
    }

    /**
     * Test of displayExistingFiles method, of class FlooringMasteryDao.
     */
    @Test
    public void testDisplayExistingFiles() {
        List<String> fileList = dao.displayExistingFiles();
        java.util.Collections.sort(fileList);
        System.out.println(""+fileList); 
        assertEquals(true, fileList.get(0).equals("Orders_10292017.txt"));
    }

    /**
     * Test of loadOrdersFromFile method, of class FlooringMasteryDao.
     */
    @Test
    public void testLoadOrdersFromFile() throws Exception {
    }
}
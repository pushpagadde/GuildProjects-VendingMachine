/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ZipCodeInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PG
 */
public class ZipCodeDaoImplTest {
    public ZipCodeDao dao;
    
    public ZipCodeDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("zipCodeDao", ZipCodeDao.class);
        
        List<ZipCodeInfo> zipcodes = dao.getAllZipCodes();
        for (ZipCodeInfo currentZipCode : zipcodes) {
            dao.deleteZipCode(currentZipCode.getZipCode());
        }
    }
     
    @Test
    public void addGetOperations() {    
        ZipCodeInfo zipCode = new ZipCodeInfo();
        zipCode.setCity("Medina");
        zipCode.setState("OH");
        zipCode.setZipCode("44256");
        dao.addZipCode(zipCode);
        ZipCodeInfo zipFromDao = dao.getZipCodeByID(zipCode.getZipCode());
        assertEquals(zipFromDao, zipCode);               
    }
    
    @Test
    public void deleteZipCode() {
        ZipCodeInfo zipCode = new ZipCodeInfo();
        zipCode.setCity("Medina");
        zipCode.setState("OH");
        zipCode.setZipCode("44256");
        dao.addZipCode(zipCode);
        ZipCodeInfo zipFromDao = dao.getZipCodeByID(zipCode.getZipCode());
        assertEquals(zipFromDao, zipCode);               
        
        dao.deleteZipCode(zipCode.getZipCode());
        assertNull(dao.getZipCodeByID(zipCode.getZipCode()));        
    }
    
    @Test
    public void getAllZipCodes() {
        ZipCodeInfo zipCode = new ZipCodeInfo();
        zipCode.setZipCode("44256");
        zipCode.setCity("Medina");
        zipCode.setState("OH");
        dao.addZipCode(zipCode);
                
        ZipCodeInfo zip2 = new ZipCodeInfo();
        zip2.setZipCode("44281");
        zip2.setCity("Wadsworth");
        zip2.setState("OH");
        dao.addZipCode(zip2);
        
        assertEquals(2,dao.getAllZipCodes().size());   
    }
}

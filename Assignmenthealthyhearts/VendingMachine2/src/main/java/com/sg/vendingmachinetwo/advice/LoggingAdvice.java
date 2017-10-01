/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinetwo.advice;

import com.sg.vendingmachinetwo.dao.VendingMachineAuditDao;
import com.sg.vendingmachinetwo.dao.VendingMachineFileNotFoundException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author apprentice
 */
public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        if (args.length > 5) {
            for (Object currentArg : args) {
               auditEntry += currentArg;
            }
        } else {
            auditEntry += "Exception thrown.";
        }
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineFileNotFoundException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}

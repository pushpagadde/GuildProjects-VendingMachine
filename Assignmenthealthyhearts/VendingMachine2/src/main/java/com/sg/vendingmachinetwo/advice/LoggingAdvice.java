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
        String auditEntry = jp.getSignature().getName();
        if (auditEntry.equals("editItem")) {
            auditEntry += " : Wrong item selection exception thrown.";
            auditEntry += " Item selected was # " + args[0];// jp.getArgs().toString().substring(1, 1);
        } else if (auditEntry.equals("editItemInventoryGetChange")) {
            auditEntry += " : insufficient funds exception thrown.";
            auditEntry += " Item selected was # " + args[0];// jp.getArgs().toString().substring(1, 1);
        }else if (auditEntry.equals("validateItemSelection")) {
            auditEntry += " : invalid item selection exception thrown.";
            auditEntry += " Item selected was # " + args[0];
        } else {
            for (Object currentArg : args) {
                auditEntry += currentArg;
            }
        }    
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachineFileNotFoundException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
    /*public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName();
        //if (auditEntry.equals("editItem")) {
            //if(args.length < 5) {
              //  auditEntry += " : Wrong item selection exception thrown.";
            //} else {
            for (Object currentArg : args) {
              auditEntry += currentArg;
            }
            try {
               auditDao.writeAuditEntry(auditEntry);
            } catch (VendingMachineFileNotFoundException e) {
                System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
            }
    }
           // }
        /*} else if (auditEntry.equals("editItemInventoryGetChange")){
            if(args.length < 5) {
                auditEntry += " : wrong item or insufficient funds exception thrown.";
            } else {
                for (Object currentArg : args) {
                   auditEntry += currentArg;
                }
            }
        } else if(auditEntry.equals("validateItemSelection")) {
            if(args.length < 5) {
                auditEntry += " : Wrong item selection exception thrown.";
            } else {
                for (Object currentArg : args) {
                   auditEntry += currentArg;
                }
            }
        } else {
            for (Object currentArg : args) {
               auditEntry += currentArg;
            }
        }*/
        
    //}
//}*/

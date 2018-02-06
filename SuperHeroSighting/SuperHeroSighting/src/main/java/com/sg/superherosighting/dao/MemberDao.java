/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosighting.dao;

import java.util.List;
import com.sg.superherosighting.model.Member;

/**
 *
 * @author PG
 */
public interface MemberDao {
//methods for Members table
    public void addMember(Member member, int organizationID);//1
    public void deleteMember(int memberID);//2
    public void updateMember(Member member, int organizationID);//3
    public Member getMemberByID(int memberID);//4
    public  List<Member> getAllMembers();//5
    public List<Member> getMembersByOrganization();//6
        
}

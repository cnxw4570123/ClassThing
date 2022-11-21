package com.spring_member2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring_member2.dto.MemberDto;

public interface MemberDao {
//	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH) VALUES(#{testId}, #{testPw}, #{testName}, TO_DATE(#{testBirth}, 'YYYY-MM-DD'))")
//	public int insertMember(@Param("mid") String mid, @Param("mpw") String mpw);
	
	
	  @Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH) VALUES(#{testId}, #{testPw}, #{testName}, TO_DATE(#{testBirth}, 'YYYY-MM-DD'))") 
	  public int insertMember(MemberDto member);

	  @Select("SELECT MID as testId, MPW as testPw, MNAME as testName, MBIRTH as testBirth FROM MEMBERS")
	  public ArrayList<MemberDto> selectMemberList();

	  @Select("SELECT MID FROM MEMBERS WHERE MID = #{mid} AND MPW = #{mpw}")
	  public String selectMember(@Param("mid") String testId, @Param("mpw") String testPw);
	  
	
	
	
}

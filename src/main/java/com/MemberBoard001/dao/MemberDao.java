package com.MemberBoard001.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.MemberBoard001.dto.MemberDto;

public interface MemberDao {
	
	@Insert("INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MADDR, MEMAIL, MPROFILE, MSTATE)" // 회원가입
			+ " VALUES(#{mid}, #{mpw}, #{mname}, TO_DATE(#{mbirth}, 'YYYY-MM-DD'), #{maddr}, #{memail}, #{mprofile}, '1')")
	int insertMember(MemberDto member);

	@Select("SELECT MID FROM MEMBERS WHERE MID = #{inputID}") // 아이디 중복 체크
	String selectMid(String inputID);
	
	@Select("SELECT * FROM MEMBERS WHERE MID = #{mid} AND MPW = #{mpw}") // 로그인
	MemberDto selectLogResult(@Param("mid") String mid, @Param("mpw") String mpw);

	@Select("SELECT * FROM MEMBERS WHERE MID = #{mid}")
	MemberDto selectMember(String mid);
}

package com.kh.spring.mybatis;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {

	//SqlSessionTemplate 주요 메소드
	//selectOne : 단일행 반환하는 select문 실행 메소드
	//selectList : 다중행 반환하는 select문 실행 메소드
	//insert : 메소드 결과값은 쿼리에 의해 영향을 받은 row수
	//update : 메소드 결과값은 쿼리에 의해 영향을 받은 row수
	//delete : 메소드 결과값은 쿼리에 의해 영향을 받은 row수
	//**프로시저 호출은 DML쿼리 메소드중 선택
	
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.kh.spring.mybatis.MybatisMapper.";
	String userId = "suna";
	
	@Test
	public void selectOneTest() {
		session.selectOne(NAMESPACE+"selectPasswordByUserId", userId);
	}
	
	@Test
	public void selectOneAsDTO() {
		Member member = session.selectOne(NAMESPACE+"selectMemberById", userId);
		System.out.println(member);
	}
	
	@Test
	public void selectListAsMap() {
		List<Map<String,Object>> res = session.selectList(NAMESPACE+"selectRentAndMemberById", userId);
		for (Map<String, Object> map : res) {
			System.out.println("map:"+map);
		}
	}


	@Test
	public void selectListUsingResultMap() {
		List<Map<String,Object>> res = session.selectList(NAMESPACE+"selectRnetDataByUserId", userId);
		for (Map<String, Object> map : res) {
			System.out.println("map2:"+map);
		}
	}

	
	@Test
	public void insertWithDto() {
		
		Member member = new Member();
		member.setUserId("mybatis");
		member.setPassword("1234");
		member.setEmail("2@2.do");
		member.setTell("010-222-2331");
		
		session.insert(NAMESPACE+"insertWithDto", member);		
		System.out.println(member);
	}

	@Test
	public void insertWithMap() {
		
		Member member = new Member();
		member.setUserId("mybatis");
		
		Map<String,Object> commandMap = new HashMap<String,Object>();
		commandMap.put("member", member);
		commandMap.put("title","my바티스 입문서적 2개");
		commandMap.put("rentBookCnt",3);
		
		session.insert(NAMESPACE+"insertWithMap", commandMap);
		
	}
	
	@Test
	public void delete() {
		String userId = "mybatis";
		session.delete(NAMESPACE+"delete",userId);
		
	}
	
	@Test
	public void upadate() {
		Member member = new Member();
		member.setUserId("mybatis");
		member.setPassword("12312312313");
		session.update(NAMESPACE+"update", member);
	}
	
	@Test
	public void procedure() {
		String rbIdx ="100063";
		session.insert(NAMESPACE+"procedure",rbIdx);
	}
	
    @Test
    public void dynamicQueryIF() {
      //사용자가 도서 검색필터에서 info를 선택하고 검색하면 사용자가 입력한 키워드로 info 컬럼을 검색
      //사용자가 도서 검색필터에서 author를 선택하고 검색하면 사용자가 입력한 키워드로 author 컬럼을 검색
      //사용자 선택 필터 : info
      //사용자 입력 키워드 : 도시
      
    }
   
    @Test
    public void dynamicQueryChoose() {
      //사용자가 도서 검색필터에서 info를 선택하고 검색하면 사용자가 입력한 키워드로 info 컬럼을 검색
      //사용자가 도서 검색필터에서 author를 선택하고 검색하면 사용자가 입력한 키워드로 author 컬럼을 검색
      //사용자가 검색필터를 지정 하지 않을 경우 도서 제목으로 검색
      //사용자 선택 필터 : info
      //사용자 입력 키워드 : 도시
      
    }
   
    @Test
    public void dynamicQuerySetTag() {
      //사용자가 회원수정란에서 수정한 내용을 update하는 쿼리를 작성
      //사용자가 password, email만 수정했다면, update쿼리를
      //[update tb_member set password = 1234, email = 'aa@aa.com' where userId = 'aa']
      
      
    }
   
    @Test
    public void dynamicQueryForeachTagWithList() {
      //만능 insert쿼리 생성
       //session.selectList(NAMESPACE+"dynamicQueryForeachTagWithList",List.of("test","insertTest","insertTest2"));
    }

    @Test
    public void dynamicQueryWhereAndForeachTag() {
      //검색조건을 or 연산으로 검색하기
      //대출가능, 제목, 작가
      //사용자가 입력한 키워드
      
    }
   
    @Test
    public void dynamicQueryForeachTag() {
      //만능 insert쿼리 생성
      
      
    }
	
	
	
	//1. 도서명 : 쿠키와 세션 (book테이블 추가
	//   작가 : 김영아
	//	도서번호: 시퀀스
	@Test
	public void test01() {
		Map<String,Object> testMap = new HashMap<String,Object>();
		testMap.put("title", "쿠키와 세션?");
		testMap.put("author","김영아");
		session.insert(NAMESPACE+"test01", testMap);
	}
	
	//2.연장횟수 2회이상 모든 대출도서를 0으로 초기화
	@Test
	public void test02() {
		session.update(NAMESPACE+"test02");
	}
	//3. 2021년 10월 이후 가입된 회원정보 삭제 -->참조무결성안걸리게....
	@Test
	public void test03() {
		session.update(NAMESPACE+"test03");
	}
	//4.대출횟수 많은 3권 도서조회
	@Test
	public void test04() {
		session.selectList(NAMESPACE+"test04");
	}
	
	
	
}

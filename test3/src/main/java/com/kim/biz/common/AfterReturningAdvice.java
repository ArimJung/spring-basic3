package com.kim.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.kim.biz.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.bPointcut()", returning="returnObj")
	public void printLogAfterReturning(JoinPoint jp,Object returnObj) {
		String methodName=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		
		System.out.println("�������� �ٽɸ޼���� : "+methodName);
		System.out.println("����ϴ� ���� : ");
		System.out.println("=====");
		for(Object v : args) {
			System.out.println(v);
		}
		System.out.println("=====");
		
		if(returnObj instanceof MemberVO) { // ���VOŸ���� ��ü�� �´�?
			MemberVO mvo=(MemberVO)returnObj;
			if(mvo.getRole().equals("ADMIN")){
				System.out.println("�������Դϴ�.");
			}
			else {
				System.out.println("�Ϲݰ����Դϴ�.");
			}
		}
		System.out.println("�ٽɸ޼����� ��ȯ�� : "+returnObj);
	}
}

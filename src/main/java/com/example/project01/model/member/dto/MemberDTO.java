package com.example.project01.model.member.dto;

import java.util.Date;

public class MemberDTO {
			private String userid; //1.유저아이디                
			private String passwd; //2.비밀번호
			private String name; //3.성명
			private Date birth; //4.생년월일
			private String gender; //5.성별
			private String email; //6.이메일
			private int email_confirm; //7.이메일인증여부 (0=인증 실패 1=인증성공)
			private String hp; //8.전화번호
			private String address; //9.주소
			private String photo_url; //프로필사진
			private String ac_number; //10.계좌번호
			private String investor_type; //11.투자자타입 (s=법인.조합투자 a=개인 전문 투자자 b=개인 적격 투자자 c=개인 일반 투자자)-->조건은 스프링에서 작업
			private String investor_sign; //12.투자자 심사여부 (0=등록실패 1=심사중 2=등록성공)
			private String concern_job; //13.관심직종
			private int total_funding; //14.총투자액
			private int total_reward; //15.총 리워드 펀딩 액수
			private Date join_date ; //16.가입일자
			private int jno; //17.가입 순서(번호) -->squence로 처리
			private int company_sign; //18.기업등록여부/심사통과여부(y=1/n=0)-->기업등록이 되있으면 1 안되있으면 0
			private String company_name; //19.회사명-->기업이 아닌 회원은 null값으로 처리 -->회사정보컬럼 계속추가
			
			public String getUserid() {
				return userid;
			}
			public void setUserid(String userid) {
				this.userid = userid;
			}
			public String getPasswd() {
				return passwd;
			}
			public void setPwd(String passwd) {
				this.passwd = passwd;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public Date getBirth() {
				return birth;
			}
			public void setBirth(Date birth) {
				this.birth = birth;
			}
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public int getEmail_confirm() {
				return email_confirm;
			}
			public void setEmail_confirm(int email_confirm) {
				this.email_confirm = email_confirm;
			}
			public String getHp() {
				return hp;
			}
			public void setHp(String hp) {
				this.hp = hp;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getPhoto_url() {
				return photo_url;
			}
			public void setPhoto_url(String photo_url) {
				this.photo_url = photo_url;
			}
			public String getAc_number() {
				return ac_number;
			}
			public void setAc_number(String ac_number) {
				this.ac_number = ac_number;
			}
			public String getInvestor_type() {
				return investor_type;
			}
			public void setInvestor_type(String investor_type) {
				this.investor_type = investor_type;
			}
			public String getInvestor_sign() {
				return investor_sign;
			}
			public void setInvestor_sign(String investor_sign) {
				this.investor_sign = investor_sign;
			}
			public String getConcern_job() {
				return concern_job;
			}
			public void setConcern_job(String concern_job) {
				this.concern_job = concern_job;
			}
			public int getTotal_funding() {
				return total_funding;
			}
			public void setTotal_funding(int total_funding) {
				this.total_funding = total_funding;
			}
			public int getTotal_reward() {
				return total_reward;
			}
			public void setTotal_reward(int total_reward) {
				this.total_reward = total_reward;
			}
			public Date getJoin_date() {
				return join_date;
			}
			public void setJoin_date(Date join_date) {
				this.join_date = join_date;
			}
			public int getJno() {
				return jno;
			}
			public void setJno(int jno) {
				this.jno = jno;
			}
			public int getCompany_sign() {
				return company_sign;
			}
			public void setCompany_sign(int company_sign) {
				this.company_sign = company_sign;
			}
			public String getCompany_name() {
				return company_name;
			}
			public void setCompany_name(String company_name) {
				this.company_name = company_name;
			}
			@Override
			public String toString() {
				return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", birth=" + birth
						+ ", gender=" + gender + ", email=" + email + ", email_confirm=" + email_confirm + ", hp=" + hp
						+ ", address=" + address + ", photo_url=" + photo_url + ", ac_number=" + ac_number
						+ ", investor_type=" + investor_type + ", investor_sign=" + investor_sign + ", concern_job="
						+ concern_job + ", total_funding=" + total_funding + ", total_reward=" + total_reward
						+ ", join_date=" + join_date + ", jno=" + jno + ", company_sign=" + company_sign
						+ ", company_name=" + company_name + "]";
			}
			
			

}

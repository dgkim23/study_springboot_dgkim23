
package com.example.member;

import org.apache.ibatis.type.Alias;

 
@Alias("memberVO")
public class MemberVO {

	private long memberSql;

	private String usrId;

	private String usrPass;

	private String usrName;

	private String usrAddr;

	private String usrTkn;

	public String getUsrTkn() {
		return usrTkn;
	}

	public void setUsrTkn(String usrTkn) {
		this.usrTkn = usrTkn;
	}

	public long getMemberSql() {

		return memberSql;

	}

	public void setMemberSql(long memberSql) {

		this.memberSql = memberSql;

	}

	public String getUsrId() {

		return usrId;

	}

	public void setUsrId(String usrId) {

		this.usrId = usrId;

	}

	public String getUsrPass() {

		return usrPass;

	}

	public void setUsrPass(String usrPass) {

		this.usrPass = usrPass;

	}

	public String getUsrName() {

		return usrName;

	}

	public void setUsrName(String usrName) {

		this.usrName = usrName;

	}

	public String getUsrAddr() {

		return usrAddr;

	}

	public void setUsrAddr(String usrAddr) {

		this.usrAddr = usrAddr;

	}

	@Override

	public String toString() {

		return "MemberVO [memberSql=" + memberSql + ", usrId=" + usrId + ", usrPass=" + usrPass + ", usrName=" + usrName

				+ ", usrAddr=" + usrAddr + "]";

	}

}

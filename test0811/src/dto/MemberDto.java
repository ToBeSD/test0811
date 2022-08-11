package dto;

public class MemberDto {
	private String id;
	private String password;
	private String name;
	private int point;
	
	public MemberDto(String id, String password, String name, int point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	

}

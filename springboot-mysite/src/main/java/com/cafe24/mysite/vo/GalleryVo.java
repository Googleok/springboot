package com.cafe24.mysite.vo;

public class GalleryVo {

	private Long no;
	private String image;
	private String description;

	public GalleryVo() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryVo(Long no, String image, String description) {
		this.no = no;
		this.image = image;
		this.description = description;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", image=" + image + ", description=" + description + "]";
	}
	
	
	
}

package com.example.helloworld;

public class Objects {
	private String name;
	private String nameta;
	private String image;
	private boolean show;
	private String audio;
	private boolean custom;
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
	
	Objects(){
		this.show = true;
	}

	Objects(String name1, String image1){
		this.name = name1;
		this.image = image1;
		this.show = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getNameta() {
		return nameta;
	}

	public void setNameta(String nameta) {
		this.nameta = nameta;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	@Override
	public String toString() {
		return getName();
	}

}

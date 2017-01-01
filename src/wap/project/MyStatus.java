package wap.project;

public class MyStatus { 
	private String imageURL;
	private String text;
	private String link;
	
	public MyStatus(String imageURL, String text, String link) {
		super();
		this.imageURL = imageURL;
		this.text = text;
		this.link = link;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

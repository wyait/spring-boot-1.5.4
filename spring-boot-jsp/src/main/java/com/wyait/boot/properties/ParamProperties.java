package com.wyait.boot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParamProperties {
	@Value("${wyait.name}")
	private String wyaitName;
	@Value("${wyait.title}")
	private String wyaitTitle;
	@Value("${wyait.message}")
	private String wyaitMessage;

	public String getWyaitName() {
		return wyaitName;
	}

	public void setWyaitName(String wyaitName) {
		this.wyaitName = wyaitName;
	}

	public String getWyaitTitle() {
		return wyaitTitle;
	}

	public void setWyaitTitle(String wyaitTitle) {
		this.wyaitTitle = wyaitTitle;
	}

	public String getWyaitMessage() {
		return wyaitMessage;
	}

	public void setWyaitMessage(String wyaitMessage) {
		this.wyaitMessage = wyaitMessage;
	}

	@Override
	public String toString() {
		return "ParamProperties [wyaitName=" + wyaitName + ", wyaitTitle="
				+ wyaitTitle + ", wyaitMessage=" + wyaitMessage + "]";
	}

}

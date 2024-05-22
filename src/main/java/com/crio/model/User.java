package com.crio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_badges")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "score")
	private int score;

	@Column(name = "badges")
	@ElementCollection
	private List<String> badges;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getBadges() {
		return badges;
	}

	public void setBadges(List<String> badges) {
		this.badges = badges;
	}

	public void updatedBadges() {
		this.badges.clear();
		if (this.score >= 1 && !this.badges.contains("Code Ninja")) {
			this.badges.add("Code Ninja");
		}
		if (this.score >= 30 && !this.badges.contains("Code Champ")) {
			this.badges.add("Code Champ");
		}
		if (this.score >= 60 && !this.badges.contains("Code Master")) {
			this.badges.add("Code Master");
		}
	}

}

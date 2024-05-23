package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLoanHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	@Column(name = "book_name", nullable = false)
	private String bookName;

	@Column(name = "is_return", nullable = false)
	private boolean isReturn;

	public UserLoanHistory(){
	}

	public UserLoanHistory(User user, String bookName) {
		this.user = user;
		this.bookName = bookName;
		this.isReturn = false;
	}

	public String getBookName() {
		return bookName;
	}

	public void doReturn() {
		this.isReturn = true;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

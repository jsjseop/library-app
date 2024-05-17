package com.group.libraryapp.domain.user.loanHistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.group.libraryapp.domain.user.User;

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

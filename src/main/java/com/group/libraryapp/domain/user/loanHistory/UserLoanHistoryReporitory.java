package com.group.libraryapp.domain.user.loanHistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryReporitory extends JpaRepository<UserLoanHistory, Long> {

	boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
}

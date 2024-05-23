package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<com.group.libraryapp.domain.user.loanhistory.UserLoanHistory, Long> {

	boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
}

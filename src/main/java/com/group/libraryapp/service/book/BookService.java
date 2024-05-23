package com.group.libraryapp.service.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final UserLoanHistoryRepository userLoanHistoryRepository;
	private final UserRepository userRepository;

	public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository,
		UserRepository userRepository) {
		this.bookRepository = bookRepository;
		this.userLoanHistoryRepository = userLoanHistoryRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void saveBook(BookCreateRequest request) {
		bookRepository.save(new Book(request.getName()));
	}

	@Transactional
	public void loanBook(BookLoanRequest request) {
		Book book = bookRepository.findByName(request.getBookName())
			.orElseThrow(IllegalArgumentException::new);

		if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
			throw new IllegalArgumentException();
		}

		User user = userRepository.findByName(request.getUserName())
			.orElseThrow(IllegalArgumentException::new);
		user.loanBook(book.getName());
	}

	@Transactional
	public void returnBook(BookReturnRequest request) {
		User user = userRepository.findByName(request.getUserName())
			.orElseThrow(IllegalArgumentException::new);
		user.returnBook(request.getBookName());
	}
}

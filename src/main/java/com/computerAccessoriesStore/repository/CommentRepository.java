package com.computerAccessoriesStore.repository;

import com.computerAccessoriesStore.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

}

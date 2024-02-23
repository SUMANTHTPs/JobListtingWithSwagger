package com.sumanthtp.jobListing.repository;

import com.sumanthtp.jobListing.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}

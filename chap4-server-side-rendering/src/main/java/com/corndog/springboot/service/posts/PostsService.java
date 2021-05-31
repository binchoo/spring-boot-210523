package com.corndog.springboot.service.posts;

import com.corndog.springboot.domain.posts.Posts;
import com.corndog.springboot.domain.posts.PostsRepository;
import com.corndog.springboot.web.dto.PostsListResponseDto;
import com.corndog.springboot.web.dto.PostsResponseDto;
import com.corndog.springboot.web.dto.PostsSaveRequestDto;
import com.corndog.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // PostsRepository가 필요한 생성자가 생성됨. 그럼 Spring은 의존성을 주입해 줌.
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없어요. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없어요. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent()); // 해당 id를 갖는 Posts 데이터의 칼럼 값을 대체 대입하는 것으로 update query 된다.

        return id;
    }

    @Transactional(readOnly = true) // 조회 기능만 있을 때, 속도 개선을 할 수 있다
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //클라이언트에 반환할 DTO 타입으로 변환하여 제공!
                .collect(Collectors.toList());
    }
}

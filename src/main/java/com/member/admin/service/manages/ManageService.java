package com.member.admin.service.manages;

import com.member.admin.domain.members.Members;
import com.member.admin.domain.members.MemberRepository;
import com.member.admin.web.dto.ManageListResponseDto;
import com.member.admin.web.dto.ManageResponseDto;
import com.member.admin.web.dto.ManageSaveRequestDto;
import com.member.admin.web.dto.ManageUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ManageService {

    private final MemberRepository memberRepository;

    // save
    @Transactional
    public Long save(ManageSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    // update
    @Transactional
    public Long update(Long id, ManageUpdateRequestDto requestDto) {
        Members members = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID가 없습니다. id=" + id));

        members.update(requestDto.getPw());

        return id;
    }

    // search id
    @Transactional(readOnly = true)
    public ManageResponseDto findById(Long id) {
        Members entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID가 없습니다. id=" + id));

        return new ManageResponseDto(entity);
    }

    // search
    @Transactional(readOnly = true)
    public List<ManageListResponseDto> findAllDesc() {
        return memberRepository.findAllDesc().stream()
                .map(ManageListResponseDto::new)
                .collect(Collectors.toList());
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Members members = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다. id=" + id));

        memberRepository.delete(members);
    }
}

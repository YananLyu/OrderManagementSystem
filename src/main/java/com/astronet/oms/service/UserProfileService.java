package com.astronet.oms.service;

import com.astronet.oms.dtos.UserProfileDto;
import com.astronet.oms.entity.UserProfile;
import com.astronet.oms.exception.UserProfileNotFoundException;
import com.astronet.oms.repository.UserProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/26/2021 12:34 AM
 */

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository repository;

    @Autowired
    private ModelMapper mapper;

    /**
     * C - Create
     * @param userProfileDto
     * @return
     */
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        UserProfile savedUserProfile = repository.save(mapper.map(userProfileDto, UserProfile.class));
        return mapper.map(savedUserProfile, UserProfileDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<UserProfileDto> readAllUserProfile() {
        List<UserProfile> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, UserProfileDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    public UserProfileDto readOneUserProfile(Long id) {
        UserProfile userProfile = repository.findById(id)
                .orElseThrow(() -> new UserProfileNotFoundException(id));
        return mapper.map(userProfile, UserProfileDto.class);
    }

    /**
     * U - Update; if no id found, throw exception
     * @param newUserProfileDto
     * @param id
     * @return
     */
    public UserProfileDto updateUserProfile(UserProfileDto newUserProfileDto, Long id) {
        UserProfile newUserProfile = mapper.map(newUserProfileDto, UserProfile.class);
        UserProfile updatedUserProfile = repository.findById(id)
                .map(user -> {
                    user.setWechatId(newUserProfile.getWechatId());
                    user.setWechatName(newUserProfile.getWechatName());
                    user.setPhoneNumber(newUserProfile.getPhoneNumber());
                    return repository.save(user);
                })
                .orElseThrow(() -> new UserProfileNotFoundException(id));
        return mapper.map(updatedUserProfile, UserProfileDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteUserProfile(Long id) {
        repository.deleteById(id);
    }

}

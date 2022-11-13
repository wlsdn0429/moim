package project.moim.service;

import project.moim.domain.MoimJoin;
import project.moim.domain.User;

import java.util.ArrayList;

public interface MoimJoinService {
    User getUserInfo(Long kakaoId);
    ArrayList<MoimJoin> getGroups(Long id);
}

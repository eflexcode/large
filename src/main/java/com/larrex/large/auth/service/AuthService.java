package com.larrex.large.auth.service;

import com.larrex.large.auth.entity.Verification;

public interface AuthService {

    Verification findByToken(String token);

}

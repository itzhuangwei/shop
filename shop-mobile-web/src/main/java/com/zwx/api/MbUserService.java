package com.zwx.api;

import com.zwx.api.member.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author 文希
 * @create 2019-09-15 20:44
 */
@FeignClient(name = "member")
public interface MbUserService extends UserService {

}

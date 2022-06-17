// Copyright 2019 Kelin Inc. All rights reserved.

package com.kelin.archetype.api.client;

import com.kelin.archetype.beans.rest.RestResponse;
import com.kelin.archetype.common.exception.RpcException;
import com.kelin.archetype.core.rpc.HttpMethod;
import com.kelin.archetype.core.rpc.RpcClient;
import com.kelin.archetype.database.entity.primary.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Kelin Tan
 */
@RpcClient(endpoint = "${client.endpoint.user}", errorHandler = UserClientErrorHandler.class)
public interface UserClientV2 {
    @HttpMethod(value = "/api/v1/user/findAll/error", method = RequestMethod.GET)
    RestResponse<List<User>> findAllError();

    @RequestMapping(value = "/api/v1/user/findAll", method = RequestMethod.GET)
    RestResponse<List<User>> findAll() throws RpcException;
}

package com.rz.framework.proxy;

/**
 * Created by as on 2018/2/3.
 * 执行链式代理
 */
public interface Proxy {

    /**
     * 执行链式代理
     *
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;

}

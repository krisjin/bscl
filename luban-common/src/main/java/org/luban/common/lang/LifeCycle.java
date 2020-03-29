package org.luban.common.lang;

/**
 * 生命周期管理
 */
public interface LifeCycle extends Online {

    /**
     * 启动
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 停止
     */
    void stop();
}

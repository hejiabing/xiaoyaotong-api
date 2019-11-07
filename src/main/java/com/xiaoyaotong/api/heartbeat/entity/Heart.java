package com.xiaoyaotong.api.heartbeat.entity;

import java.util.Date;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/7 20:59
 */
public class Heart {

    public String getNodeIdentify() {
        return nodeIdentify;
    }

    public Date getLastHeartBeat() {
        return lastHeartBeat;
    }

    private String nodeIdentify;

    public void setNodeIdentify(String nodeIdentify) {
        this.nodeIdentify = nodeIdentify;
    }

    public void setLastHeartBeat(Date lastHeartBeart) {
        this.lastHeartBeat = lastHeartBeart;
    }

    private Date lastHeartBeat;

}

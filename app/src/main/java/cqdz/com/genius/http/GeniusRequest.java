package cqdz.com.genius.http;

import cqdz.com.genius.app.Genius;

/**
 * 请求报文公共报文头
 */
public class GeniusRequest {
    //身份认证
    private String token = Genius.getInstance().getCommonParts().get("token");
    //时间戳
    private String timestamp = Genius.getInstance().getCommonParts().get("timestamp");
    //登录人员编号
    private String userid = Genius.getInstance().getCommonParts().get("userid");
    //角色
    private String roleid = Genius.getInstance().getCommonParts().get("roleid");
}

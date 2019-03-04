package cqdz.com.genius.http;

/**
 * 响应报文公共报文头
 */
public class GeniusResponse {
    //返回码
    private int code;
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    //错误信息
    private String msg;
}

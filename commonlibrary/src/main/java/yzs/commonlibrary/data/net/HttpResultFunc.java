package yzs.commonlibrary.data.net;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import yzs.commonlibrary.base.constant.SState;
import yzs.commonlibrary.util.ToastUtil;

/**
 * 接口返回结果处理
 * 有问题抛异常，没问题就返回数据
 * by Andy.Wu on 2016/7/5.
 */
public class HttpResultFunc<T> implements Function<HttpResult<T>, T> {

    /**
     * 状态码
     */
    public static final String RESPONSE_SUCCESS_CODE = "0";//成功
    public static final String RESPONSE_FAIL_CODE = "1";//失败
    public static final String RESPONSE_UNKNOWN_FAIL_CODE = "9999";//未知异常
    public static final String SEND_CHAT_MSG_FAIL = "30112";// 会话失效
    public static final String RESPONSE_TEAM_NO_EXIST = "20303";// 团队不存在
    public static final String RESPONSE_TEAM_DONE_AGREE = "50118";// 团队已审核-同意
    public static final String RESPONSE_TEAM_DONE_REFUSE = "50117";// 团队已审核-拒绝

    /**
     * 提示信息
     */
    public static final String CONNECT_FAIL_MSG = "连接请求出现问题，请您检查网络是否连接。";
    public static final String RESPONSE_FAIL_MSG = "请求服务器出现问题，请稍后再试。";
    public static final String RESPONSE_TOKEN_INVALID_MSG = "用户信息过期";

    @Override
    public T apply(@NonNull HttpResult<T> httpResult) throws Exception {
        if (!httpResult.getCode().equals(RESPONSE_SUCCESS_CODE)) {
            throw new ApiException(getApiExceptionMessage(httpResult.getCode(), httpResult.getMessage()),httpResult.getCode());
        }
        return httpResult.getData();

    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private String getApiExceptionMessage(String code,String message){
        switch (code) {
            case RESPONSE_FAIL_CODE://处理失败
                break;
            case RESPONSE_UNKNOWN_FAIL_CODE://未知异常
                message = RESPONSE_FAIL_MSG;
                break;
            case SEND_CHAT_MSG_FAIL://会话失效
                break;
            case SState.RESPONSE_TOKEN_INVALID: // token失效
            case SState.RESPONSE_TOKEN_INVALID_OTHER: //Token失效，异地登录
                ToastUtil.showMessage(RESPONSE_TOKEN_INVALID_MSG);
                tokenInvalid();
                break;
            default://其他类型的错误消息，按照服务端返回
                break;
        }
        return message;
    }

    /**
     * token失效
     */
    private void tokenInvalid() {
//        EventBus.getDefault().postSticky(new BusEvent.AbnormalLoginEvent(true, SState.RESPONSE_TOKEN_INVALID_MSG, false));
    }
}
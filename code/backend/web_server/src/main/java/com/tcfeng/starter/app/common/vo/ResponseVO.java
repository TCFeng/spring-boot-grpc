package com.tcfeng.starter.app.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResponseVO<T> {

    private T data;

    @ApiModelProperty(hidden = true)
    private String errorDesc;

    @ApiModelProperty(hidden = true)
    private String errorMsg;

    public static class Builder<T> implements VOBuilder<ResponseVO<T>> {

        private T data;

        private String errorDesc;

        private String errorMsg;

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> errorDesc(String errorDesc) {
            this.errorDesc = errorDesc;
            return this;
        }

        public Builder<T> errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        @Override
        public ResponseVO<T> build() {
            return new ResponseVO<>(this);
        }

    }

    public ResponseVO(Builder<T> builder) {
        this.data = builder.data;
        this.errorDesc = builder.errorDesc;
        this.errorMsg = builder.errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String geterrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}



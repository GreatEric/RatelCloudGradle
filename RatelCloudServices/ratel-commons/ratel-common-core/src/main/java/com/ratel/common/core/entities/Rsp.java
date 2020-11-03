package com.ratel.common.core.entities;

import lombok.Data;
import java.util.HashMap;

/**
 * RatelCloud
 * @ClassName: Rsp
 * @Package: com.ratel.common.core.entities
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: API返回信息
 * @Version: 1.0
 */
@Data
public class Rsp {
    private int code;
    private String msg;
    private HashMap<String, Object> data;

    public static Rsp success() {
        Rsp rsp = new Rsp();
        rsp.code = 1000;
        rsp.msg = "success";
        return rsp;
    }

    public static Builder builder() {
        return new Builder(new HashMap<String,Object>());
    }

    public static class Builder{
        private int code;
        private String msg;
        private HashMap<String, Object> dataMap;

        public Builder(HashMap<String, Object> dataMap){
            this.dataMap = dataMap;
        }

        public Builder success() {
            this.code = 1000;
            this.msg = "Success";
            return this;
        }

        public Builder error(StatusEntity entity) {
            this.code = entity.getCode();
            this.msg = entity.getMsg();
            return this;
        }

        public Builder add(String key, Object data) {
            this.dataMap.put(key,data);
            return this;
        }

        public Rsp build() {
            Rsp rsp = new Rsp();
            rsp.setCode(code);
            rsp.setMsg(msg);
            rsp.setData(dataMap);
            return rsp;
        }
    }
}
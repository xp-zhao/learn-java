package com.xp.lambda.compared;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@Data
@Builder
public class UrlParam {
    private String userIdent;
    private String IMEI;
    private String oaid;
    private String hwid;
    private String android_id;

    public static void main(String[] args) {
        UrlParam urlparam = UrlParam.builder()
                .IMEI("imei")
                .oaid("oa")
                .build();

        urlparam.setUserIdent(null);
        Optional.ofNullable(urlparam.getAndroid_id()).ifPresent(item -> urlparam.setUserIdent(item));
        Optional.ofNullable(urlparam.getHwid()).ifPresent(item -> urlparam.setUserIdent(item));
        Optional.ofNullable(urlparam.getOaid()).ifPresent(item -> urlparam.setUserIdent(item));
        Optional.ofNullable(urlparam.getIMEI()).ifPresent(item -> urlparam.setUserIdent(item));
        if (StringUtils.isEmpty(urlparam.getUserIdent())) {
            return;
        }
        System.out.println(urlparam.getUserIdent());
//        Optional<String> imei = Optional.ofNullable(urlparam.getIMEI());
//        Optional<String> oaid = Optional.ofNullable(urlparam.getOaid());
//        Optional<String> hwid = Optional.ofNullable(urlparam.getHwid());
//        Optional<String> android_id = Optional.ofNullable(urlparam.getAndroid_id());
//        String userIdent = imei.orElse(oaid.orElse(hwid.orElse(android_id.orElse(null))));
//        if (StringUtils.isEmpty(userIdent)) {
//            return;
//        }
//        urlparam.setUserIdent(userIdent);
    }
}

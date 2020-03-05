package com.tlswn.C71S3Tlswndemo.vo;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101300674236";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdsSNMOjJBfUFvdDYzZ+ebRkS9stuqRV4gNl6OgezFm/ftOOwshxd7yxtfFRI1HnSbMV06MQOPoKw0Oovo4JVKOxDjGO3yYv2YDF+2jMAMsFmRR0Sml3Dk6ty7/C7+IV2ZAXSVrFoLQftWIsEkMmfQRpKoloee53NvONUtcEjytLGPC4reJ5FJeCM1mIY1NfGMvtcEGoH9hzdt22WEslmVcf31p8D0t05S+ffgVUn/xVXv1vdqHrVYPC1yzQKVftH0/IOh0Gn+UdG53oGnMy6hU5X5EziV9DLkG9GFrKJD9VrbVwv7Fs5d4vqkLI8ZQQvje27ObeAAcvW96y5k/HZlAgMBAAECggEAdKNgY3KsV4ppSyIfMRjK1Cw+jj3sgt46SANPH4N0eZnq4Vl4P1tRAGzz+vlf9VBomZ4Cwhcc9jC3Dw67C+6KHlTgIcn/voh/4OZOKX2kU/5g0bdwTPS5OWmLCbT3oVtWmuTbshXAqJEOceDVEYwDA6gftHlbKSszU/IqpChonLPkm4+H+EEwqfBcXxtGU0jzmWQpLN4P1D4YvVuQlwzn67qyjFZE3WH2cJWUv0l/3obC390xyWR6MHsoXRkuZTitChFf1necVCuzk3GP63jZ/iSCOX6mA2tWQYdmwAmpNA6y0tM18f6o8Yph8/TnP+6nTxmInUxdCcm3wvi89ox7oQKBgQDmVnb4kRx+niOs1eZ2GAynRf8mQcKTH0HLGrGU6uKau1433yVmtJFJ3GEKRJ0bmw8xLK8KWif+6mSmfn8c9+C2egjssMT7bGF/80vJy9b4BG87Xoohe+TcPe+D9Z8rL1YeSGYvyHIvJ34ewQ/5PtUE6SbdoHAUrU+E9R4HaTtPSQKBgQCvQrgi/4mSJfztTm8AaQsm0/dIBP1HoCkvcpF6MExfqvC+MqR2QK7MU+6rfsci6uEM2gMXpq8j9BW+iqHmfX9sRX/lzKUninHa3Go3OcFb+KB6yVeitj2SGU66k9urLK7f31+nKgl4OKRZxTH07zw2DfzBQ8Pu2uJpbJizdVwCPQKBgBh6tfgiy+l0+wuiS/TfB3E7kitJr9kc6EwikR7ne5/AK/o6H+pzZEF6R2Hk+uF1MD8kpZGvFTMVTA8ZwH6epWYfQBWPj8+8q/wCKlrO7BC9v+iKWpnGZgM2Hd9jWkAnrrpXLW0Em4YBZ3jzQbRWhiMYeEXziBXaeWoC9ucIuwHpAoGAFR5MA+OY1yR+srWlyH3f2yDlhicbwfq5m78JapjRSyHU+oYtrRYkOfjPJJkVM87rqVnHz5zFM+bgi+I2mgh7RzekrrMXH4meKIowvlDWTNfLtp/2UGP3TViBVRgl+x1aQR2wb/svwu3IWAzb9TCyp6zNzRf2TxzO9Xche1Zj7N0CgYEAzUjcvT7Stun9OdIb9yjOlK5OoqIw8iAslrhwfBng4I2IBy9llpwVeWOx+uDXKe0GNk2/acgcVz0Ux4VpTosnmzx329j3fy1uHHz98QjU8vJR40TvfigX4DY7b9rq34benM2SOe2BuGn3Cv3uSUIJbvu1BEXjUqNWylTlLLIXRIw=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA02HRMEIYJo8AStFsX0DPVDcWhARuteiLJ03OVcPsHW644s8kM9EepVjiGHL8KbgdyEBxkLqltFVKCQjylkro7Kx+mhidhLTwcnzM2PT1D9FkcSRWrjbrJeoKoG1Sa+IDk07/uhUd23zsHpj5IRztc7eDTK2uTCMecfgeBITHqxYvpLk+mDR3qRXkvs4RhhUrm866Nj4KAjUXBoSLL+qsBxGrFqiyMIKTqrW33IzGqsha/GOtjQscYoNXHAa/YXpjGn6rOKOf81hjujoE5gCZgkEQ9YaTNOtrjhPFypU4/UV9ivVuDURXvpTB8woLGbxl9+12JFqknG7k6cczw7iRpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.baidu.com";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1/evaluate_{id}";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


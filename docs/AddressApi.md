# AddressApi

All URIs are relative to *https://ap-01.tapyrus.chaintope.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAddress**](AddressApi.md#createAddress) | **POST** /addresses | アドレスを生成して返します。
[**getAddresses**](AddressApi.md#getAddresses) | **GET** /addresses | これまで生成したアドレスを一覧にして返します。


<a name="createAddress"></a>
# **createAddress**
> String createAddress()

アドレスを生成して返します。

受金用のアドレス生成して返します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AddressApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    AddressApi apiInstance = new AddressApi(defaultClient);
    try {
      String result = apiInstance.createAddress();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressApi#createAddress");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |

<a name="getAddresses"></a>
# **getAddresses**
> GetAddressesResponse getAddresses(per, page)

これまで生成したアドレスを一覧にして返します。

これまで生成したアドレスを一覧にして返します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AddressApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    AddressApi apiInstance = new AddressApi(defaultClient);
    Integer per = 56; // Integer | 1ページあたりの件数
    Integer page = 56; // Integer | ページ番号
    try {
      GetAddressesResponse result = apiInstance.getAddresses(per, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AddressApi#getAddresses");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **per** | **Integer**| 1ページあたりの件数 | [optional]
 **page** | **Integer**| ページ番号 | [optional]

### Return type

[**GetAddressesResponse**](GetAddressesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |


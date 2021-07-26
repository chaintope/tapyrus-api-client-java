# UserApi

All URIs are relative to *https://ap-01.tapyrus.chaintope.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** /users | ユーザを作成します。
[**getUserInfo**](UserApi.md#getUserInfo) | **GET** /userinfo | ユーザの情報を返します。


<a name="createUser"></a>
# **createUser**
> createUser(createUserRequest)

ユーザを作成します。

OpenID Connect を使った認証で得た id_token と access_token を Tapyrus API へ登録しユーザを作成します。すでにユーザが存在する場合は認証情報を更新します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");

    UserApi apiInstance = new UserApi(defaultClient);
    CreateUserRequest createUserRequest = new CreateUserRequest(); // CreateUserRequest | 
    try {
      apiInstance.createUser(createUserRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#createUser");
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
 **createUserRequest** | [**CreateUserRequest**](CreateUserRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |

<a name="getUserInfo"></a>
# **getUserInfo**
> UserinfoResponse getUserInfo(confirmationOnly)

ユーザの情報を返します。

ユーザの&#x60;id&#x60;,&#x60;balance&#x60;, &#x60;address&#x60;の情報を返します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    UserApi apiInstance = new UserApi(defaultClient);
    Boolean confirmationOnly = true; // Boolean | オプションで`confirmation_only`を設定でき、`true`の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、`false`の場合未承認のtpc・トークンも含めて取得します。デフォルトは`true`です。
    try {
      UserinfoResponse result = apiInstance.getUserInfo(confirmationOnly);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#getUserInfo");
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
 **confirmationOnly** | **Boolean**| オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、&#x60;false&#x60;の場合未承認のtpc・トークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 | [optional]

### Return type

[**UserinfoResponse**](UserinfoResponse.md)

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


# TokenApi

All URIs are relative to *https://ap-01.tapyrus.chaintope.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**burnToken**](TokenApi.md#burnToken) | **DELETE** /tokens/{token_id}/burn | トークンの焼却
[**getTokens**](TokenApi.md#getTokens) | **GET** /tokens | トークンの総量取得
[**issueToken**](TokenApi.md#issueToken) | **POST** /tokens/issue | トークンの新規発行
[**reissueToken**](TokenApi.md#reissueToken) | **POST** /tokens/{token_id}/reissue | トークンの再発行
[**transferToken**](TokenApi.md#transferToken) | **PUT** /tokens/{token_id}/transfer | トークンの送付


<a name="burnToken"></a>
# **burnToken**
> burnToken(tokenId, amount)

トークンの焼却

任意の数のトークンを焼却します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TokenApi apiInstance = new TokenApi(defaultClient);
    String tokenId = "tokenId_example"; // String | トークンの識別子。
    Integer amount = 56; // Integer | `amount`を受け取り、指定した量のトークンを焼却します。 `amount`が未入力の場合全てのトークンを焼却します。 
    try {
      apiInstance.burnToken(tokenId, amount);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#burnToken");
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
 **tokenId** | **String**| トークンの識別子。 |
 **amount** | **Integer**| &#x60;amount&#x60;を受け取り、指定した量のトークンを焼却します。 &#x60;amount&#x60;が未入力の場合全てのトークンを焼却します。  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |

<a name="getTokens"></a>
# **getTokens**
> List&lt;GetTokensResponse&gt; getTokens(confirmationOnly)

トークンの総量取得

所有するトークンの総量を取得し、トークン識別子(&#x60;token_id&#x60;)ごとに総量(&#x60;amount&#x60;)を一覧で表示します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TokenApi apiInstance = new TokenApi(defaultClient);
    Boolean confirmationOnly = true; // Boolean | オプションで`confirmation_only`を設定でき、`true`の場合ブロックチェーン上で承認済みのトークンのみを取得し、`false`の場合未承認のトークンも含めて取得します。デフォルトは`true`です。
    try {
      List<GetTokensResponse> result = apiInstance.getTokens(confirmationOnly);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#getTokens");
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
 **confirmationOnly** | **Boolean**| オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのトークンのみを取得し、&#x60;false&#x60;の場合未承認のトークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 | [optional]

### Return type

[**List&lt;GetTokensResponse&gt;**](GetTokensResponse.md)

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
**500** | Internal Server Error |  -  |

<a name="issueToken"></a>
# **issueToken**
> TokenResponse issueToken(issueTokenRequest)

トークンの新規発行

任意の数のトークンを新規発行します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TokenApi apiInstance = new TokenApi(defaultClient);
    IssueTokenRequest issueTokenRequest = new IssueTokenRequest(); // IssueTokenRequest | `amount`を受け取り指定した数のトークンを新規発行します。 任意で`token_type`を設定し、トークンの種類を指定できます。 `token_type`が未指定な場合、再発行可能なトークンが発行されます。 トークンの種類は以下の通りです。 - 1: 再発行可能なトークン - 2: 再発行不可能なトークン - 3: NFT  また、`token_type`が未指定または`1`の場合、任意でトークン識別子`id`を指定することで、指定したトークン識別子のトークンを再発行します。 
    try {
      TokenResponse result = apiInstance.issueToken(issueTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#issueToken");
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
 **issueTokenRequest** | [**IssueTokenRequest**](IssueTokenRequest.md)| &#x60;amount&#x60;を受け取り指定した数のトークンを新規発行します。 任意で&#x60;token_type&#x60;を設定し、トークンの種類を指定できます。 &#x60;token_type&#x60;が未指定な場合、再発行可能なトークンが発行されます。 トークンの種類は以下の通りです。 - 1: 再発行可能なトークン - 2: 再発行不可能なトークン - 3: NFT  また、&#x60;token_type&#x60;が未指定または&#x60;1&#x60;の場合、任意でトークン識別子&#x60;id&#x60;を指定することで、指定したトークン識別子のトークンを再発行します。  | [optional]

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

<a name="reissueToken"></a>
# **reissueToken**
> TokenResponse reissueToken(tokenId, reissueTokenRequest)

トークンの再発行

指定した識別子を持つ再発行可能なトークンを任意の量再発行します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TokenApi apiInstance = new TokenApi(defaultClient);
    String tokenId = "tokenId_example"; // String | トークンの識別子。
    ReissueTokenRequest reissueTokenRequest = new ReissueTokenRequest(); // ReissueTokenRequest | 
    try {
      TokenResponse result = apiInstance.reissueToken(tokenId, reissueTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#reissueToken");
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
 **tokenId** | **String**| トークンの識別子。 |
 **reissueTokenRequest** | [**ReissueTokenRequest**](ReissueTokenRequest.md)|  | [optional]

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |

<a name="transferToken"></a>
# **transferToken**
> TokenResponse transferToken(tokenId, transferTokenRequest)

トークンの送付

任意の数のトークンを指定したアドレスに対して送付します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TokenApi apiInstance = new TokenApi(defaultClient);
    String tokenId = "tokenId_example"; // String | トークンの識別子。
    TransferTokenRequest transferTokenRequest = new TransferTokenRequest(); // TransferTokenRequest | `address`でトークンを送付する相手のアドレスを指定し、`amount`で送付するトークンの量を指定します。
    try {
      TokenResponse result = apiInstance.transferToken(tokenId, transferTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#transferToken");
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
 **tokenId** | **String**| トークンの識別子。 |
 **transferTokenRequest** | [**TransferTokenRequest**](TransferTokenRequest.md)| &#x60;address&#x60;でトークンを送付する相手のアドレスを指定し、&#x60;amount&#x60;で送付するトークンの量を指定します。 |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**422** | Unprocessable Entity |  -  |
**500** | Internal Server Error |  -  |


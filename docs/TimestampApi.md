# TimestampApi

All URIs are relative to *https://ap-01.tapyrus.chaintope.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTimestamp**](TimestampApi.md#addTimestamp) | **POST** /timestamp | Timestampを記録
[**getTimestamps**](TimestampApi.md#getTimestamps) | **GET** /timestamps | Timestamp一覧表示


<a name="addTimestamp"></a>
# **addTimestamp**
> addTimestamp(addTimestampRequest)

Timestampを記録

ブロックチェーンにハッシュ値をタイムスタンプとして記録します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TimestampApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TimestampApi apiInstance = new TimestampApi(defaultClient);
    AddTimestampRequest addTimestampRequest = new AddTimestampRequest(); // AddTimestampRequest | `content_hash`, `prefix`を受け取り、ブロックチェーンにハッシュ値をタイムスタンプとして記録します。
    try {
      apiInstance.addTimestamp(addTimestampRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling TimestampApi#addTimestamp");
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
 **addTimestampRequest** | [**AddTimestampRequest**](AddTimestampRequest.md)| &#x60;content_hash&#x60;, &#x60;prefix&#x60;を受け取り、ブロックチェーンにハッシュ値をタイムスタンプとして記録します。 | [optional]

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
**422** | Bad Request |  -  |

<a name="getTimestamps"></a>
# **getTimestamps**
> List&lt;Object&gt; getTimestamps()

Timestamp一覧表示

ブロックチェーンに記録したタイムスタンプを取得し、&#x60;content_hash&#x60;,&#x60;prefix&#x60;,&#x60;txid&#x60;を一覧で表示します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TimestampApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    TimestampApi apiInstance = new TimestampApi(defaultClient);
    try {
      List<Object> result = apiInstance.getTimestamps();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TimestampApi#getTimestamps");
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

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | success |  -  |
**400** | Bad Request |  -  |

